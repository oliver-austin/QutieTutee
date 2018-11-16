//
// Created by Tom Heysel on 10/27/2018.
//

#include "User.h"

//Constructors
User::User() {
    setName("default");
}

User::User(std::string email){
    setEmail(email);
}

User::User(std::string name, std::string email, std::string pwrd, std::string s_course, std::string
            t_course, std::string location){
    setName(name);
    setEmail(email);
    setPwrd(pwrd);
    setTCourse(t_course);
    setSCourse(s_course);
}

//Accessors
//std::vector<std::string> User::getCourses() {
  //  return clone(courses);
//}

std::string User::getName() {
    return clone(name);
}

std::string User::getEmail() {
    return clone(email);
}

std::string User::getPwrd()  {
    return clone(pwrd);
}

std::string User::getUID(){
    return clone(user_id);
}

std::string User::getLocation() {
    return clone(location);
}

std::string User::getTCourse() {
    return clone(t_course);
}

std::string User::getSCourse(){
    return clone(s_course);
}
//Mutators
void User::setCourses(std::string courseCode){//entering courses one at a time
    courses.push_back(courseCode);
}

void User::setName(std::string name) {
    this->name = name;
}

void User::setEmail(std::string email) {
    this->email = email;
}

void User::setPwrd(std::string pwrd) {
    this->pwrd = pwrd;
}

void User::setUID(std::string UID) {
    user_id = UID;
}


void User::setLocation(std::string location) {
    this->location = location;
}

void User::setTCourse(std::string t_course) {
    this->t_course = t_course;
}

void User::setSCourse(std::string s_course) {
    this->s_course = s_course;
}

//Clones
std::string User::clone(std::string original) {
    std::string copy = original;
    return copy;
}

/*std::vector<std::string> User::clone(std::vector<std::string> original){
    std::vector<std::string> clone;
    for(std::string course : original){
        clone.push_back(course);
    }
    return clone;
}*/