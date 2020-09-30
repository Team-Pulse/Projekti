package com.example.kalorilaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView info;
    private Button loginbutton;
    private int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etpassword);
        info = (TextView)findViewById(R.id.tvinfo);
        loginbutton = (Button)findViewById(R.id.btnlogin);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
    }

    /*
     *
     * @param userName username jonka if lausekkeen oletusasetuksena "Admin"
     * @param userPassword salasana jonka toimii oletuksena if lausekkeessa "1234"
     */
    private void validate(String userName, String userPassword){
        //If lauseke joka määrittelee uuden aktiviteetin aukeamisen salasanan ja käyttäjä-
        //tunnuksen oikeinkirjoituksen yhteydessä.

        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }else{
            counter --;
            info.setText("Number of attempts remaining" + String.valueOf(counter));

            if(counter == 0){
                loginbutton.setEnabled(false);
            }
        }
    }
}