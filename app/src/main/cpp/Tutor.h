//
// Created by Poe on 10/28/2018.
//

#include "User.h"

class Tutor: public User {
public:
    //Constructors
    Tutor(std::string email);

    //Accessors
    bool getStatus();//returns true if available for immediate tutoring
    bool getSessionStatus();//returns true if currently in tutoring session
    int getAvailability();//returns availability - the combination of status and session status
    float getRating();//returns star rating of tutor
    float getPrice();//returns hourly rate the tutor charges

    //Mutators
    void setStatus(bool status);
    void setSessionStatus(bool in_session);
    void setAvailability(bool status, bool in_session); //sets 1 if (status == true) && (in_session == false)
    //0 if (status == true) && (in_session == true)
    //-1 if (status == false)
    void setRating(int yourRating);//only used for students, tutor has no access
    void setPrice(float price);

private:
    bool status;//true if available for immediate tutoring
    bool in_session;//true if currently in session
    int availability;//combination of status and in_session
    float rating;//Star rating of tutor, averaged over all submissions
    float price;//hourly rate tutor charges
};
