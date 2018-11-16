package com.example.poe.tutorstage1;

        import java.io.Serializable;

public class User implements Serializable {
    public User(){
        message = "test";
        name = null;
        s_courses = null;
        t_courses = null;
        email = null;
        pwrd = null;
        location = null;
    }
    private String message;
    String name;
    String s_course;
    String t_courses;
    String email;
    String location;
    String pwrd;

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getS_courses() {
        return s_course;
    }

    public void setS_courses(String s_courses) {
        this.s_course = s_courses;
    }

    public String getT_courses() {
        return t_courses;
    }

    public void setT_courses(String t_courses) {
        this.t_courses = t_courses;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) {this.location = location;}

    public String getPwrd() { return pwrd; }

    public void setPwrd(String pwrd) { this.pwrd = pwrd;}
}