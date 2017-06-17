package monster.com.gdcpformonster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.bean.VideoBean;

/**
 * Created by ASUS on 2017/5/15.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private Context mContext;
    private List<VideoBean> videoDatas;
    private ClickListener clickListener;
    public VideoAdapter(Context context,List<VideoBean> list){
        this.mContext =context;
        this.videoDatas  = list;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = LayoutInflater.from(mContext).inflate(R.layout.video_item
                , parent, false);
        holder = new MyViewHolder(view,clickListener);
        return (MyViewHolder) holder;
    }
    public void setOnItemClickListener(ClickListener listener) {
        this.clickListener = listener;
    }
    public interface ClickListener {
        public void onItemClick(View view, int postion);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VideoBean bean = videoDatas.get(position);
        holder.video_text.setText(bean.getContext());
        holder.video_time.setText(bean.getDate());
        holder.video_image.setImageResource(bean.getVideoImage());

    }

    @Override
    public int getItemCount() {
        return videoDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ClickListener mListener;// 声明自定义的接口
        TextView video_text,video_time;
        ImageView video_image;
        public MyViewHolder(View itemView,ClickListener listener) {
            super(itemView);
            mListener =  listener;
            itemView.setOnClickListener(this);
            video_text = (TextView) itemView.findViewById(R.id.video_text);
            video_time = (TextView) itemView.findViewById(R.id.video_time);
            video_image = (ImageView) itemView.findViewById(R.id.video_image);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getPosition());
        }
    }
}
