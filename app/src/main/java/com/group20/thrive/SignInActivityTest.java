package com.group20.thrive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInActivityTest extends AppCompatActivity {

    Button buttonSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_test);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogSignUp();
            }
        });
    }
    private void DialogSignUp(){
        Dialog diaglog = new Dialog(this);
        diaglog.setContentView(R.layout.sign_up_dialog_custom);
        diaglog.show();
    }
}