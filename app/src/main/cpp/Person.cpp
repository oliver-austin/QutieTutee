//
// Created by Tom Heysel on 10/27/2018.
//

#include "Person.h"

//Constructors
Person::Person() {
    setFirstName("default");
}

Person::Person(std::string email){
  setEmail(email);
}

//Accessors
std::vector<std::string> Person::getCourses() {
  return clone(courses);
}

std::string Person::getFirstName() {
  return clone(first_name);
}

std::string Person::getLastName() {
  return clone(last_name);
}

std::string Person::getEmail() {
  return clone(email);
}

std::string Person::getPwrd()  {
  return clone(pwrd);
}

std::string Person::getUID(){
  return clone(user_id);
}

std::string Person::getLocation() {
  return clone(location);
}

//Mutators
void Person::setCourses(std::string courseCode){//entering courses one at a time
  courses.push_back(courseCode);
}

void Person::setFirstName(std::string first_name) {
   this->first_name = first_name;
}

void Person::setLastName(std::string last_name) {
  this->last_name = last_name;
}

void Person::setEmail(std::string email) {
  this->email = email;
}

void Person::setPwrd(std::string pwrd) {
  this->pwrd = pwrd;
}

void Person::setUID(std::string UID) {
  user_id = UID;
}

void Person::setLocation(std::string location) {
  this->location = location;
}

//Clones
std::string Person::clone(std::string original) {
  std::string copy = original;
  return copy;
}

std::vector<std::string> Person::clone(std::vector<std::string> original){
  std::vector<std::string> clone;
  for(std::string course : original){
    clone.push_back(course);
  }
  return clone;
}