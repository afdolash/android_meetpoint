package com.codesch.afdolash.meetpoint.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.activity.EventDetailActivity;
import com.codesch.afdolash.meetpoint.model.Event;

import java.util.List;

/**
 * Created by Afdolash on 10/22/2017.
 */

public class EventAdapterNew extends RecyclerView.Adapter {

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private Context context;
    private List<Event> eventList;

    private boolean isLoadingAdded = false;

    public EventAdapterNew(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        if (viewType == VIEW_ITEM) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_event_grid, parent, false);

            viewHolder = new MyViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_loading, parent, false);

            viewHolder = new ProgressViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            Event event = eventList.get(position);

            String sDate = null;
            String[] date = event.getDateStart_event().split("-");

            switch (date[1]) {
                case "01":
                    sDate = date[2] +" Januari";
                    break;
                case "02":
                    sDate = date[2] +" Februari";
                    break;
                case "03":
                    sDate = date[2] +" Maret";
                    break;
                case "04":
                    sDate = date[2] +" April";
                    break;
                case "05":
                    sDate = date[2] +" Mei";
                    break;
                case "06":
                    sDate = date[2] +" Juni";
                    break;
                case "07":
                    sDate = date[2] +" Juli";
                    break;
                case "08":
                    sDate = date[2] +" Agustus";
                    break;
                case "09":
                    sDate = date[2] +" September";
                    break;
                case "10":
                    sDate = date[2] +" Oktober";
                    break;
                case "11" :
                    sDate = date[2] +" November";
                    break;
                case "12":
                    sDate = date[2] +" Desember";
                    break;
            }

            Glide.with(context)
                    .load(event.getImage_event())
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            ((MyViewHolder) holder).progressBar.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            ((MyViewHolder) holder).progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(((MyViewHolder) holder).imgEvent);

            ((MyViewHolder) holder).tvTitle.setText(event.getTitle_event());
            ((MyViewHolder) holder).tvDate.setText(sDate);
            ((MyViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, EventDetailActivity.class);
                    context.startActivity(intent);
                }
            });
        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == eventList.size() - 1 && isLoadingAdded) ? VIEW_PROG : VIEW_ITEM;
    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        eventList.add(new Event());
        notifyItemInserted(eventList.size() - 1);
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = eventList.size() - 1;
        Event event = eventList.get(position);

        if (event != null) {
            eventList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imgEvent;
        public TextView tvTitle, tvDate;
        public ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            imgEvent = (ImageView) itemView.findViewById(R.id.img_event);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
        }
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progress_bar);
        }
    }
}
