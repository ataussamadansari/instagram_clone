package com.example.instagramclone.Reel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.instagramclone.R;
import com.example.instagramclone.databinding.FragmentReelBinding;

import java.util.ArrayList;

public class ReelFragment extends Fragment {

    ArrayList<ReelModelClass> reelModelClasses = new ArrayList<>();
    ReelAdapter adapter;
    FragmentReelBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReelBinding.inflate(inflater, container, false);


        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video1, "Ataussamad", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video2, "Ataussamad Ansari", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video3, "Ehatesham", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        //reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video4, "Ehatesham Ansari", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video6, "Shubham Singh", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video7, "Aman Patel", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video8, "Aman", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video9, "Akash", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video10, "Shivam", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video11, "Nitin Patel", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video12, "Suraj Patel", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video13, "Ataussamad", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));
        reelModelClasses.add(new ReelModelClass("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video14, "Ataussamad Ansari", "1000", "400K", "1M", "jkjksdfdfk 😍👀✔💖😊", "Ataussamad Ansari • Original Sound", R.drawable.abc, R.drawable.abc));

        adapter = new ReelAdapter(getContext(), reelModelClasses);
        binding.viewPager.setAdapter(adapter);
        return binding.getRoot();

    }
}