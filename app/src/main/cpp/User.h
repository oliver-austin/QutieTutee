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
    t_course, std::string contact, int tutor, std::string bio, double rate);


    //Accesors
    std::vector<std::string> getCourses();
    std::string getName();
    std::string getEmail();
    std::string getPwrd();//incorporates no encryption
    std::string getTCourse();
    std::string getSCourse();
    std::string getBio();
    std::string getContact();
    int getTutor();
    double getRate();

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
    int tutor;
    double rate;
};

