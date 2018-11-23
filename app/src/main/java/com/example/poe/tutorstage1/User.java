package com.example.poe.tutorstage1;

        import java.io.Serializable;

public class User implements Serializable {
    public User(){
        name = "";
        s_courses = "";
        t_courses = "";
        email = "";
        password = "";
        location = "";
        tutor = 0;
        bio = "";
        contact = "";
        status = 0;
        available = 0;
        duration = 0;
        in_session = 0;
        stars = 0.0;

    }

    public  User(User original){
        name = original.getName();
        s_courses = original.getS_courses();
        t_courses = original.getT_courses();
        email = original.getEmail();
        password = original.getPassword();
        location = original.getLocation();
        tutor = original.getTutor();
        bio = original.getBio();
        contact = original.getContact();
        status = original.getStatus();
        available = original.getAvailable();
        duration = original.getDuration();
        in_session = original.getIn_session();
        stars = original.getStars();
    }


    private String message;
    String name;
    String s_courses;
    String t_courses;
    String email;
    String location;
    String password;
    String bio;
    String contact;
    int tutor;
    double rate;
    int status;
    int available;
    int duration;
    int in_session;
    double stars;

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

    public String getLocation() { return location; }

    public void setLocation(String location) {this.location = location;}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password;}

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

    public int getAvailable() { return available; }

    public void setAvailable(int available) { this.available = available; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public int getIn_session() { return in_session; }

    public void setIn_session(int in_session) { this.in_session = in_session; }

    public double getStars() { return stars; }

    public void setStars(double stars) { this.stars = stars; }
}
