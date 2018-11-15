package com.example.poe.tutorstage1;

public class tutorListItem {
    private String head;
    private String desc;
    private String rate;
    private Boolean isActive;

    public tutorListItem(String head, String desc, String rate, Boolean isActive) {
        this.head = head;
        this.desc = desc;
        this.rate = rate;
        this.isActive = isActive;

    }

    public String getRate() {
        return rate;
    }

    public String getHead() {

        return head;
    }

    public String getDesc() {
        return desc;
    }

    public  Boolean getIsActive(){
        return isActive;
    }
}
