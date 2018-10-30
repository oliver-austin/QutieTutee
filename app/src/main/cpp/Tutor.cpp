//
// Created by Tom Heysel on 10/27/2018.
//

#include "Tutor.h"

//Constructors
Tutor::Tutor(std::string email){
    Person::Person(email);
}

//Accessors
bool Tutor::getStatus() {
    return status;
}

bool Tutor::getSessionStatus(){
    return in_session;
}

int Tutor::getAvailability() {
    return availability;
}

float Tutor::getRating() {
    return rating;
}

float Tutor::getPrice() {
    return price;
}

//Mutators
void Tutor::setStatus(bool status) {
    this->status = status;
}

void Tutor::setSessionStatus(bool in_session) {
    this->in_session = in_session;
}

void Tutor::setAvailability(bool status, bool in_session) {
    if(status == false){
        availability = -1;
    }
    else{
        if(in_session == true)
            availability = 0;
        else
            availability = 1;
    }
}

void Tutor::setPrice(float price) {
    this->price = price;
}
