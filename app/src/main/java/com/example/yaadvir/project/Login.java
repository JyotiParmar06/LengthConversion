package com.example.yaadvir.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public EditText Name;
    public EditText Password;
    public Button ChangePassword;
    public Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Name=(EditText)findViewById(R.id.Name);
        Password=(EditText)findViewById(R.id.Password);
        ChangePassword=(Button)findViewById(R.id.password);
        Login=(Button)findViewById(R.id.Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validte(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    public void Validte(String userName,String userPassword){
        Credential credential = Credential.getInstance();

        if((userName.equals(credential.getUsername()))&&(userPassword.equals(credential.getPassword()))){
            Intent intent=new Intent(Login.this,Converter.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getBaseContext(),"UserName and Password are incorrect",Toast.LENGTH_SHORT).show();
        }

    }

    public void password(View myV){
        Intent myIntent= new Intent(this,ChangePasswordActivity.class);
        startActivity(myIntent);
    }


}

