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
import com.google.firebase.auth.FirebaseUser;

/**
 * @author Jukka-Pekka lappalainen
 * Android Studio 4.0.1
 * Build #AI-193.6911.18.40.6626763, built on June 25, 2020
 * Rekisteröitymis näkymä, jossa luodaan käyttäjätunnus ja salasana.
 */
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

        /**
         * "Register" napin käsky. Lataa datan databaseen käyttäen
         * Googlen Firebase sivustolta ladattua APIa ja kirjastoa.
         * ja kertoo käyttäjälle onko tehtävä onnistunut vai ei.
         * Jos on niin siirrytään Login activityyn.
         */
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //Kertoo käyttäjälle onko tehtävä onnistunut vai ei.
                                    //jos on niin siirrytään Login acticityyn.
                                    if(task.isSuccessful()){
                                        sendEmailVertification();
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
        /**
         * Vie käyttäjän takaisin Login aktiviteettiin.
         */
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, Login.class
                ));
            }
        });

    }
    /**
     * Asettaa muuttujat näkymille sekä niille tarkoitetuille id:lle.
     */

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUserName);
        userPassword = (EditText)findViewById(R.id.etuserpassword);
        userEmail = (EditText)findViewById(R.id.etuseremail);
        registerBtn = (Button)findViewById(R.id.registerbtn);
        userLogin = (TextView)findViewById(R.id.tvalreadysignedup);
    }

    /**
     * Kertoo, onko käyttäjä syöttänyt kaikki tarvittavat syötteet.
     * @return
     */
    private boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Enter all the details", Toast.LENGTH_SHORT).show();
        } else{
            result = true;
        }
        return result;
    }
    /**
     * Jos todentaminen onnistuu, siirtää login aktiviteettiin.
     */

    private void sendEmailVertification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            /**
             * Kun firebase saa  tiedon käyttäjästä, lähettää se todennusviestin ja ilmoittaa siitä
             * käyttäjälle.
             */
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegistrationActivity.this,
                                "Register complete. Check your email.",
                                Toast.LENGTH_SHORT).show();
                        /**
                         * käyttäjä kirjautuu joka tapauksessa sisään, joten
                         * Joten käyttäjä kirjattava ulos, ennen todennusta.
                         */
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegistrationActivity.this,
                                Login.class));
                    }else{
                        /**
                         * Jos käyttäjä ei ole todentanut meiliä tai Firebase alhaalla, niin->
                         */
                        Toast.makeText(RegistrationActivity.this,
                                "You haven't verified your email",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}