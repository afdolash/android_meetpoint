package com.codesch.afdolash.meetpoint.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codesch.afdolash.meetpoint.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afdolash on 11/4/2017.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.MyViewHolder> {

    private Context context;
    private List<String> timelineList = new ArrayList<>();

    public TimelineAdapter(Context context) {
        this.context = context;
        setDataTimeline();
    }

    @Override
    public TimelineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_timeline, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TimelineAdapter.MyViewHolder holder, int position) {
        String sTimeline = timelineList.get(position);
        holder.tvTitle.setText(sTimeline);
    }

    @Override
    public int getItemCount() {
        return timelineList.size();
    }

    public void setDataTimeline() {
        timelineList.add("This weekend");
        timelineList.add("Today");
        timelineList.add("Tomorrow");
        timelineList.add("Next week");
        timelineList.add("Next weekend");
        timelineList.add("Any day");
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView cardTimeline;
        public TextView tvTitle;
        public ImageView imgCover;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardTimeline = (CardView) itemView.findViewById(R.id.card_timeline);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            imgCover = (ImageView) itemView.findViewById(R.id.img_cover);
        }
    }
}
