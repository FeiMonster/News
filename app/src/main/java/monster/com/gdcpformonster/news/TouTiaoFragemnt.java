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

public class TouTiaoFragemnt extends Fragment {
    private RecyclerView one_recyclerview;
    private List<String> banner_url;
    private List<News> news;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toutiao, container, false);
        initData();
        one_recyclerview = (RecyclerView) view.findViewById(R.id.one_recyclerview);
        one_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        NewsAdapter adapter = new NewsAdapter(getActivity(),banner_url,news);
        one_recyclerview.setAdapter(adapter);
        one_recyclerview.addItemDecoration(new NewsDecoration(getActivity(),NewsDecoration.VERTICAL_LIST));
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
        banner_url.add("http://a1.gdcp.cn/UploadFile/2390/2017/5/11/201751174353167.png");
        banner_url.add("http://a1.gdcp.cn/UploadFile/2390/2017/5/11/2017511203548769.png");
        banner_url.add("http://a1.gdcp.cn/UploadFile/2390/2017/5/12/201751285039928.png");
        news = new ArrayList<News>();
        News n1 = new News(R.drawable.news1,"广州科技职业技术学院同行来我校图书馆参观交流,颇有感受","2017/5/12 19:21");
        News n2 = new News(R.drawable.news2,"我校荣获2017年全国职业院校技能大赛“计算机网络应用”赛项一等奖","2017/5/11 14:02");
        News n3 = new News(R.drawable.news1,"广州科技职业技术学院同行来我校图书馆参观交流,颇有感受","2017/5/12 12:35");
        News n4 = new News(R.drawable.news3,"土木工程学院举办第九届Auto CAD制图大赛","2017/5/11 9:15");
        News n5 = new News(R.drawable.news4,"第四届会展技能综合大赛总决赛圆满结束","2017/5/11 15:21");
        News n6 = new News(R.drawable.news5,"运输管理学院第四届管理文化节开幕式暨班级风采汇隆重举行","2017/5/10 16:41");
        News n7 = new News(R.drawable.news6,"我校深入调研探索创新创业教育新模式","2017/5/10 16:57");
        News n8 = new News(R.drawable.new7,"坚持正确选人用人导向，建设高素质干部教师队伍","2017/5/9 10:37");
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

