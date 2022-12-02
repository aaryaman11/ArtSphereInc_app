package com.example.artsphereincapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    //Note update some depreciated api calls
    //like findviewby id to view bindings
    //startActivityForResult and onActivityResult

    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    ImageView googleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        TextView email = (TextView) findViewById(R.id.email);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin login

        TextView signup = (TextView) findViewById(R.id.signuplink);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, signupActivity.class);
                startActivity(intent);

            }
        });



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("admin") && password.getText().toString().equals("adminpass")) {
                    openCreateSurveyActivity();
                }

                else if (email.getText().toString().equals("regular") && password.getText().toString().equals("regpass")) {
                    openSurveyActivity();
                }
                else {
                    Toast.makeText(MainActivity.this, "Incorrect credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        googleBtn = findViewById(R.id.googlebtn);

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });

    }
    void logIn() {
        Intent logInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(logInIntent,200);
    }


















    void openCreateSurveyActivity() {
        finish();
        Intent intent = new Intent(MainActivity.this, CreateSurveyActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                openSurveyActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void openSurveyActivity() {
        finish();
        Intent intent = new Intent(MainActivity.this, SurveyActivity.class);
        startActivity(intent);
    }

}