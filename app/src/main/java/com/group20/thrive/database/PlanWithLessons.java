package com.group20.thrive.database;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class PlanWithLessons {
    @Embedded public Plan plan;
    @Relation(
            parentColumn = "planId",
            entityColumn = "planId"
    )
    public List<Lesson> lessons;
}
