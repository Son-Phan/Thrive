package com.group20.thrive;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private boolean sign_in = false;

    private PopupWindow popupWindow;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    public void popUpWindow(View view) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_sign_in_activity, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        popupWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        EditText input_email = popupView.findViewById(R.id.input_email);
        EditText input_password = popupView.findViewById(R.id.input_password);

        if (view.getId() == R.id.btn_sign_in_app) {
            sign_in = true;
        }

        Button btnConfirm = popupView.findViewById(R.id.btn_sign_in_confirm);
        btnConfirm.setOnClickListener(v -> {
            String email = input_email.getText().toString();
            String password = input_password.getText().toString();

            sign_in_confirm(email, password, sign_in);
        });
    }

    public void sign_in_confirm(String email, String password, boolean sign_in) {

        final String TAG = SignInActivity.class.getName();

        if (email.isEmpty()) {
            Toast.makeText(SignInActivity.this, "Please enter your email!", Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(SignInActivity.this, "Please enter your password!", Toast.LENGTH_SHORT).show();
        } else {
            if (sign_in) {
                sign_in(email, password, TAG);
            } else {
                sign_up(email, password, TAG);
            }
        }
    }

    private void sign_in (String email, String password, String TAG) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(SignInActivity.this, "Welcome " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(SignInActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void sign_up (String email, String password, String TAG) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(SignInActivity.this, "Welcome " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(SignInActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        popupWindow.dismiss();
        super.onDestroy();
    }
}
