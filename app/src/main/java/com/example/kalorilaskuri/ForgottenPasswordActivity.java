package com.example.kalorilaskuri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgottenPasswordActivity extends AppCompatActivity {

    private EditText forgottenPasswordEmail;
    private Button passwordResetbtn;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        forgottenPasswordEmail = (EditText)findViewById(R.id.etForgottenPasswordEmail);
        passwordResetbtn = (Button)findViewById(R.id.passwordResetbtn);
        firebaseAuth = FirebaseAuth.getInstance();

        passwordResetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ottaa edittext olion, kääntää sen Stringiksi ja poistaa välilyönnit.
                String userEmail = forgottenPasswordEmail.getText().toString().trim();

                if(userEmail.equals("")){//Jos syöte tyhjä niin lähettää Toastin.
                    Toast.makeText(ForgottenPasswordActivity.this,
                            "Enter your email", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener
                            (new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgottenPasswordActivity.this,
                                        "Your reset email has been sent. Check your mail.",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgottenPasswordActivity.this,
                                        Login.class));
                            }else {
                                Toast.makeText(ForgottenPasswordActivity.this,
                                        "Sorry, we couldn't send you an reset email.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}