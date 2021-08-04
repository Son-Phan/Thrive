package com.group20.thrive;

public class Plans {


    private String TitleName;
    private int Id;

    public Plans(String titleName, int id) {
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
