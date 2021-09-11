package com.group20.thrive.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plan")
public class Plan {


    @PrimaryKey(autoGenerate = true)
    public int planId;
    public String planName;
    public String planType;
    public int planLength;
    public String planDescription;

    public int getImageLocation() {
        return imageLocation;
    }

    public int imageLocation;

    public Plan(String planName, String planType, int imageLocation, int planLength, String planDescription) {
        this.imageLocation = imageLocation;
        this.planName = planName;
        this.planType = planType;
        this.planLength = planLength;
        this.planDescription = planDescription;
    }

    public int getPlanId() { return planId; }

    public String getPlanName() { return planName; }

    public String getPlanType() { return planType; }

    public int getPlanLength() { return planLength; }

    public String getPlanDescription () { return planDescription; }
    public void setPlanId(int planId) {
        this.planId = planId;
    }


}
