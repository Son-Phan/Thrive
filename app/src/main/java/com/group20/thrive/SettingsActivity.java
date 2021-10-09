package com.group20.thrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.group20.thrive.database.ActivityDao;
import com.group20.thrive.database.LessonDao;
import com.group20.thrive.database.Plan;
import com.group20.thrive.database.PlanDao;
import com.group20.thrive.database.ThriveDatabase;
import com.group20.thrive.database.User;
import com.group20.thrive.database.UserDao;
import com.group20.thrive.ui.plans.PlansViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class SettingsActivity extends AppCompatActivity {

    private PopupWindow ChangeUserNamePopUpWindow;
    private PopupWindow ChangeUserGoalPopUpWindow;
    private PopupWindow ChangeCurrentPlanPopUpWindow;
    private PlansViewModel plansViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setTitle("Settings");

        plansViewModel = new ViewModelProvider(this).get(com.group20.thrive.ui.plans.PlansViewModel.class);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button changeExerciseGoal = findViewById(R.id.changeExerciseGoal);
        Button changeMeditationGoal = findViewById(R.id.changeMeditationGoal);
        Button changeUserActivityGoal = findViewById(R.id.changeUserActivityGoal);
        Button changeCurrentPlan = findViewById(R.id.changeCurrentPlan);

        Button deletePlan = findViewById(R.id.deletePlan);
        Button deleteActivity = findViewById(R.id.deleteActivity);

        changeExerciseGoal.setOnClickListener(view -> ChangeUserGoalPopUpWindow(view, "exercise"));
        changeMeditationGoal.setOnClickListener(view -> ChangeUserGoalPopUpWindow(view, "meditation"));
        changeUserActivityGoal.setOnClickListener(view -> ChangeUserGoalPopUpWindow(view, "userActivity"));
        changeCurrentPlan.setOnClickListener(this::ChangeCurrentPlanPopUpWindow);

        deletePlan.setOnClickListener(view -> deleteDataPopUpWindow(view, "plan"));
        deleteActivity.setOnClickListener(view -> deleteDataPopUpWindow(view, "activity"));

        Button signOut = findViewById(R.id.signOutBtn);

        signOut.setOnClickListener(view -> signOut());
    }

    // create change user name pop up window
    public void ChangeUserNamePopUpWindow(View view) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_change_username, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        ChangeUserNamePopUpWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        ChangeUserNamePopUpWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        EditText userNameInput = popupView.findViewById(R.id.newUserNameInput);

        Button newUserNameConfirmBtn = popupView.findViewById(R.id.newUserNameConfirmBtn);
        newUserNameConfirmBtn.setOnClickListener(v -> {
            String newUserName = userNameInput.getText().toString();
            updateUserName(newUserName);
            ChangeUserNamePopUpWindow.dismiss();
        });
    }

    public void updateUserName(String newUserName) {
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            UserDao userDao = db.userDao();
            userDao.updateUserName(newUserName);
            db.close();
        });
    }

    // create change user goal pop up window
    public void ChangeUserGoalPopUpWindow(View view, String goalChange) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_change_user_goal, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        ChangeUserGoalPopUpWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        ChangeUserGoalPopUpWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        EditText userGoalInput = popupView.findViewById(R.id.newUserGoalInput);

        Button newUserGoalConfirmBtn = popupView.findViewById(R.id.newUserGoalConfirmBtn);
        newUserGoalConfirmBtn.setOnClickListener(v -> {
            String newGoalInput = userGoalInput.getText().toString();
            if (newGoalInput.isEmpty()) {
                Toast.makeText(this, "nothing?! don't give up, aim higher, you can do it!", Toast.LENGTH_SHORT).show();
            } else {
                int newUserGoal = Integer.parseInt(userGoalInput.getText().toString());
                updateUserGoal(newUserGoal, goalChange);
                ChangeUserGoalPopUpWindow.dismiss();
            }
        });
    }

    public void updateUserGoal(int newGoal, String goalChange) {
        if (goalChange.equals("exercise")) {
            Executors.newSingleThreadExecutor().execute(() -> {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                        ThriveDatabase.THRIVE_DATABASE_NAME).build();
                UserDao userDao = db.userDao();
                userDao.updateExerciseGoal(newGoal);
                db.close();
            });
        } else if (goalChange.equals("meditation")) {
            Executors.newSingleThreadExecutor().execute(() -> {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                        ThriveDatabase.THRIVE_DATABASE_NAME).build();
                UserDao userDao = db.userDao();
                userDao.updateMeditationGoal(newGoal);
                db.close();
            });
        } else {
            Executors.newSingleThreadExecutor().execute(() -> {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                        ThriveDatabase.THRIVE_DATABASE_NAME).build();
                UserDao userDao = db.userDao();
                userDao.updateUserActivityGoal(newGoal);
                db.close();
            });
        }
    }

    public void ChangeCurrentPlanPopUpWindow(View view) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_change_current_plan, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        ChangeCurrentPlanPopUpWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        ChangeCurrentPlanPopUpWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        EditText newCurrentPlan = popupView.findViewById(R.id.newCurrentPlanInput);

        Button newCurrentPlanConfirmBtn = popupView.findViewById(R.id.newCurrentPlanConfirmBtn);
        newCurrentPlanConfirmBtn.setOnClickListener(v -> {
            String planName = newCurrentPlan.getText().toString();
            if (planName.length() == 0) {
                Toast.makeText(this, "Just give me the name and I'll take care of the rest", Toast.LENGTH_SHORT).show();
            } else {
                plansViewModel.getAllPlanNames().observe(this, newData -> {
                    if (newData.contains(planName)) {
                        updateCurrentPlan(planName);
                        ChangeCurrentPlanPopUpWindow.dismiss();
                    } else {
                        Toast.makeText(this, "Never heard before, probably fake name", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void updateCurrentPlan(String planName) {
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            PlanDao planDao = db.planDao();
            UserDao userDao = db.userDao();
            int planId = planDao.getPlanId(planName);
            userDao.updateCurrentPlan(planId);
            userDao.updateCurrentLesson(planId);
            db.close();
        });
    }

    public void deleteDataPopUpWindow(View view, String dataType) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_window_delete_data, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        ChangeCurrentPlanPopUpWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        ChangeCurrentPlanPopUpWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        TextView title = popupView.findViewById(R.id.deleteData);
        String text = "Enter " + dataType + " name";
        title.setText(text);

        EditText deleteDataInput = popupView.findViewById(R.id.deleteDataInput);

        Button deleteDataConfirmBtn = popupView.findViewById(R.id.deleteDataConfirmBtn);
        deleteDataConfirmBtn.setOnClickListener(v -> {
            String dataName = deleteDataInput.getText().toString();
            if (dataName.length() == 0) {
                Toast.makeText(this, "Give me the name and you won't see it again", Toast.LENGTH_SHORT).show();
            } else if (dataType.equals("plan")) {
                plansViewModel.getAllPlanNames().observe(this, newData -> {
                    newData.remove(0);
                    if (newData.contains(dataName)) {
                        deleteData(dataName, dataType);
                        ChangeCurrentPlanPopUpWindow.dismiss();
                    } else {
                        Toast.makeText(this, "Not on the list, are you sure you at the right place?", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                plansViewModel.getActivityNamesOfType("userActivity").observe(this, newData -> {
                    if (newData.contains(dataName)) {
                        deleteData(dataName, dataType);
                        ChangeCurrentPlanPopUpWindow.dismiss();
                    } else {
                        Toast.makeText(this, "Not on the list, either you got the wrong name or I have the wrong list", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void deleteData(String dataName, String dataType) {
        if (dataType.equals("plan")) {
            Executors.newSingleThreadExecutor().execute(() -> {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                        ThriveDatabase.THRIVE_DATABASE_NAME).build();
                UserDao userDao = db.userDao();
                PlanDao planDao = db.planDao();
                LessonDao lessonDao = db.lessonDao();
                String userCurrentPlan = planDao.getPlanName(userDao.getCurrUser().getCurrentPlan());
                if (dataName.equals(userCurrentPlan)) {
                    userDao.updateCurrentPlan(1);
                    userDao.updateCurrentLesson(1);
                }
                int planId = planDao.getPlanId(dataName);
                planDao.deletePlan(dataName);
                lessonDao.deleteLesson(planId);
                db.close();
            });
        } else {
            Executors.newSingleThreadExecutor().execute(() -> {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                        ThriveDatabase.THRIVE_DATABASE_NAME).build();
                ActivityDao activityDao = db.activityDao();
                int activityId = activityDao.getActivityId(dataName);
                activityDao.deleteActivity(dataName);
                activityDao.deleteLessonActivityCrossRef(activityId);
                db.close();
            });
        }
    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}