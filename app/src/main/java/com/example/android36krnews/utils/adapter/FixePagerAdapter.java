package com.example.android36krnews.utils.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android36krnews.R;
import com.example.android36krnews.utils.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 */
public class FixePagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int CATEGORY = 0;
    private LayoutInflater mInflater;
    private List<Category> list;
    private int mType;
    private OnRecyclerViewClickListener mOnRecyclerViewClickListener;

    public FixePagerAdapter(Context context,int mType) {
        this.mType = mType;
        mInflater = LayoutInflater.from(context);
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    public void setMonRecyclerViewClickListener(OnRecyclerViewClickListener mOnRecyclerViewClickListener) {
        this.mOnRecyclerViewClickListener = mOnRecyclerViewClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if( viewType == CATEGORY){
            itemView = mInflater.inflate(R.layout.category_item,parent,false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(itemView);
            return itemViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if( holder instanceof ItemViewHolder){
            Category category = list.get(position);
            holder.itemView.setTag(category);
            ((ItemViewHolder) holder).mItemType.setBackgroundColor(Color.RED);
            ((ItemViewHolder) holder).mTextView.setText(category.getmTitle());
            if(mOnRecyclerViewClickListener != null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnRecyclerViewClickListener.onItemClick(view, (Category) view.getTag());
                    }
                });
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mType;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        private View mItemType;
        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mItemType = itemView.findViewById(R.id.category_item_view);
            mTextView = (TextView) itemView.findViewById(R.id.category_item_name);
        }
    }
    public static interface OnRecyclerViewClickListener{
        void onItemClick(View view,Category category);
    }
}
