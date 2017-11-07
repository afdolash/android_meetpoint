package com.codesch.afdolash.meetpoint.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.model.Author;
import com.codesch.afdolash.meetpoint.model.Event;

import java.util.List;

/**
 * Created by Afdolash on 11/4/2017.
 */

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.MyViewHolder> {
    private Context context;
    private List<Author> authorList;

    public AuthorAdapter(Context context, List<Author> authorList) {
        this.context = context;
        this.authorList = authorList;
    }

    @Override
    public AuthorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_author, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AuthorAdapter.MyViewHolder holder, int position) {
        Author author = authorList.get(position);
    }

    @Override
    public int getItemCount() {
        return authorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgAuthor;
        public LinearLayout linearAuthor;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearAuthor = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            imgAuthor = (ImageView) itemView.findViewById(R.id.img_author);
        }
    }
}
