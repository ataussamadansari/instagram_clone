package com.example.instagramclone.Post;
/*
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.instagramclone.databinding.FragmentAddBinding;

import java.io.File;
import java.util.ArrayList;

public class AddFragment extends Fragment {

    private static final int REQUEST_PERMISSION_CODE = 123;
    private LocalAdapter adapter;
    private final ArrayList<LocalModalClass> localModalClasses = new ArrayList<>();
    private FragmentAddBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);


        // Check and request storage permissions if necessary
        if (checkPermission()) {
            fetchLocalMedia();
        } else {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
        }

        // Set layout manager for RecyclerView
        binding.dataRV.setLayoutManager(new GridLayoutManager(getContext(), 4));

        // Initialize adapter and set it to RecyclerView
        adapter = new LocalAdapter(getContext(), localModalClasses, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the clicked item position
                int position = binding.dataRV.getChildAdapterPosition(v);
                // Get the image path of the clicked item
                String imagePath = localModalClasses.get(position).getImg();
                // Display the clicked image using Glide or any other image loading library
                displayFirstImage(imagePath);
            }
        });
        binding.dataRV.setAdapter(adapter);

        displayFirstImage(localModalClasses.get(0).getImg());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().onBackPressed();
            }
        });

        binding.btmCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle camera button click
                Toast.makeText(getContext(), "Camera button clicked", Toast.LENGTH_SHORT).show();
            }
        });


        return binding.getRoot();
    }

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocalMedia();
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void fetchLocalMedia() {
        // Retrieve images and videos from local storage using MediaStore
        // For simplicity, I'm just showing images here. You can extend this to include videos as well.
        String[] projection = {MediaStore.Images.Media.DATA};
        try {
            // Query for images
            android.database.Cursor cursor = requireActivity().getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    null,
                    null,
                    null
            );

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    // Get the file path of the image
                    String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                    // Create a LocalModalClass object and add it to the list
                    localModalClasses.add(new LocalModalClass(imagePath));
                }
                cursor.close();

                // Notify adapter about the data change
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error fetching local media", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayFirstImage(String path) {

        // Load the first image into the ImageView using Glide or any other image loading library
        Glide.with(requireContext())
                .load(new File(path)) // Assuming imagePath is a file path
                .into(binding.imageIV);
    }


}
*/

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.instagramclone.databinding.FragmentAddBinding;

import java.io.File;
import java.util.ArrayList;

public class AddFragment extends Fragment {

    private static final int REQUEST_PERMISSION_CODE = 123;
    private final ArrayList<LocalModalClass> localModalClasses = new ArrayList<>();
    private FragmentAddBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);

        // Check and request storage permissions if necessary
        if (checkPermission()) {
            fetchLocalMedia();
        } else {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
        }

        // Set layout manager for RecyclerView
        binding.dataRV.setLayoutManager(new GridLayoutManager(getContext(), 4));

        // Initialize adapter and set it to RecyclerView
        LocalAdapter adapter = new LocalAdapter(getContext(), localModalClasses, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = binding.dataRV.getChildAdapterPosition(v);
                if (position != RecyclerView.NO_POSITION) {
                    String imagePath = localModalClasses.get(position).getPath();
                    displayImage(imagePath);
                }
            }
        });
        binding.dataRV.setAdapter(adapter);

        displayImage(localModalClasses.get(0).getPath());

        // Set click listeners
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().onBackPressed();
            }
        });

        binding.btmCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle camera button click
                Toast.makeText(getContext(), "Camera button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Check permissions again when the fragment resumes
        if (checkPermission()) {
            fetchLocalMedia();
        }
    }

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocalMedia();
            } else {
                Toast.makeText(getContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*@SuppressLint("NotifyDataSetChanged")
    private void fetchLocalMedia() {
        String[] projection = {MediaStore.Images.Media.DATA};
        try {
            android.database.Cursor cursor = requireActivity().getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    null,
                    null,
                    null
            );

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                    localModalClasses.add(new LocalModalClass(imagePath));
                }
                cursor.close();
            }

            // Notify adapter about the data change
            binding.dataRV.getAdapter().notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error fetching local media", Toast.LENGTH_SHORT).show();
        }
    }*/

    @SuppressLint("NotifyDataSetChanged")
    private void fetchLocalMedia() {
        String[] imageProjection = {MediaStore.Images.Media.DATA};
        String[] videoProjection = {MediaStore.Video.Media.DATA};

        try {
            // Query for images
            android.database.Cursor imageCursor = requireActivity().getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    imageProjection,
                    null,
                    null,
                    null
            );

            // Query for videos
            android.database.Cursor videoCursor = requireActivity().getContentResolver().query(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    videoProjection,
                    null,
                    null,
                    null
            );

            if (imageCursor != null) {
                while (imageCursor.moveToNext()) {
                    String imagePath = imageCursor.getString(imageCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                    localModalClasses.add(new LocalModalClass(imagePath, LocalModalClass.TYPE_IMAGE));
                }
                imageCursor.close();
            }

            if (videoCursor != null) {
                while (videoCursor.moveToNext()) {
                    String videoPath = videoCursor.getString(videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                    localModalClasses.add(new LocalModalClass(videoPath, LocalModalClass.TYPE_VIDEO));
                }
                videoCursor.close();
            }

            // Notify adapter about the data change
            binding.dataRV.getAdapter().notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error fetching local media", Toast.LENGTH_SHORT).show();
        }
    }


    private void displayImage(String path) {
        
        /*if (path != null) {
            Glide.with(requireContext())
                    .load(new File(path))
                    .into(binding.imageIV);
        }*/
    }
}

