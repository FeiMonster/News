package monster.com.gdcpformonster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import monster.com.gdcpformonster.R;

/**
 * Created by ASUS on 2017/5/18.
 */
public class LoginActivity extends AppCompatActivity{
    private TextView tv_regist;
    private EditText edt_id;
    private EditText edt_password;
    private Button btn_login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(LoginActivity.this,"0f2fe96dc3f5c82420412e415f973d21");
        initViews();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录操作跳转
                String loginId = edt_id.getText().toString().trim();
                String loginPassword = edt_password.getText().toString().trim();
                BmobUser user = new BmobUser();
                user.setUsername(loginId);
                user.setPassword(loginPassword);
                user.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e == null){
                            //登录成功，跳转
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                            Intent intent2 = new Intent(LoginActivity.this,WoAcitvity.class);
                            startActivity(intent2);

                        }else {
                            Toast.makeText(LoginActivity.this,"账号密码错误",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
        tv_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActvity.class));
            }
        });
    }

    private void initViews() {
        tv_regist = (TextView) findViewById(R.id.tv_regist);
        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
    }
}
