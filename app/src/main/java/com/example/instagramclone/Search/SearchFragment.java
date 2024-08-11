package com.example.instagramclone.Search;

import static androidx.recyclerview.widget.StaggeredGridLayoutManager.GAP_HANDLING_LAZY;
import static androidx.recyclerview.widget.StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS;
import static androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagramclone.R;
import com.example.instagramclone.databinding.FragmentSearchBinding;
import com.google.android.material.carousel.CarouselLayoutManager;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    ArrayList<SearchModelClass>searchModelClasses = new ArrayList<>();
    SearchAdapter adapter;
    FragmentSearchBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        binding.searchRV.setLayoutManager(new StaggeredGridLayoutManager(2, VERTICAL));

        searchModelClasses.add(new SearchModelClass(R.drawable.abc));
        searchModelClasses.add(new SearchModelClass(R.drawable.pic));
        searchModelClasses.add(new SearchModelClass(R.drawable.e));
        searchModelClasses.add(new SearchModelClass(R.drawable.d));
        searchModelClasses.add(new SearchModelClass(R.drawable.profile));
        searchModelClasses.add(new SearchModelClass(R.drawable.piccc));
        searchModelClasses.add(new SearchModelClass(R.drawable.abc));
        searchModelClasses.add(new SearchModelClass(R.drawable.pic));
        searchModelClasses.add(new SearchModelClass(R.drawable.piccc));
        searchModelClasses.add(new SearchModelClass(R.drawable.e));
        searchModelClasses.add(new SearchModelClass(R.drawable.pic));
        searchModelClasses.add(new SearchModelClass(R.drawable.c));
        searchModelClasses.add(new SearchModelClass(R.drawable.profile));

        adapter = new SearchAdapter(getContext(), searchModelClasses);
        binding.searchRV.setAdapter(adapter);

        return binding.getRoot();
    }
}