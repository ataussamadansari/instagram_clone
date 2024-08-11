package com.example.instagramclone.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;
import com.example.instagramclone.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<StoryModelClass> storyModelClasses = new ArrayList<>();
    ArrayList<PostModelClass> postModelClasses = new ArrayList<>();
    StoryAdapter adapter;
    PostAdapter adapter1;
    Animation animation;
    boolean isToolbarVisible = true;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.storyRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        storyModelClasses.add(new StoryModelClass("Ataussamad Ansari", R.drawable.d));
        storyModelClasses.add(new StoryModelClass("Ataussamad", R.drawable.e));
        storyModelClasses.add(new StoryModelClass("Shubham Singh", R.drawable.pic));
        storyModelClasses.add(new StoryModelClass("Shubham", R.drawable.piccc));
        storyModelClasses.add(new StoryModelClass("Ehatesham Ansari", R.drawable.d));
        storyModelClasses.add(new StoryModelClass("Ehatesham", R.drawable.profile));

        adapter = new StoryAdapter(getContext(), storyModelClasses);
        binding.storyRV.setAdapter(adapter);

        binding.postRV.setLayoutManager(new LinearLayoutManager(getContext()));

        postModelClasses.add(new PostModelClass(R.drawable.c, "Shubham Singh", R.drawable.pic, "1,000 Likes", "hfjksdfjksdjvbjkkhkv jkl;j dfkl jlk dlldfljkgjkldljk  dfjk kj jbkerhguihkfkjdf", "View All 100 comments", R.drawable.abc, "3 hours ago"));
        postModelClasses.add(new PostModelClass(R.drawable.c, "Ataussamad", R.drawable.abc, "1,00 Likes", "uyhfjdbn uib sdfvb erighbvhj hg gbdvbvjhghf", "View All 10 comments", R.drawable.c, "3 hours ago"));
        postModelClasses.add(new PostModelClass(R.drawable.c, "Ataussamad Ansari", R.drawable.c, "1,00 Likes", "String.valueOf(R.string.disc)", "View All 10 comments", R.drawable.profile, "3 hours ago"));
        postModelClasses.add(new PostModelClass(R.drawable.c, "Ehatesham Ansari", R.drawable.piccc, "1,00 Likes", "sjdhjk jsd😍❤😎🎂", "View All 10 comments", R.drawable.e, "3 hours ago"));
        postModelClasses.add(new PostModelClass(R.drawable.c, "Ehatesham", R.drawable.pic, "1,00 Likes", "🤳💕👌😎", "View All 10 comments", R.drawable.piccc, "3 hours ago"));
        postModelClasses.add(new PostModelClass(R.drawable.c, "Shubham", R.drawable.e, "1,00 Likes", "hjk ", "View All 10 comments", R.drawable.pic, "3 hours ago"));
        postModelClasses.add(new PostModelClass(R.drawable.c, "Aman", R.drawable.d, "1,00 Likes", "", "View All 10 comments", R.drawable.e, "3 hours ago"));
        postModelClasses.add(new PostModelClass(R.drawable.c, "Akash Patel", R.drawable.c, "1,00 Likes", "shdfuh h  jhsdj fhg (●'◡'●)( ´･･)ﾉ(._.`)(⌐■_■)", "View All 10 comments", R.drawable.d, "3 hours ago"));

        adapter1 = new PostAdapter(getContext(), postModelClasses);
        binding.postRV.setAdapter(adapter1);

        return binding.getRoot();
    }


}