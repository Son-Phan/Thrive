package com.group20.thrive;

import android.content.Intent;
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
    }

    @Override
    public void onStart() {
        super.onStart();

        // run a random query to notify the system to create database
        ThriveDatabase db = Room.databaseBuilder(getApplicationContext(),
                ThriveDatabase.class, "thrive_database.db").allowMainThreadQueries().build();
//        UserDao userDao = db.userDao();
//        userDao.addUser(new User("t",0,0,0,0,0));
//        DiaryDao dir = db.diaryDao();
//        dir.addDiary(new Diary("14/09/2021", "good", 20, "Push up", 60, "Thanks"));
//        dir.addDiary(new Diary("14/09/2021", "not bad", 40, "Pull up", 80, "Thanks"));
//        dir.addDiary(new Diary("14/09/2021", "bad", 60, "Run", 40, "Thanks"));
//        PlanDao pl = db.planDao();
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));
//        pl.addPlan(new Plan("natural", "ab", R.drawable.img,10, "The desirable" +
//                " end goal of the Thrive at Work process is a an action plan for your business, " +
//                "which delivers on a wellness strategy; which in turn fits with your organisation’" +
//                "s overall strategy and enables the business and its people."));

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        } else {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }
    }



}