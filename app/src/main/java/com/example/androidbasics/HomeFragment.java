package com.example.androidbasics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_USERNAME = "username";

    private String username;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(ARG_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView homeTextView = view.findViewById(R.id.home_greetings);
        Button logoutButton = view.findViewById(R.id.logoutBtn);
        Button loginButton = view.findViewById(R.id.login);
        homeTextView.setText("Hello " + username );

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                SharedPreferences sharedPref = context.getSharedPreferences("loginFile",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("password","");
                editor.apply();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, PasswordFragment.newInstance(username))
                        .addToBackStack(null)
                        .commit();

//                Fragment fragment = new LoginFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragmentContainer, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                SharedPreferences sharedPref = context.getSharedPreferences("loginFile",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.apply();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, LoginFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}