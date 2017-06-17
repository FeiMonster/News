package monster.com.gdcpformonster.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.activity.ActivityNews1;
import monster.com.gdcpformonster.adapter.NewsAdapter;
import monster.com.gdcpformonster.adapter.NewsDecoration;
import monster.com.gdcpformonster.bean.News;

/**
 * Created by ASUS on 2017/5/11.
 */

public class WenHuaFragemnt extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> banner_url;
    private List<News> news;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_toutiao, container, false);
        initData();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.one_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NewsAdapter adapter = new NewsAdapter(getActivity(),banner_url,news);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new NewsDecoration(getActivity(),NewsDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int postion) {
                Log.d("TAG","我被点击了");
                if(postion == 1){
                    Log.d("TAG","第一条被点击了");
                    Intent inent = new Intent(getActivity(),ActivityNews1.class);
                    startActivity(inent);
                }

            }
        });
        return view;
    }

    private void initData() {
        banner_url = new ArrayList<String>();
        banner_url.add("http://a1.gdcp.cn/UploadFile/2390/2017/3/27/201732795712580.png");
        banner_url.add("http://a1.gdcp.cn/UploadFile/2390/2017/4/8/20174822920242.png");
        banner_url.add("http://a1.gdcp.cn/UploadFile/2390/2017/4/14/20174149312738.png");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/12 11:21");
        News n2 = new News(R.drawable.wenhua1,"运输管理学院召开学生综合能力提升交流会””","2017/5/14 14:02");
        News n3 = new News(R.drawable.wenhua2,"广交院领导动员大会圆满成功，各位领导都很积极","2017/5/13 14:02");
        News n4 = new News(R.drawable.wenhua3,"汽车与工程机械学院举行协同人才培养汽车服务工程专业专家论证会。","2017/5/13 10:35");
        News n5 = new News(R.drawable.wenhua4,"我校与泰国滕博雅教育集团签署合作框架协议，开启一带一路新篇章。","2017/5/12 18:46");
        News n6 = new News(R.drawable.wenhua5,"英语讲座于今晚开启，连续10天的英语盛宴你准备好了吗？","2017/5/11 3:41");
        News n7 = new News(R.drawable.wenhua6,"暨大、华农、广外档案馆同仁来我校交流。","2017/5/10 12:41");
        News n8 = new News(R.drawable.wenhua7,"我校钟宇霞老师获得2016年“广东省高校学生资助工作先进工作者”荣誉称号。","2017/5/10 16:57");
        news.add(n1);
        news.add(n2);
        news.add(n3);
        news.add(n4);
        news.add(n5);
        news.add(n6);
        news.add(n7);
        news.add(n8);
    }
}
