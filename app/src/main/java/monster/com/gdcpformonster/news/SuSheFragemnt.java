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

public class SuSheFragemnt extends Fragment {
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
        banner_url.add("http://www.people.com.cn/mediafile/pic/20140513/7/17938741636538994463.jpg");
        banner_url.add("http://imgsrc.baidu.com/forum/pic/item/54fbb2fb43166d229a044315462309f79152d2c4.jpg");
        banner_url.add("http://img0w.pconline.com.cn/pconline/1202/14/2673287_06.jpg");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/12 11:21");
        News n2 = new News(R.drawable.sushe1,"广交院38栋721宿舍被评为广交第一优秀宿舍。","2017/5/14 14:02");
        News n3 = new News(R.drawable.sushe2,"女生宿舍频频被盗，究竟是人性的缺失还是道德的沦丧？","2017/5/13 14:02");
        News n4 = new News(R.drawable.sushe3,"今日领导大规模检查宿舍，有一番大收获。","2017/5/13 10:35");
        News n5 = new News(R.drawable.sushe4,"惊人发现广交学子彭冠铭同学的宿舍竟是如此！","2017/5/12 18:46");
        News n6 = new News(R.drawable.sushe5,"女子在宿舍飘飘起舞，究竟是多么热爱舞蹈？","2017/5/11 3:41");
        News n7 = new News(R.drawable.sushe6,"宿舍生活不尽相同，你是宿舍中的哪一种人？","2017/5/10 12:41");
        News n8 = new News(R.drawable.sushe7,"看看大学屌丝的宿舍生活，游戏加外卖就是一天！。","2017/5/10 16:57");
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
