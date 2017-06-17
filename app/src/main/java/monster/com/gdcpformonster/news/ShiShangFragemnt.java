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

public class ShiShangFragemnt extends Fragment {
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
        banner_url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494753714481&di=e8f0c83473bb210a0a97daea9f37349c&imgtype=0&src=http%3A%2F%2Fwww.mwjx.com%2Fdata%2Fup_pics%2F0d%2F0d68a6e6e980168a590e671911179945.jpg");
        banner_url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495348545&di=16fad2dcc2981f33a63ae75374444118&imgtype=jpg&er=1&src=http%3A%2F%2Fpic14.photophoto.cn%2F20100317%2F0010023193178388_b.jpg");
        banner_url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495348594&di=51ae00b01bffee33842717008bd06a62&imgtype=jpg&er=1&src=http%3A%2F%2Fimages.17173.com%2F2014%2Fxyq%2F2014%2F02%2F12%2F20140212131814127.jpg");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/12 11:21");
        News n2 = new News(R.drawable.xiaohua1,"做人要有底线!”食人族道,“你的底线是什么?“吃人要吐骨头。””","2017/5/14 14:02");
        News n3 = new News(R.drawable.xiaohua2,"路边看到一个乞丐，心生不忍，便往他碗里放了10块钱....","2017/5/13 14:02");
        News n4 = new News(R.drawable.xiaohua3,"我给你讲个冷笑话吧,好啊，快讲，我讲完了。","2017/5/13 10:35");
        News n5 = new News(R.drawable.xiaohua4,"把我好友老陈的一些观点说给另一个朋友听。“老陈(老臣)有句话”、“老陈以为”","2017/5/12 18:46");
        News n6 = new News(R.drawable.xiaohua5,"一个人喝牛奶喝死了，到了天堂有人问他，你怎么那么年轻就死了，他说....","2017/5/11 3:41");
        News n7 = new News(R.drawable.xiaohua6,"晚饭后，在老婆在公园散步，她对我说：老公，我想要天上的月亮…","2017/5/10 12:41");
        News n8 = new News(R.drawable.xiaohua7,"班到半夜，拖着疲惫的身躯回家，发现客厅还亮着橘黄色的灯，而妻子已经在沙发上睡着......","2017/5/10 16:57");
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
