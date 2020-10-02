package com.example.kalorilaskuri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button registerBtn;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //lataa datan databaseen käyttäen
                    //googlen firebase sivustolta ladattu APIa ja kirjastoa.
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //Kertoo käyttäjälle onko tehtävä onnistunut vai ei.
                                    //jos on niin siirrytään Login acticityyn.
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegistrationActivity.this,
                                                "Thank you for your registeration!",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent
                                                (RegistrationActivity.this,
                                                        Login.class));
                                    }else{
                                        Toast.makeText(RegistrationActivity.this,
                                                "Registeration not complete",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, Login.class
                ));
            }
        });

    }
    //Asettaa muuttujat näkymille sekä niille tarkoitetuille id:lle.
    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUserName);
        userPassword = (EditText)findViewById(R.id.etuserpassword);
        userEmail = (EditText)findViewById(R.id.etuseremail);
        registerBtn = (Button)findViewById(R.id.registerbtn);
        userLogin = (TextView)findViewById(R.id.tvalreadysignedup);
    }

    private boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }
}