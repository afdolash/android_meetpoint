package com.codesch.afdolash.meetpoint.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.model.History;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afdolash on 11/5/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private Context context;
    private List<History> historyList = new ArrayList<>();

    public HistoryAdapter(Context context, List<History> historyList) {
        this.context = context;
        this.historyList = historyList;
    }

    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.MyViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.tvKey.setText(history.getKey());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearHistory;
        public TextView tvKey;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearHistory = (LinearLayout) itemView.findViewById(R.id.linear_history);
            tvKey = (TextView) itemView.findViewById(R.id.tv_key);
        }
    }
}
