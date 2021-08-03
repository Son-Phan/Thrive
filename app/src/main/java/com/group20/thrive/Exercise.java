package com.group20.thrive;

public class Exercise {


    private String TitleName;
    private int Id;

    public Exercise( String titleName, int id) {
        TitleName = titleName;
        Id = id;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }




}
