package com.example.kalorilaskuri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class Login extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView info;
    private Button loginbutton;
    private int counter = 3;
    private TextView userRegisteration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etuserpassword);
        info = (TextView)findViewById(R.id.tvinfo);
        loginbutton = (Button)findViewById(R.id.btnlogin);
        userRegisteration = (TextView)findViewById(R.id.tvregister);

        info.setText("Number of attempts remaining " + counter);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);//
        FirebaseUser user = firebaseAuth.getCurrentUser();/*Kommunikoi databasen kanssa ja kertoo
                                                            onko käyttäjä kirjautunut Firebaseen.*/
        if (user != null){//jos kirjautunut sisään, tuhoaa aktiviteetin ja siiryy Mainclass.classiin.
           finish();
           startActivity(new Intent(Login.this, MainActivity.class));
        }


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Tarkistaa, täsmääkö käyttäjänimi ja salasana databaseen asetettuun käyttäjätiliin
                * ja salasanaan.*/
                validate(name.getText().toString(), password.getText().toString());

            }
        });

        userRegisteration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }


    /*Jos tehtävä suoritettu, siirtää käyttäjän toiseen aktiviteettiin.*/

    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Hold on. We're logging you in.");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));


                }else{
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    counter--;

                    progressDialog.dismiss();
                    if(counter == 0){
                        loginbutton.setEnabled(false);
                    }
                }
            }
        });
    }
}