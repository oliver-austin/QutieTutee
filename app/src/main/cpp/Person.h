//
// Created by Tom Heysel on 10/27/2018.
//
#pragma once

#include <string>
#include <vector>


class Person {
public:
    //constructor
    Person();
    Person(std::string email);


    //Accesors
    std::vector<std::string> getCourses();
    std::string getFirstName();
    std::string getLastName();
    std::string getEmail();
    std::string getPwrd();//incorporates no encryption
    std::string getUID();
    std::string getLocation();

    //Mutators
    void setCourses(std::string courseCode);//used to enter one by one
    void setFirstName(std::string first_name);
    void setLastName(std::string last_name);
    void setEmail(std::string email);
    void setUID(std::string UID);
    void setPwrd(std::string pwrd);//incorporates no encryption
    void setLocation(std::string loaction);

    //Clones
    std::string clone(std::string);
    std::vector clone(std::vector<std::string>);

private:
    //Private Attributes
    std::vector<std::string>  courses;
    std::string first_name;
    std::string last_name;
    std::string email;
    std::string pwrd;//incorporates no encryption
    std::string user_id;
    std::string location;

};

