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
    private TextView forgottenPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etuserpassword);
        info = (TextView)findViewById(R.id.tvinfo);
        loginbutton = (Button)findViewById(R.id.btnlogin);
        userRegisteration = (TextView)findViewById(R.id.tvregister);
        forgottenPassword = (TextView)findViewById(R.id.tvPasswordLost);

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
                /*Jos käyttäjä antaa oikeat syötteet, tarkistaa
                 * että käyttäjä on tehnyt sähköpostivarmenteen.*/
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

        forgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgottenPasswordActivity.class));
            }
        });
    }


    /**
     *  Tarkistaa, että käyttäjä on varmistanut sähköpostinsa, sisältää laskurin, mikä vähenee
     *  vääristä syötekerroista.
     * @param userName Käyttäjän valitsema käyttäjätunnus
     * @param userPassword Käyttäjän valitsema salasana.
     */
    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Hold on. We're logging you in.");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    /*Jos käyttäjä antaa oikeat syötteet, tarkistaa
                     * että käyttäjä on tehnyt sähköpostivarmenteen.*/
                    progressDialog.dismiss();
                    checkEmailVertification();
                }else{//Vähentää yrityskertoja jokaisella väärällä salasanasyötteellä.
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

    /**
     * Boolean sähköpostin varmistukselle. Jos totta, siirtää käyttäjän MainActivityyn.
     */
    private void checkEmailVertification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailFlag = firebaseUser.isEmailVerified(); /*emailflag on totta, jos käyttäjä
                                                              on jo todentanut sähköpostinsa.*/
        if(emailFlag){
            finish();
            startActivity(new Intent(Login.this, MainActivity.class));
        }else{
            Toast.makeText(this,"Please verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();/*Käyttäjä kirjataan sisään, kun käyttäjä syöttää kirjautumistiedot,
                                     vaikka sähköpostintodennusta ei olisi
                                     tehty, joten tästä syystä käyttäjä kirjataan ulos else silmukassa.*/
        }

    }
}