package com.example.instagramclone.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.viewHolder> {
    Context context;
    ArrayList<PostModelClass> postModelClasses;

    public PostAdapter(Context context, ArrayList<PostModelClass> postModelClasses) {
        this.context = context;
        this.postModelClasses = postModelClasses;
    }

    @NonNull
    @Override
    public PostAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.viewHolder holder, int position) {
        PostModelClass modelClass = postModelClasses.get(position);
        holder.pro_img.setImageResource(modelClass.getPro_img());
        holder.user_name.setText(modelClass.getUserName());
        holder.post.setImageResource(modelClass.getPost());
        holder.like.setText(modelClass.getLink());
        holder.disc.setText(modelClass.getDisc());
        holder.comment.setText(modelClass.getComment());
        holder.your_img.setImageResource(modelClass.getYour_img());
        holder.uploadTime.setText(modelClass.getUpload_time());
    }

    @Override
    public int getItemCount() {
        return postModelClasses.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView like, comment, disc, uploadTime, addComment, user_name;
        CircleImageView your_img, pro_img;
        ImageView post;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            like = itemView.findViewById(R.id.likeCount);
            user_name = itemView.findViewById(R.id.user_name);
            comment = itemView.findViewById(R.id.commentCount);
            addComment = itemView.findViewById(R.id.addComment);
            disc = itemView.findViewById(R.id.disc);
            uploadTime = itemView.findViewById(R.id.uploadTime);
            your_img = itemView.findViewById(R.id.your_img);
            pro_img = itemView.findViewById(R.id.profile_img);
            post = itemView.findViewById(R.id.postView);
        }
    }
}
