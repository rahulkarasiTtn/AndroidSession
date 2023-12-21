package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainContainerActivity extends AppCompatActivity implements LoginFragment.callBackListener,PasswordFragment.callBackListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, LoginFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onLoginSuccess(String username) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,PasswordFragment.newInstance(username))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void navigateToHome(String username) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,HomeFragment.newInstance(username))
                .addToBackStack(null)
                .commit();
    }
}