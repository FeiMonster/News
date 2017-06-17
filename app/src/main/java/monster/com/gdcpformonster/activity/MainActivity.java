package monster.com.gdcpformonster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.fragment.HomeFragment;
import monster.com.gdcpformonster.fragment.MeFragment;
import monster.com.gdcpformonster.fragment.NewsFragment;
import monster.com.gdcpformonster.fragment.VideoFragment;
import monster.com.gdcpformonster.share.AndroidShare;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    //底部的4个导航控件
    private LinearLayout tab_home;
    private LinearLayout tab_news;
    private LinearLayout tab_video;
    private LinearLayout tab_me;
    //底部4个导航控件中的图片按钮
    private ImageButton ivb_home;
    private ImageButton ivb_news;
    private ImageButton ivb_video;
    private ImageButton ivb_me;
    //初始化4个Fragment
    private Fragment fragment_home;
    private Fragment fragment_news;
    private Fragment fragment_video;
    private Fragment fragment_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(MainActivity.this,"0f2fe96dc3f5c82420412e415f973d21");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("             广交趣事");
        setSupportActionBar(toolbar);
        initView();//初始化所有的view
        initEvents();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        setSelect(0);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initEvents() {
        tab_home.setOnClickListener(this);
        tab_news.setOnClickListener(this);
        tab_video.setOnClickListener(this);
        tab_me.setOnClickListener(this);

    }

    /**
     * 初始化所以数据
     */
    private void initView() {
        tab_home = (LinearLayout) findViewById(R.id.tab_home);
        tab_news = (LinearLayout) findViewById(R.id.tab_news);
        tab_video = (LinearLayout) findViewById(R.id.tab_video);
        tab_me = (LinearLayout) findViewById(R.id.tab_me);
        ivb_home = (ImageButton) findViewById(R.id.ivb_home);
        ivb_news = (ImageButton) findViewById(R.id.ivb_news);
        ivb_video = (ImageButton) findViewById(R.id.ivb_video);
        ivb_me = (ImageButton) findViewById(R.id.ivb_me);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            BmobUser u = BmobUser.getCurrentUser();
            if(u != null){
                startActivity(new Intent(MainActivity.this,WoAcitvity.class));
            }else {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            AndroidShare as = new AndroidShare(this,"来自广交趣事的分享","http://img6.cache.netease.com/cnews/news2012/img/logo_news.png");
            as.show();

        } else if (id == R.id.nav_send) {
            //退出界面
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.tab_home://当点击Home按钮时，切换图片为亮色，切换fragment为Home界面
                setSelect(0);
                break;
            case R.id.tab_news:
                setSelect(1);
                break;
            case R.id.tab_video:
                setSelect(2);
                break;
            case R.id.tab_me:
                setSelect(3);
                break;

            default:
                break;
        }
    }
    /*
	 * 将图片设置为亮色的；切换显示内容的fragment
	 * */
    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();//创建一个事务
        hideFragment(transaction);//我们先把所有的Fragment隐藏了，然后下面再开始处理具体要显示的Fragment
        switch (i) {
            case 0:
                if (fragment_home == null) {
                    fragment_home = new HomeFragment();
				/*
				 * 将Fragment添加到活动中，public abstract FragmentTransaction add (int containerViewId, Fragment fragment)
				*containerViewId即为Optional identifier of the container this fragment is to be placed in. If 0, it will not be placed in a container.
				 * */
                    transaction.add(R.id.fragment_content, fragment_home);
                }else {
                    transaction.show(fragment_home);
                }
                ivb_home.setImageResource(R.drawable.home_press);
                break;
            case 1:
                if (fragment_news == null) {
                    fragment_news = new NewsFragment();
                    transaction.add(R.id.fragment_content, fragment_news);
                }else {
                    transaction.show(fragment_news);
                }
                ivb_news.setImageResource(R.drawable.news_press);
                break;
            case 2:
                if (fragment_video == null) {
                    fragment_video = new VideoFragment();
                    transaction.add(R.id.fragment_content, fragment_video);
                }else {
                    transaction.show(fragment_video);
                }
                ivb_video.setImageResource(R.drawable.video_press);
                break;
            case 3:
                if (fragment_me == null) {
                    fragment_me = new MeFragment();
                    transaction.add(R.id.fragment_content, fragment_me);
                }else {
                    transaction.show(fragment_me);
                }
                ivb_me.setImageResource(R.drawable.me_press);
                break;

            default:
                break;
        }
        transaction.commit();//提交事务
    }

    /*
     * 隐藏所有的Fragment
     * */
    private void hideFragment(FragmentTransaction transaction) {
        if (fragment_home != null) {
            transaction.hide(fragment_home);
        }
        if (fragment_news != null) {
            transaction.hide(fragment_news);
        }
        if (fragment_video != null) {
            transaction.hide(fragment_video);
        }
        if (fragment_me != null) {
            transaction.hide(fragment_me);
        }

    }
    private void resetImg() {
        ivb_home.setImageResource(R.drawable.home);
        ivb_news.setImageResource(R.drawable.news);
        ivb_video.setImageResource(R.drawable.video);
        ivb_me.setImageResource(R.drawable.me);
    }
}
