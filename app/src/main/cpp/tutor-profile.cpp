#include <jni.h>
#include <string>
#include "User.cpp"
#include "User.h"

extern "C" {
JNIEXPORT void JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_saveProfile(JNIEnv *env, jobject, jlong ptr,
                                                                  jstring userNameJava,
                                                                  jstring userCoursesJava,
                                                                  jstring userBioJava,
                                                                  jstring userContactJava,
                                                                  jdouble userRateJava, jstring userLocationJava) {
    // Get C++ User object fields
    User *obj = (User *) ptr;
    std::string name = obj->getName();
    std::string bio = obj->getBio();
    std::string courses = obj->getTCourse();
    std::string contact = obj->getContact();
    std::string location = obj->getLocation();
    double rate = obj->getRate();

    //Get fields from GUI in C++
    const char *pathName = env->GetStringUTFChars(userNameJava, NULL);
    std::string nameGUI = std::string(pathName);
    const char *pathCourses = env->GetStringUTFChars(userCoursesJava, NULL);
    std::string coursesGUI = std::string(pathCourses);
    const char *pathBio = env->GetStringUTFChars(userBioJava, NULL);
    std::string bioGUI = std::string(pathBio);
    const char *pathContact = env->GetStringUTFChars(userContactJava, NULL);
    std::string contactGUI = std::string(pathContact);
    const char *pathLocation = env->GetStringUTFChars(userLocationJava, NULL);
    std::string locationGUI = std::string(pathLocation);

    //Compare GUI and C++ object values, if different update C++ object values
    if (coursesGUI != courses || nameGUI != name || bioGUI != bio || rate != userRateJava ||
        contactGUI != contact || locationGUI != location) {
        obj->setTCourse(coursesGUI);
        obj->setName(nameGUI);
        obj->setBio(bioGUI);
        obj->setContact(contactGUI);
        obj->setRate(userRateJava);
        obj->setLocation(locationGUI);

    }
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getUserName(JNIEnv *env, jobject,
                                                                  jlong ptr) {
    User *obj = (User *) ptr;
    std::string name = obj->getName();
    return env->NewStringUTF(name.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getStudentCourse(JNIEnv *env, jobject,
                                                                       jlong ptr) {
    User *obj = (User *) ptr;
    std::string course = obj->getSCourse();
    return env->NewStringUTF(course.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getEmail(JNIEnv *env, jobject,
                                                               jlong ptr) {
    User *obj = (User *) ptr;
    std::string email = obj->getEmail();
    return env->NewStringUTF(email.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getPassword(JNIEnv *env, jobject,
                                                                  jlong ptr) {
    User *obj = (User *) ptr;
    std::string password = obj->getPwrd();
    return env->NewStringUTF(password.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getTutorCourse(JNIEnv *env, jobject,
                                                                     jlong ptr) {
    User *obj = (User *) ptr;
    std::string t_course = obj->getTCourse();
    return env->NewStringUTF(t_course.c_str());
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getTutor(JNIEnv *env, jobject,
                                                               jlong ptr) {
    User *obj = (User *) ptr;
    int tutor = obj->getTutor();
    return tutor;
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getBio(JNIEnv *env, jobject,
                                                             jlong ptr) {
    User *obj = (User *) ptr;
    std::string bio = obj->getBio();
    return env->NewStringUTF(bio.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getContact(JNIEnv *env, jobject,
                                                                 jlong ptr) {
    User *obj = (User *) ptr;
    std::string contact = obj->getContact();
    return env->NewStringUTF(contact.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getLocation(JNIEnv *env, jobject,
                                                                 jlong ptr) {
    User *obj = (User *) ptr;
    std::string location = obj->getLocation();
    return env->NewStringUTF(location.c_str());
}
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getRate(JNIEnv *env, jobject,
                                                              jlong ptr) {
    User *obj = (User *) ptr;
    double rate = obj->getRate();
    return rate;
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getStatus(JNIEnv *env, jobject,
                                                               jlong ptr) {
    User *obj = (User *) ptr;
    int status = obj->getStatus();
    return status;
}
}
