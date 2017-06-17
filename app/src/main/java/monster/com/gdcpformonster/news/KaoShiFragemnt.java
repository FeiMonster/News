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

public class KaoShiFragemnt extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> banner_url;
    private List<News> news;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toutiao, container, false);
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
        banner_url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494738180273&di=b4aaf93e9c81ff6c45552fd2fede3791&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20151015%2Fmp35791783_1444886450068_1_th.jpeg");
        banner_url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495333077&di=7b8dddac5a5aac4a19550f3dc5fbc7c2&imgtype=jpg&er=1&src=http%3A%2F%2Fupload.ldnews.cn%2F2014%2F0507%2F1399452608231.jpg");
        banner_url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494738311697&di=3dd432cc06994fb9e3d03a2048ab9f4f&imgtype=0&src=http%3A%2F%2Fwww.xnec.cn%2Fuploadxnec%2F201310%2F20131031105132680.jpg");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/12 11:21");
        News n2 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/14 11:21");
        News n3 = new News(R.drawable.kaoshi2,"今天下午北校图书馆的“读经典，猜灯谜”活动你去参加了吗？","2017/5/13 14:02");
        News n4 = new News(R.drawable.kaoshi3,"15软件一班迎来软件测试期中考试，大家都求神拜佛，求不要挂科。","2017/5/12 8:35");
        News n5 = new News(R.drawable.kaoshi4,"广交院2015级积极份子考核于今天上午进行","2017/5/11 10:45");
        News n6 = new News(R.drawable.kaoshi5,"考试有诀窍？看我校软件班如何应付笔试考试。","2017/5/11 3:41");
        News n7 = new News(R.drawable.kaoshi6,"当代学生对考试的恐惧已经压力超出了领导的了解范围","2017/5/10 16:41");
        News n8 = new News(R.drawable.kaoshi7,"高考快来了，你紧张吗？紧张个毛，还好我是个大学生了。","2017/5/10 16:57");
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
