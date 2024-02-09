package com.example.androidbasics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_USERNAME = "username";
    public static final String TAG = "IMAGE_CAPTURE_LOGS";
    static final int REQUEST_IMAGE_CAPTURE = 1001;
    private static final int REQUEST_CALL_FEATURE = 1111;

    private String username;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    ImageView profileImage;
    String savedImagePath;
    String currentPhotoPath;
    public static final String imagePath = "SAVED_IMAGE_PATH";

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String password) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, password);
        fragment.setArguments(args);
        return fragment;
    }

    private final ActivityResultLauncher<Intent> pickGalleryImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                Uri imageUri = result.getData().getData();
                editor.putString(imagePath, imageUri.toString());
                editor.apply();
                setPic(imageUri);
            } else {
                // Gallery selection canceled
                Toast.makeText(requireContext(), "Gallery selection canceled", Toast.LENGTH_SHORT).show();
            }
        }
    });

    private final ActivityResultLauncher<Intent> takePictureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                // Image captured successfully
                setPic(result.getData().getData());
            } else {
                // Image capture failed or user canceled
                Toast.makeText(requireContext(), "Image capture failed or canceled", Toast.LENGTH_SHORT).show();
            }
        }
    });

    private void setPic(Uri imageUri) {

        Glide.with(profileImage).load(imageUri).placeholder(R.drawable.dummy_profile).into(profileImage);
        Toast.makeText(requireContext(), "Image captured Hahasahhah", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(ARG_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Context context = getActivity();
        sharedPref = context.getSharedPreferences("loginFile", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        savedImagePath = sharedPref.getString(imagePath, "");
        TextView homeTextView = view.findViewById(R.id.home_greetings);
        Button logoutButton = view.findViewById(R.id.logoutBtn);
        Button loginButton = view.findViewById(R.id.login);
        Button chooseButton = view.findViewById(R.id.chooseBtn);
        profileImage = view.findViewById(R.id.imageView);
        homeTextView.setText("Hello " + username);

        if (!savedImagePath.isEmpty()) {
            setPic(Uri.parse(savedImagePath));
        }

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("password", "");
                editor.apply();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, PasswordFragment.newInstance(username)).addToBackStack(null).commit();

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                SharedPreferences sharedPref = context.getSharedPreferences("loginFile", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.apply();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, LoginFragment.newInstance()).addToBackStack(null).commit();
            }
        });

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
            }
        });

        return view;
    }

    public void pickImage() {
        // Display a dialog to choose between camera and gallery
        final CharSequence[] options = {"Camera", "Gallery"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(requireContext());
        builder.setTitle("Choose an option");
        builder.setItems(options, (dialog, which) -> {
            switch (which) {
                case 0:
                    dispatchTakePictureIntent();
                    break;
                case 1:
                    pickImageFromGallery();
                    break;
            }
        });

        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void pickImageFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickGalleryImageLauncher.launch(galleryIntent);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Ensure that there's a camera activity to handle the intent

        Log.d(TAG, "dispatchTakePictureIntent: CAMERA INTENT EXISTS = " + true);
        // Create the File where the photo should go
        File photoFile = null;
        try {
            photoFile = createImageFile();
            Log.d(TAG, "dispatchTakePictureIntent: photoFile path =" + photoFile.getAbsolutePath());
        } catch (IOException ex) {
            // Error occurred while creating the File

        }
        // Continue only if the File was successfully created
        if (photoFile != null) {
            try {
                Uri photoURI = FileProvider.getUriForFile(getContext(), "com.example.androidbasics", photoFile);

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            } catch (Exception e) {
                Log.d(TAG, "dispatchTakePictureIntent: Exception occured = " + e.getMessage());
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Log.d(TAG, "onActivityResult: data is null = " + (data == null));


//            if (data != null) {
//                Bundle extras = data.getExtras();
//                Bitmap imageBitmap = (Bitmap) extras.get("data");
            setPic(Uri.parse(currentPhotoPath));
//                profile.setImageBitmap(imageBitmap);
//            }
        }
        if (requestCode == REQUEST_CALL_FEATURE) {

        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName,  /* prefix */
                ".jpg"         /* suffix */, storageDir
                /* directory */);
        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        Log.d(TAG, "createImageFile: currentPhotoPath = " + currentPhotoPath);
        return image;
    }

}