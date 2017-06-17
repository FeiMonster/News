package monster.com.gdcpformonster.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import monster.com.gdcpformonster.activity.VideoActivity1;
import monster.com.gdcpformonster.activity.VideoActivity2;
import monster.com.gdcpformonster.adapter.NewsDecoration;
import monster.com.gdcpformonster.adapter.VideoAdapter;
import monster.com.gdcpformonster.bean.VideoBean;

/**
 * Created by ASUS on 2017/5/9.
 */

public class VideoFragment extends Fragment {
    private RecyclerView video_recyclerView;
    private List<VideoBean> videoDatas;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //引入我们的布局
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        video_recyclerView = (RecyclerView) view.findViewById(R.id.video_recyclerView);
        initDatas();
        video_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VideoAdapter adapter = new VideoAdapter(getActivity(),videoDatas);
        video_recyclerView.setAdapter(adapter);
        video_recyclerView.addItemDecoration(new NewsDecoration(getActivity(),NewsDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new VideoAdapter.ClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                            if(postion ==  0){
                                startActivity(new Intent(getActivity(),VideoActivity1.class));
                            }else if(postion == 1){
                                startActivity(new Intent(getActivity(),VideoActivity2.class));
                            }
            }
        });
        return view;
    }

    private void initDatas() {
        videoDatas = new ArrayList<>();
        VideoBean b1 = new VideoBean("想念，从春天最后一片落叶开始,超美鸡汤来袭","2017/05/15 15:30",R.drawable.video1);
        VideoBean b2 = new VideoBean("合租时遇到小情侣叫床怎么办?看看萌妹子怎么回答。","2017/05/14 16:52",R.drawable.video2);
        VideoBean b3 = new VideoBean("【独播】「科技龙卷风」电脑勒索病毒之谜 始作俑者竟是美国","2017/05/14",R.drawable.video3);
        VideoBean b4 = new VideoBean("辣眼睛！乌克兰美女上街游行,元芳，你怎么看？","2017/05/12 12:01",R.drawable.video4);
        VideoBean b5 = new VideoBean("歌迷称韩红为祖师爷？这是因何缘故？","2017/05/12 17:01",R.drawable.video5);
        VideoBean b6 = new VideoBean("这个萌妹子妹子魔鬼般身材，单身狗们的福利来了","2017/05/11 13:01",R.drawable.video6);
        VideoBean b7 = new VideoBean("5男子扒光12岁男童抽打，究竟是道德的沦陷还是人性的丧失","2017/05/11 9:01",R.drawable.video7);
        videoDatas.add(b1);
        videoDatas.add(b2);
        videoDatas.add(b3);
        videoDatas.add(b4);
        videoDatas.add(b5);
        videoDatas.add(b6);
        videoDatas.add(b7);
    }
}
