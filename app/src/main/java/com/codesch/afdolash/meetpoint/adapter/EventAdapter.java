package com.codesch.afdolash.meetpoint.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.activity.EventDetailActivity;
import com.codesch.afdolash.meetpoint.model.Event;

import java.util.List;

/**
 * Created by Afdolash on 10/22/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private Context context;
    private List<Event> eventList;

    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public EventAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event_grid, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventAdapter.MyViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.tvTitle.setText(event.getTitle());
        holder.tvDate.setText(event.getDateStart());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public ImageView imgEvent;
        public TextView tvTitle, tvDate;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            imgEvent = (ImageView) itemView.findViewById(R.id.img_event);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        }
    }
}
