//
// Created by Tom Heysel on 10/27/2018.
//
#pragma once

#include <string>
#include <vector>



class User {
public:
    //constructor
    User();
    User(std::string email);
    User(std::string name, std::string email, std::string pwrd, std::string s_course, std::string
    t_course, std::string contact, int tutor, std::string bio, double rate, int status, std::string location, int available, int duration, int in_session, double stars);


    //Accessors
    std::vector<std::string> getCourses();
    std::string getName();
    std::string getEmail();
    std::string getPwrd();//incorporates no encryption
    std::string getTCourse();
    std::string getSCourse();
    std::string getBio();
    std::string getContact();
    std::string getLocation();
    int getTutor();
    double getRate();
    int getStatus();
    int getAvailable();
    int getDuration();
    int getIn_session();
    double getStars();

    //Mutators
    void setCourses(std::string courseCode);//used to enter one by one
    void setName(std::string name);
    void setEmail(std::string email);
    void setPwrd(std::string pwrd);//incorporates no encryption
    void setTCourse(std::string t_course);
    void setSCourse(std::string s_course);
    void setContact(std::string contact);
    void setTutor(int tutor);
    void setBio(std::string bio);
    void setRate(double rate);
    void setLocation(std::string location);
    void setStatus(int status);
    void setAvailable(int available);
    void setDuration(int duration);
    void setIn_session(int in_session);
    void setStars(double stars);

    //Clones
    std::string clone(std::string);
//    std::vector clone(std::vector<std::string>);

private:
    //Private Attributes
    std::vector<std::string> courses;
    std::string name;
    std::string email;
    std::string pwrd;//incorporates no encryption
    std::string s_course;
    std::string t_course;
    std::string bio;
    std::string contact;
    std::string location;
    int tutor;
    double rate;
    int status;
    int available;
    int duration;
    int in_session;
    double stars;
};

