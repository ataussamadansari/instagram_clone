package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.instagramclone.Home.HomeFragment;
import com.example.instagramclone.Post.AddFragment;
import com.example.instagramclone.Profile.ProfileFragment;
import com.example.instagramclone.Reel.ReelFragment;
import com.example.instagramclone.Search.SearchFragment;
import com.example.instagramclone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navHome) {
                loadFrag(new HomeFragment(), true);
            } else if (id == R.id.navSearch) {
                loadFrag(new SearchFragment(), false);
            } else if (id == R.id.navAdd) {
                loadFrag(new AddFragment(), false);
            } else if (id == R.id.navReel) {
                loadFrag(new ReelFragment(), false);
            } else {
                loadFrag(new ProfileFragment(), false);
            }
            return true;
        });
        binding.bottomNavigationView.setSelectedItemId(R.id.navHome);

    }

    public void loadFrag(Fragment fragment, Boolean flag) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        if (flag) {
            ft.add(R.id.container, fragment);
            ft.addToBackStack(null);
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (binding.bottomNavigationView.getSelectedItemId() != R.id.navHome) {
            // If the current fragment is not HomeFragment, select the Home button
            binding.bottomNavigationView.setSelectedItemId(R.id.navHome);
        } else {
            ft.addToBackStack(null);
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            super.onBackPressed();
        }
    }

}