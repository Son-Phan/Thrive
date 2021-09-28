package com.group20.thrive;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.group20.thrive.database.Diary;
import com.group20.thrive.database.DiaryDao;
import com.group20.thrive.database.Plan;
import com.group20.thrive.database.PlanDao;
import com.group20.thrive.database.ThriveDatabase;
import com.group20.thrive.database.User;
import com.group20.thrive.database.UserDao;
import com.group20.thrive.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private FirebaseAuth mAuth;

    private static final String PREF_NAME = "MyPrefs";
    private static final String EXERCISE_STREAK_KEY = "exerciseStreak";
    private static final String MEDITATION_STREAK_KEY = "meditationStreak";
    private static final String SLEEP_STREAK_KEY = "sleepStreak";
    private static final String EXERCISE_DATE_KEY = "exerciseDate";
    private static final String MEDITATION_DATE_KEY = "meditationDate";
    private static final String SLEEP_DATE_KEY = "sleepDate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_today, R.id.navigation_diary, R.id.navigation_plans, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setUpStreakData();
    }

    @Override
    public void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        } else {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }
    }

    public void setUpStreakData() {
        SharedPreferences sharedPrefs = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if (!sharedPrefs.contains(EXERCISE_STREAK_KEY)) { editor.putInt(EXERCISE_STREAK_KEY, 0); }
        if (!sharedPrefs.contains(MEDITATION_STREAK_KEY)) { editor.putInt(MEDITATION_STREAK_KEY, 0); }
        if (!sharedPrefs.contains(SLEEP_STREAK_KEY)) { editor.putInt(SLEEP_STREAK_KEY, 0); }

        if (!sharedPrefs.contains(EXERCISE_DATE_KEY)) { editor.putString(EXERCISE_DATE_KEY, "00/00/0000"); }
        if (!sharedPrefs.contains(MEDITATION_DATE_KEY)) { editor.putString(MEDITATION_DATE_KEY, "00/00/0000"); }
        if (!sharedPrefs.contains(SLEEP_DATE_KEY)) { editor.putString(SLEEP_DATE_KEY, "00/00/0000"); }

        editor.apply();
    }

}