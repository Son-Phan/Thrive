package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
    private ThriveDatabase thriveDatabase;
    private UserDao userDao;
    private User user;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.inMemoryDatabaseBuilder(context, ThriveDatabase.class).build();
        userDao = thriveDatabase.userDao();
        user = new User("trung", 10,10,10,10,10,10,10);
        userDao.addUser(user);
    }

    @After
    public void tearDown() throws Exception {
        thriveDatabase.close();
    }

    @Test
    public void userDaoExist(){
        assertNotNull(userDao);
    }



}