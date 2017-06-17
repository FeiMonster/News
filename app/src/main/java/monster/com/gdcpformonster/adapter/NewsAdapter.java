package monster.com.gdcpformonster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import monster.com.gdcpformonster.R;
import monster.com.gdcpformonster.bean.News;

/**
 * Created by ASUS on 2017/5/10.
 */

public class NewsAdapter extends RecyclerView.Adapter {
    private final int TYPE_HEAD = 0;//表示首个位置，显示轮播图片
    private final int TYPE_NORMAL = 1;//表示正常的itme布局
    private Context mContext;
    private List<String> banner_url;//轮播图片的路径
    private List<News> news;
    private OnItemClickListener mClickListener;

    public NewsAdapter(Context context, List<String> list,List<News> data) {
        this.mContext = context;
        this.banner_url = list;
        this.news = data;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_HEAD) {
            //创建第一个顶部banner的ViewHolder
            holder = new BannerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.itemheader_banner
                    , parent, false));
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_fisrtfragment
                    , parent, false);
            holder = new ItemViewHolder(view,mClickListener);
        }
        return holder;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mClickListener = listener;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.banner.setImages(banner_url);
            bannerViewHolder.banner.setImageLoader(new GlideImageLoader());
            bannerViewHolder.banner.start();

        } else if (holder instanceof ItemViewHolder) {
            //处理每个item里的数据
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.textView.setText(news.get(position).getTitle());
            itemViewHolder.date.setText(news.get(position).getDate());
            itemViewHolder.image.setImageResource(news.get(position).getImage_path());
            holder.itemView.setTag(position);
        }
    }
    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public int getItemCount() {
        return banner_url.size()+5;
    }

    /**
     * 正常的item布局管理
     */
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView textView;
        TextView date;
        private OnItemClickListener mListener;// 声明自定义的接口
        public ItemViewHolder(View itemView,OnItemClickListener listener) {
            super(itemView);
            mListener = listener;
            // 为ItemView添加点击事件
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.news_text);
            date = (TextView) itemView.findViewById(R.id.date);
        }


        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getPosition());
        }
    }
    }
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);
        }


    }

    //banner的viewholder
    class BannerViewHolder extends RecyclerView.ViewHolder{
            Banner banner ;
        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }
