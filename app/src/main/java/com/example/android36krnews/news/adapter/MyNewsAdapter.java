package com.example.android36krnews.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android36krnews.R;
import com.example.android36krnews.news.entity.ArticleBean;
import com.example.android36krnews.utils.entity.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16 0016.
 */
public class MyNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int NORMAL = 0;//新闻列表视图
    private static final int OTHER = 1;
    private static final int FOOTER = 2; //上拉加载更多布局
    private int mType;
    private Context context;

    private List<ArticleBean> mlist;
    private OnRecyclerViewClickListener mOnRecyclerViewClickListener;
    private LayoutInflater minflater;

    public MyNewsAdapter(Context context, int mType) {
        minflater = LayoutInflater.from(context);
        this.mType = mType;
        this.context = context;
    }

    public void setMlist(List<ArticleBean> mlist) {
        this.mlist = mlist;
    }

    public void setmOnRecyclerViewClickListener(OnRecyclerViewClickListener mOnRecyclerViewClickListener) {
        this.mOnRecyclerViewClickListener = mOnRecyclerViewClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem;
        if (viewType == NORMAL) {
            viewItem = minflater.inflate(R.layout.fragment_news_item, parent, false);
            return new NewsHolder(viewItem);
        } else if (viewType == FOOTER) {
            viewItem = minflater.inflate(R.layout.recycler_load_more_layout, parent, false);
            return new FooterItemViewHolder(viewItem);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof NewsHolder) {
            ArticleBean article = mlist.get(position);
            holder.itemView.setTag(article);
            ((NewsHolder) holder).titleTxt.setText(article.getmTitle());
            ((NewsHolder) holder).authorTxt.setText(article.getmAuthor().getmName());
            ((NewsHolder) holder).timeTxt.setText(article.getmDateText());
            ((NewsHolder) holder).typeTxt.setText(article.getmMask());
            Picasso.with(context).load(article.getmImgUrl()).into(((NewsHolder) holder).imageView);
        } else if (holder instanceof FooterItemViewHolder) {

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnRecyclerViewClickListener.onItemClick(view, (ArticleBean) view.getTag(), position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return FOOTER;
        } else {
            return NORMAL;
        }
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        private TextView titleTxt, authorTxt, timeTxt, typeTxt;
        private ImageView imageView;

        public NewsHolder(View itemView) {
            super(itemView);
            titleTxt = (TextView) itemView.findViewById(R.id.news_item_title_txt);
            authorTxt = (TextView) itemView.findViewById(R.id.news_item_author_txt);
            timeTxt = (TextView) itemView.findViewById(R.id.news_item_time_txt);
            typeTxt = (TextView) itemView.findViewById(R.id.news_item_type_txt);
            imageView = (ImageView) itemView.findViewById(R.id.news_item_image);
        }
    }

    public static interface OnRecyclerViewClickListener {
        void onItemClick(View view, ArticleBean article, int position);
    }

    /**
     * 上拉刷新加载更多布局
     */
    private class FooterItemViewHolder extends RecyclerView.ViewHolder {
        public FooterItemViewHolder(View itemView) {
            super(itemView);
        }
    }

}
