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

public class YuLeFragemnt extends Fragment {
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
        banner_url.add("http://pic.58pic.com/58pic/11/62/60/83458PICFPa.jpg");
        banner_url.add("http://a1.gdcp.cn/UploadFile/2390/2017/4/26/2017426192444388.png");
        banner_url.add("http://www.wazx.net/wazx/uploadfile/jpg/2015-5/2015xysjgs/2015511010.jpg");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/12 11:21");
        News n2 = new News(R.drawable.yule1,"第七届轨道文化节开幕式暨轨道班级合唱比赛完美落幕","2017/5/14 14:02");
        News n3 = new News(R.drawable.yule2,"校园十大歌手完美落幕，今晚，你们是校园的明星。","2017/5/13 14:02");
        News n4 = new News(R.drawable.yule3,"听说今天广交院有免费冰激凌？没错，快来水塔旁边领吧","2017/5/13 10:35");
        News n5 = new News(R.drawable.yule4,"你相信自己的支持能力吗？那么快来广播大赛吧！","2017/5/12 18:46");
        News n6 = new News(R.drawable.yule5,"周杰伦广交演唱会第五场圆满成功，并邀请校园摇滚歌手黄汐航同台","2017/5/11 3:41");
        News n7 = new News(R.drawable.yule6,"校园斗殴？学生反驳声称称这是一种娱乐模式！","2017/5/10 12:41");
        News n8 = new News(R.drawable.yule7,"操场最美的一角，美女惊现此地。","2017/5/10 16:57");
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
