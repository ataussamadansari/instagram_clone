package com.example.instagramclone.Reel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReelAdapter extends RecyclerView.Adapter<ReelAdapter.viewHolder> {
    Context context;
    ArrayList<ReelModelClass> reelModelClasses;
    Boolean isPlaying = true;

    public ReelAdapter(Context context, ArrayList<ReelModelClass> reelModelClasses) {
        this.context = context;
        this.reelModelClasses = reelModelClasses;
    }

    @NonNull
    @Override
    public ReelAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.reel_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReelAdapter.viewHolder holder, int position) {
        ReelModelClass modelClass = reelModelClasses.get(position);
        holder.videoView.setVideoPath(modelClass.getVideoUrl());
        holder.user_profile.setImageResource(modelClass.getUser_profile());
        holder.user_name.setText(modelClass.getUser_name());
        holder.disc.setText(modelClass.getDisc());
        holder.like.setText(modelClass.getLike());
        holder.comment.setText(modelClass.getComment());
        holder.share.setText(modelClass.getShare());
        holder.sound_profile.setImageResource(modelClass.getSound_profile());
        holder.sound_text.setText(modelClass.getSound_text());

        holder.videoView.setOnPreparedListener(mp -> {
            mp.start();
            isPlaying = true;
        });
        holder.videoView.setOnCompletionListener(mp -> {
            mp.start();
            isPlaying = true;
        });
        holder.videoView.setOnClickListener(v -> {
            if (isPlaying) {
                holder.videoView.pause();
                isPlaying = false;
            } else {
                holder.videoView.resume();
                isPlaying = true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return reelModelClasses.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        CircleImageView user_profile;
        ImageView sound_profile;
        TextView like, comment, share, user_name, disc, sound_text;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            user_name = itemView.findViewById(R.id.user_name);
            disc = itemView.findViewById(R.id.discTV);
            share = itemView.findViewById(R.id.shareTV);
            comment = itemView.findViewById(R.id.commentTV);
            like = itemView.findViewById(R.id.likeTV);
            sound_text = itemView.findViewById(R.id.soundTV);
            sound_profile = itemView.findViewById(R.id.soundIV);
            user_profile = itemView.findViewById(R.id.user_profile);

        }
    }
}
