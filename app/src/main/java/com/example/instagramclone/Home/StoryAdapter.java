package com.example.instagramclone.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.viewHolder> {
    Context context;
    ArrayList<StoryModelClass> storyModelClasses;

    public StoryAdapter(Context context, ArrayList<StoryModelClass> storyModelClasses) {
        this.context = context;
        this.storyModelClasses = storyModelClasses;
    }

    @NonNull
    @Override
    public StoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.viewHolder holder, int position) {
        StoryModelClass modelClass = storyModelClasses.get(position);
        holder.name.setText(modelClass.getName());
        holder.pro_image.setImageResource(modelClass.getImage());
    }

    @Override
    public int getItemCount() {
        return storyModelClasses.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CircleImageView pro_image;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            pro_image = itemView.findViewById(R.id.profile_img);
        }
    }
}
