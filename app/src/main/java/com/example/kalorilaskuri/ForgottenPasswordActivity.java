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

/**
 * Class for password reset
 *
 * @author Jukka-Pekka Lappalainen
 * @version Android Studio 4.0.1 Build #AI-193.6911.18.40.6626763, built on June 25, 2020
 */

public class ForgottenPasswordActivity extends AppCompatActivity {

    /**
     * Edittext kenttä sähköpostille., johon salasanan nollausviesti lähetetään
     */
    private EditText forgottenPasswordEmail;
    /**
     * salasanan reset nappi.
     */
    private Button passwordResetbtn;

    /**
     * FirebauseAuth olio.
     */
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        forgottenPasswordEmail = (EditText)findViewById(R.id.etForgottenPasswordEmail);
        passwordResetbtn = (Button)findViewById(R.id.passwordResetbtn);
        firebaseAuth = FirebaseAuth.getInstance();

        /**
         * Lähettää pyynnön firebase databaseen, josta sähköpostin resetointi varmistusviesti tulee
         */
        passwordResetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ottaa edittext olion, kääntää sen Stringiksi ja poistaa välilyönnit.
                String userEmail = forgottenPasswordEmail.getText().toString().trim();

                /*
                 * Jos syöte on tyhjä, niin lähettää Toastin "Enter your email"
                 */
                if(userEmail.equals("")){
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