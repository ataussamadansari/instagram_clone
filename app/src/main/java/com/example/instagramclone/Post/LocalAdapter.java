package com.example.instagramclone.Post;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.instagramclone.R;

import java.io.File;
import java.util.ArrayList;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.viewHolder> {
    Context context;
    ArrayList<LocalModalClass> localModalClasses;

    private View.OnClickListener onClickListener;

    public LocalAdapter(Context context, ArrayList<LocalModalClass> localModalClasses, View.OnClickListener onClickListener) {
        this.context = context;
        this.localModalClasses = localModalClasses;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public LocalAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.add_img_vid, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocalAdapter.viewHolder holder, int position) {
        LocalModalClass item = localModalClasses.get(position);
        Glide.with(context).load(item.getPath()).into(holder.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return localModalClasses.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.local_data);
        }
    }
}
