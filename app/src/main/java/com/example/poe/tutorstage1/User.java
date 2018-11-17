package com.example.poe.tutorstage1;

        import java.io.Serializable;

public class User implements Serializable {
    public User(){
        name = "Oliver";
        s_course = null;
        t_courses = null;
        email = null;
        pwrd = null;
        location = null;
        tutor = 0;
        bio = null;
        contact = null;
        status = 0;

    }
    private String message;
    String name;
    String s_course;
    String t_courses;
    String email;
    String location;
    String pwrd;
    String bio;
    String contact;
    int tutor;
    double rate;
    int status;

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

    public String getBio() { return bio; }

    public void setBio(String bio) { this.bio = bio; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public int getTutor() { return tutor; }

    public void setTutor(int tutor) { this.tutor = tutor; }

    public double getRate() { return rate; }

    public void setRate(double rate) { this.rate = rate; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }
}
