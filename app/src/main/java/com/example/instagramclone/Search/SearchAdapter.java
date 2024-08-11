package com.example.instagramclone.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.viewHolder> {
    Context context;
    ArrayList<SearchModelClass> searchModelClasses;

    public SearchAdapter(Context context, ArrayList<SearchModelClass> searchModelClasses) {
        this.context = context;
        this.searchModelClasses = searchModelClasses;
    }

    @NonNull
    @Override
    public SearchAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.search_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.viewHolder holder, int position) {
        SearchModelClass modelClass = searchModelClasses.get(position);
        holder.imageView.setImageResource(modelClass.getImage());
    }

    @Override
    public int getItemCount() {
        return searchModelClasses.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.search_itemView);
        }
    }
}
