package com.group20.thrive.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM User")
    User getCurrUser();

    @Query("SELECT * FROM User")
    LiveData<User> getUser();

}
