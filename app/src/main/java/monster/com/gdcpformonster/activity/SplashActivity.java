package monster.com.gdcpformonster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.utils.PrefUtils;
public class SplashActivity extends AppCompatActivity {
    public RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_root = (RelativeLayout) findViewById(R.id.rt_root);
        //设置旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        //设置动画的时间
        rotateAnimation.setDuration(1000);
        //保持动画结束状态
        rotateAnimation.setFillAfter(true);

        //设置缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        //设置动画的时间
        rotateAnimation.setDuration(1000);
        //保持动画结束状态
        rotateAnimation.setFillAfter(true);

        //设置渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        //设置动画的时间
        rotateAnimation.setDuration(2000);
        //保持动画结束状态
        rotateAnimation.setFillAfter(true);

        //动画集合
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        //启动动画
        rl_root.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                boolean is_first_enter = PrefUtils.getBoolean(SplashActivity.this, "is_first_enter", true);
                Intent intent;
                if(is_first_enter){
                    //第一次进入，引导界面
                    intent = new Intent(SplashActivity.this,GuideAcitvity.class);
                }else{
                    //不是第一次，进入主界面
                    intent = new Intent(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        });
    }
}
