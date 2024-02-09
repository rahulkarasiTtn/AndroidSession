package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainContainerActivity extends AppCompatActivity implements LoginFragment.callBackListener,PasswordFragment.callBackListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main_container);
        SharedPreferences sharedPref = getSharedPreferences("loginFile", Context.MODE_PRIVATE);
        String username = sharedPref.getString("userName","");
        String password = sharedPref.getString("password","");
        if (savedInstanceState == null) {
            if(username.isEmpty() && password.isEmpty()){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, LoginFragment.newInstance())
                        .commit();
            }else if(!username.isEmpty() && password.isEmpty()){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, PasswordFragment.newInstance(username))
                        .commit();
            }else {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, HomeFragment.newInstance(username))
                        .commit();
            }
        }
    }

    @Override
    public void onLoginSuccess(String username) {
        // Replace LoginFragment with PasswordFragment and pass the username
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, PasswordFragment.newInstance(username))
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