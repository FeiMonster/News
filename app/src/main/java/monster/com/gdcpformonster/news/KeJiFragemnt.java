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

public class KeJiFragemnt extends Fragment {
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
        banner_url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494752325737&di=203a6e95997ff5b930fc97008bb86a01&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F17%2F95%2F72%2F76d58PICmbH_1024.jpg");
        banner_url.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3495791528,117483091&fm=23&gp=0.jpg");
        banner_url.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1147020590,298125646&fm=23&gp=0.jpg");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.kaoshi1,"今日，公务员考试在广交院进行，很是热闹","2017/5/12 11:21");
        News n2 = new News(R.drawable.keji1,"喜讯：广东交通职业技术学院第一枚原子弹产生","2017/5/14 14:02");
        News n3 = new News(R.drawable.keji2,"今日，由15软件1班同学共同研究的全透明手机正式在广交发布。","2017/5/13 14:02");
        News n4 = new News(R.drawable.keji3,"校园网游神话于今日上线安卓端，你准备好了吗？","2017/5/13 10:35");
        News n5 = new News(R.drawable.keji4,"广交汽车学院学生了不起，研究出一款速度能与飞机相比的汽车，型号M1","2017/5/12 18:46");
        News n6 = new News(R.drawable.keji5,"这究竟是一个挖掘机还是一个机器人，我们的回答是两个都是！","2017/5/11 3:41");
        News n7 = new News(R.drawable.keji6,"号外：广交院李小飞同学发明出一款2TB储存容量的u盘","2017/5/10 12:41");
        News n8 = new News(R.drawable.keji7,"没错，这就是一个3d宿舍，进来让你身临其境，快来38栋721体验吧。","2017/5/10 16:57");
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
