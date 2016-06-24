package com.example.android36krnews.equity.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android36krnews.R;
import com.example.android36krnews.equity.entity.EquityBean;
import com.example.android36krnews.equity.entity.SyndicatesBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class MyEquityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<EquityBean.DataBean.Data2Bean> mlist;
    private LayoutInflater minflater;
    private static final int CATEGORY = 0;
    private static final int FOOTER = 1;
    private int mType;
    private OnRecyclerViewClickListener mOnRecyclerViewClickListener;
    private Context mcontext;
    private Resources mRes;

    public MyEquityAdapter(Context context,int mType){
        minflater = LayoutInflater.from(context);
        mcontext = context;
        this.mType = mType;
        mRes = context.getResources();
    }

    public void setMlist(List<EquityBean.DataBean.Data2Bean> mlist) {
        this.mlist = mlist;
    }

    public void setmOnRecyclerViewClickListener(OnRecyclerViewClickListener mOnRecyclerViewClickListener) {
        this.mOnRecyclerViewClickListener = mOnRecyclerViewClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewitem;
        if(viewType == CATEGORY){
            viewitem = minflater.inflate(R.layout.fragment_equity_item_item,parent,false);
            MyHolder holder = new MyHolder(viewitem);
            return holder;
        }else if(viewType == FOOTER){
            viewitem = minflater.inflate(R.layout.recycler_load_more_layout,parent,false);
            return new FooterItemViewHolder(viewitem);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MyHolder){
            EquityBean.DataBean.Data2Bean syndicates = mlist.get(position);
            holder.itemView.setTag(syndicates);
            ((MyHolder) holder).title.setText(syndicates.getCompany().getName());
            ((MyHolder) holder).brief.setText(syndicates.getCompany().getBrief());
            Picasso.with(mcontext).load(syndicates.getCompany().getLogo()).into(((MyHolder) holder).imagelogo);
            Picasso.with(mcontext).load(syndicates.getDesc().getFile_list_img()).into(((MyHolder) holder).image);
            ((MyHolder) holder).collar.setText("领投方");

            ((MyHolder) holder).initiate.setText(syndicates.getDesc().getCf_advantage().get(0).getLabel());
            ((MyHolder) holder).initiate2.setText(syndicates.getDesc().getCf_advantage().get(0).getValue());
            ((MyHolder) holder).menber.setText(syndicates.getDesc().getCf_advantage().get(1).getLabel());
            ((MyHolder) holder).menber2.setText(syndicates.getDesc().getCf_advantage().get(1).getValue());
            int i = syndicates.getCf_success_raising_offer()/(syndicates.getCf_raising()/100);
            if(syndicates.getLeader() == null){
                ((MyHolder) holder).collar2.setText(syndicates.getOrganization().getName());
            }else {
                ((MyHolder) holder).collar2.setText(syndicates.getLeader().getName());
            }
            if(i > 100){
                ((MyHolder) holder).goal.setTextColor(Color.RED);
            }else {
                ((MyHolder) holder).goal.setTextColor(mRes.getColor(R.color.color_equity_txt));
            }
            if(syndicates.getStatus() == 30){
                ((MyHolder) holder).fund.setText("募资中");
                ((MyHolder) holder).fund.setTextColor(mRes.getColor(R.color.color_bottom_tab_light));
                ((MyHolder) holder).ok.setText("认购");
                ((MyHolder) holder).ok.setBackgroundResource(R.drawable.share1);
            }else if(syndicates.getStatus() == 35){
                ((MyHolder) holder).fund.setText("募资完成");
                ((MyHolder) holder).ok.setText("去看看");
                ((MyHolder) holder).fund.setTextColor(mRes.getColor(R.color.color_equity_txt));
                ((MyHolder) holder).ok.setBackgroundResource(R.drawable.share);
            }else if(syndicates.getStatus() == 50){
                ((MyHolder) holder).fund.setText("融资成功");
                ((MyHolder) holder).ok.setText("去看看");
                ((MyHolder) holder).fund.setTextColor(mRes.getColor(R.color.color_equity_txt));
                ((MyHolder) holder).ok.setBackgroundResource(R.drawable.share);
            }
            ((MyHolder) holder).goal.setText("已募资"+i+"%");
            ((MyHolder) holder).bar.setMax(syndicates.getCf_raising());
            ((MyHolder) holder).bar.setProgress(syndicates.getCf_success_raising_offer());
        }else if(holder instanceof FooterItemViewHolder){

        }
        if(mOnRecyclerViewClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecyclerViewClickListener.onItemClick(view, (EquityBean.DataBean.Data2Bean) view.getTag(),position);
                }
            });
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position + 1 == getItemCount()){
            return FOOTER;
        }else {
            return CATEGORY;
        }
    }
    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private ImageView imagelogo,image;
        private TextView title,brief,collar,collar2,initiate,initiate2,menber,menber2,fund,goal,ok;
        private ProgressBar bar;
        public MyHolder(View itemView) {
            super(itemView);
            imagelogo = (ImageView) itemView.findViewById(R.id.equity_item_icon_image);
            image = (ImageView) itemView.findViewById(R.id.quity_item_photo_image);
            title = (TextView) itemView.findViewById(R.id.equity_item_title_txt);
            brief = (TextView) itemView.findViewById(R.id.equity_item_introduce_txt);
            collar = (TextView) itemView.findViewById(R.id.quity_item_collar_txt);
            collar2 = (TextView) itemView.findViewById(R.id.quity_item_collar_txt2);
            initiate = (TextView) itemView.findViewById(R.id.quity_item_initiate_txt);
            initiate2 = (TextView) itemView.findViewById(R.id.quity_item_initiate_txt2);
            menber = (TextView) itemView.findViewById(R.id.quity_item_mamber_txt);
            menber2 = (TextView) itemView.findViewById(R.id.quity_item_mamber_txt2);
            fund = (TextView) itemView.findViewById(R.id.quity_item_type_txt);
            goal = (TextView) itemView.findViewById(R.id.quity_item_liang_txt);
            ok = (TextView) itemView.findViewById(R.id.quity_item_ok_txt);
            bar = (ProgressBar) itemView.findViewById(R.id.equity_item_progressbar);
        }
    }

    public interface OnRecyclerViewClickListener{
        void onItemClick(View view,EquityBean.DataBean.Data2Bean db,int position);
    }
    private class FooterItemViewHolder extends RecyclerView.ViewHolder{
        public FooterItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
