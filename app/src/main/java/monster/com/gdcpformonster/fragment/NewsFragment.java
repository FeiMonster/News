package monster.com.gdcpformonster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.news.SuSheFragemnt;
import monster.com.gdcpformonster.news.WenHuaFragemnt;
import monster.com.gdcpformonster.news.KeJiFragemnt;
import monster.com.gdcpformonster.news.KaoShiFragemnt;
import monster.com.gdcpformonster.news.ShiShangFragemnt;
import monster.com.gdcpformonster.news.GouLiangFragemnt;
import monster.com.gdcpformonster.news.TouTiaoFragemnt;
import monster.com.gdcpformonster.news.YuLeFragemnt;

/**
 * Created by ASUS on 2017/5/9.
 */

public class NewsFragment  extends Fragment {
    private ViewPager pager;
    private TabPageIndicator indicator;
    private View view;
    private ArrayList<Fragment> fragments;
    /**
     * Tab标题
     */
    private static final String[] titles = new String[] { "头条", "考试", "宿舍", "娱乐",
            "狗粮", "文化", "科技", "笑话" };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //引入我们的布局
        view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initData();
        TabPageIndicatorAdapter adapter = new TabPageIndicatorAdapter(getFragmentManager(),fragments,titles);
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        /**
         * 监听
         */
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initData() {
        fragments = new ArrayList<>();
        TouTiaoFragemnt f1 = new TouTiaoFragemnt();
        KaoShiFragemnt f2 = new KaoShiFragemnt();
        SuSheFragemnt f3 = new SuSheFragemnt();
        YuLeFragemnt f4 = new YuLeFragemnt();
        GouLiangFragemnt f5 = new GouLiangFragemnt();
        WenHuaFragemnt f6 = new WenHuaFragemnt();
        KeJiFragemnt f7 = new KeJiFragemnt();
        ShiShangFragemnt f8 = new ShiShangFragemnt();
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);
        fragments.add(f5);
        fragments.add(f6);
        fragments.add(f7);
        fragments.add(f8);
    }

    class TabPageIndicatorAdapter extends FragmentPagerAdapter{
        private ArrayList<Fragment> fragments;
        String[] titles;

        public TabPageIndicatorAdapter(FragmentManager fm,ArrayList<Fragment> fragments,String[] titles) {
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles != null ? titles[position] : super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    private void initViews() {
        pager = (ViewPager) view.findViewById(R.id.pager);
        indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
    }


    /*private void RequestServer() {
        RequestParams params = new RequestParams("https://www.baidu.com/s");
        params.addQueryStringParameter("wd", "xUtils");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("请求结果",result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinished() {

            }
        });
    }*/
}
