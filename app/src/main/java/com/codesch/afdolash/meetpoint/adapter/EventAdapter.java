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
        final Event event = eventList.get(position);

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
                .into(holder.imgEvent);

        holder.tvTitle.setText(event.getTitle_event());
        holder.tvDate.setText(sDate);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailActivity.class);
                intent.putExtra("id_event", event.getId_event());
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
