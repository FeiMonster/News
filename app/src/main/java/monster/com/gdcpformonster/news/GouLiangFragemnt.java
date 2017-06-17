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

public class GouLiangFragemnt extends Fragment {
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
        banner_url.add("http://img2.imgtn.bdimg.com/it/u=3585747433,2861691023&fm=23&gp=0.jpg");
        banner_url.add("http://img3.imgtn.bdimg.com/it/u=113463765,1870877604&fm=23&gp=0.jpg");
        banner_url.add("http://img5.imgtn.bdimg.com/it/u=864549055,1488522808&fm=23&gp=0.jpg");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/12 11:21");
        News n2 = new News(R.drawable.gouliang1,"下雨天广交操场小情侣公然秀恩爱虐狗！！","2017/5/14 14:02");
        News n3 = new News(R.drawable.gouliang2,"原来你是我最想留住的幸运，原来我们和爱情曾靠的那么就。","2017/5/13 14:02");
        News n4 = new News(R.drawable.gouliang3,"你有没有幻想过自己读书上课时旁边有一位伴侣？","2017/5/13 10:35");
        News n5 = new News(R.drawable.gouliang4,"广交院某男生与女友交往长达7年，这是否是你吃过的最饱的狗粮","2017/5/12 18:46");
        News n6 = new News(R.drawable.gouliang5,"傍晚的广交院原来也可以这么美，有佳人陪伴就是好","2017/5/11 3:41");
        News n7 = new News(R.drawable.gouliang6,"女生和女生原来也可以这么亲密地如情侣般，这比狗粮还厉害。","2017/5/10 12:41");
        News n8 = new News(R.drawable.gouliang7,"校园惊现基情，目前校方已确认彭冠铭与谢嘉华两人关系。","2017/5/10 16:57");
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
