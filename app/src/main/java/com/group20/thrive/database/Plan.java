package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "plan")
public class Plan implements Serializable {


    @PrimaryKey(autoGenerate = true)
    public int planId;
    public String planName;
    public int planLength;
    public String planDescription;

    public Plan(String planName, Integer planLength, String planDescription) {
        this.planName = planName;
        this.planLength = planLength;
        this.planDescription = planDescription;
    }

    public int getPlanId() { return planId; }

    public String getPlanName() { return planName; }

    public int getPlanLength() { return planLength; }

    public String getPlanDescription () { return planDescription; }

    public void setPlanId(int planId) {
        this.planId = planId;
    }


}
