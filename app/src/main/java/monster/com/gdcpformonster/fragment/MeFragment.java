package monster.com.gdcpformonster.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.activity.ActivityNews2;
import monster.com.gdcpformonster.view.FlowGroupView;

/**
 * Created by ASUS on 2017/5/9.
 */

public class MeFragment extends Fragment {
    ArrayList<String> names = new ArrayList<String>();
    private FlowGroupView mFlowGroupView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //引入我们的布局
        View view =  inflater.inflate(R.layout.fragment_me, container, false);
        initData();
        mFlowGroupView = (FlowGroupView) view.findViewById(R.id.flowgroupview);
        for (int i = 0; i < names.size(); i++) {
            addTextView(names.get(i));
        }

        return view;
    }

    private void addTextView(String str) {
        TextView child = new TextView(getContext());
        MarginLayoutParams params = new MarginLayoutParams(MarginLayoutParams.WRAP_CONTENT, MarginLayoutParams.WRAP_CONTENT);
        params.setMargins(15, 15, 15, 15);
        child.setLayoutParams(params);
        child.setBackgroundResource(R.drawable.text_background);
        child.setText(str);
        child.setTextColor(Color.WHITE);
        initEvents(child);//监听
        mFlowGroupView.addView(child);
    }

    private void initEvents(final TextView tv) {
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getActivity(),ActivityNews2.class));
            }
        });
    }

    private void initData() {
        names.add("女生宿舍频频被盗");
        names.add("38栋721优秀宿舍");
        names.add("广交技能大赛得奖");
        names.add("广交摇滚歌手黄汐航");
        names.add("广交优秀学子彭冠铭");
        names.add("交际花林佳荣");
        names.add("打狗棍法");
        names.add("蛤蟆功");
        names.add("极品美女");
        names.add("一招半式闯江湖");
        names.add("撩妹技术教学");
        names.add("龙蛇虎豹");
        names.add("葵花宝典");
        names.add("吸星大法");
        names.add("如来神掌警示牌");

        }
    }