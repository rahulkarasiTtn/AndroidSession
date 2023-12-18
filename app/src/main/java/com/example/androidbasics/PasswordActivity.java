package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {
    Button submit;
    EditText password;
    TextView greetings;
    TextView inputError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.btn_submit);
        greetings = findViewById(R.id.tv_greetings);
        inputError = findViewById(R.id.inputError);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("NAME");
            // Display the name in a TextView
            greetings.setText("Hello, " + name + "!");
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().length() > 8){
                    Intent intent = new Intent(PasswordActivity.this, HomeActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    inputError.setText("Password must be at least 8 Characters ");
                }
            }
        });
    }
}