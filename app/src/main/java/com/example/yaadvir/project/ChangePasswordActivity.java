package com.example.yaadvir.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    }

    public void onClickpassword(View view){
        changePassword();
    }

    private void changePassword() {
        String newpassword;
        EditText oldpswrd=findViewById(R.id.editText);
        EditText newpswrd=findViewById(R.id.editText2);
        EditText currentpswrd=findViewById(R.id.editText3);

       // Credential credential=(Credential)getIntent().getSerializableExtra("credential");
       Credential credential = Credential.getInstance();
        System.out.println("password "+credential.getPassword());
        if (oldpswrd.getText().toString().equals(credential.getPassword())) {
            if (newpswrd.getText().toString().equals(oldpswrd.getText().toString())) {
                Toast.makeText(getBaseContext(), "Enter the valid password", Toast.LENGTH_SHORT).show();
            } else {

                if (!newpswrd.getText().toString().equals(currentpswrd.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Password does not match with your new password", Toast.LENGTH_SHORT).show();
                } else {
                    Intent myIntent = new Intent(getApplicationContext(), Login.class);
                    newpassword = newpswrd.toString();
                    myIntent.putExtra("newpassword", newpassword);
                    startActivity(myIntent);


                    credential.setPassword(newpassword);
                    System.out.println("password"+credential.getPassword());

                }
            }
        } else {
            Toast.makeText(getBaseContext(), "Password does not match", Toast.LENGTH_SHORT).show();
        }
    }

}
