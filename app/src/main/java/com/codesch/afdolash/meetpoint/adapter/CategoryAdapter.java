package com.codesch.afdolash.meetpoint.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.activity.EventDetailActivity;
import com.codesch.afdolash.meetpoint.model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afdolash on 10/22/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context;
    private List<String> categoryList = new ArrayList<>();

    public CategoryAdapter(Context context) {
        this.context = context;
        setDataCategory();
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
        String sCategory = categoryList.get(position);
        holder.tvCategory.setText(sCategory);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setDataCategory() {
        categoryList.add("Coffee Break");
        categoryList.add("Talkshow");
        categoryList.add("Workshop");
        categoryList.add("Contest");
        categoryList.add("Concert");
        categoryList.add("Festival");
        categoryList.add("Exhibition");
        categoryList.add("Community");
        categoryList.add("Religion");
        categoryList.add("Social");
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;
        public TextView tvCategory;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
        }
    }
}
