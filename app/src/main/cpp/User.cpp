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
            t_course, std::string contact, int tutor, std::string bio, double rate, int status, std::string location){
    setName(name);
    setEmail(email);
    setPwrd(pwrd);
    setTCourse(t_course);
    setSCourse(s_course);
    setContact(contact);
    setTutor(tutor);
    setBio(bio);
    setRate(rate);
    setStatus(status);
    setLocation(location);
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

std::string User::getTCourse() {
    return clone(t_course);
}

std::string User::getSCourse(){
    return clone(s_course);
}

std::string User::getBio() {
    return clone(bio);
}

std::string User::getContact() {
    return clone(contact);
}

std::string User::getLocation() {
    return clone(location);
}

int User::getTutor() {
    int copy = tutor;
    return copy;
}

double User::getRate() {
    double copy = rate;
    return copy;
}
int User::getStatus(){
    int copy = status;
    return copy;
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

void User::setTCourse(std::string t_course) {
    this->t_course = t_course;
}

void User::setSCourse(std::string s_course) {
    this->s_course = s_course;
}

void User::setContact(std::string contact){
    this->contact = contact;
}

void User::setTutor(int tutor) {
    this->tutor = tutor;
}

void User::setBio(std::string bio) {
    this->bio = bio;
}

void User::setRate(double rate) {
    this->rate = rate;
}

void User::setStatus(int status) {
    this->status = status;
}
void User::setLocation(std::string location) {
    this->location = location;
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