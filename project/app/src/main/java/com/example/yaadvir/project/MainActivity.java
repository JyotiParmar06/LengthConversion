package com.example.yaadvir.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView ChangePassword;
    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.Name);
        Password=(EditText)findViewById(R.id.Password);
        ChangePassword=(TextView)findViewById(R.id.Password);
        Login=(Button)findViewById(R.id.Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validte(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void Validte(String userName,String userPassword){
        if((userName.equals("admin"))&&(userPassword.equals("parmar"))){
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getBaseContext(),"UserName and Password are incorrect",Toast.LENGTH_SHORT).show();
        }

    }
}

