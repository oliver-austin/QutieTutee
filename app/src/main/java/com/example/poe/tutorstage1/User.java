package com.example.poe.tutorstage1;

        import java.io.Serializable;

public class User implements Serializable {
    public User(){
        name = null;
        s_courses = null;
        t_courses = null;
        email = null;
    }
    private String message;
    String name;
    String s_courses;
    String t_courses;
    String email;

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
        return s_courses;
    }

    public void setS_courses(String s_courses) {
        this.s_courses = s_courses;
    }

    public String getT_courses() {
        return t_courses;
    }

    public void setT_courses(String t_courses) {
        this.t_courses = t_courses;
    }
}