//
// Created by Tyler Lee on 2018-11-17.
//
#include <jni.h>
#include <string>
#include "User.cpp"

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getUserName(JNIEnv *env, jobject,
                                                                  jlong ptr) {
    User *obj = (User *) ptr;
    std::string name = obj->getName();
    return env->NewStringUTF(name.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getStudentCourse(JNIEnv *env, jobject,
                                                                       jlong ptr) {
    User *obj = (User *) ptr;
    std::string course = obj->getSCourse();
    return env->NewStringUTF(course.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getEmail(JNIEnv *env, jobject,
                                                               jlong ptr) {
    User *obj = (User *) ptr;
    std::string email = obj->getEmail();
    return env->NewStringUTF(email.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getPassword(JNIEnv *env, jobject,
                                                                  jlong ptr) {
    User *obj = (User *) ptr;
    std::string password = obj->getPwrd();
    return env->NewStringUTF(password.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getTutorCourse(JNIEnv *env, jobject,
                                                                     jlong ptr) {
    User *obj = (User *) ptr;
    std::string t_course = obj->getTCourse();
    return env->NewStringUTF(t_course.c_str());
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getTutor(JNIEnv *env, jobject,
                                                               jlong ptr) {
    User *obj = (User *) ptr;
    int tutor = obj->getTutor();
    return tutor;
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getBio(JNIEnv *env, jobject,
                                                             jlong ptr) {
    User *obj = (User *) ptr;
    std::string bio = obj->getBio();
    return env->NewStringUTF(bio.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getContact(JNIEnv *env, jobject,
                                                                 jlong ptr) {
    User *obj = (User *) ptr;
    std::string contact = obj->getContact();
    return env->NewStringUTF(contact.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getLocation(JNIEnv *env, jobject,
                                                                  jlong ptr) {
    User *obj = (User *) ptr;
    std::string location = obj->getLocation();
    return env->NewStringUTF(location.c_str());
}
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getRate(JNIEnv *env, jobject,
                                                              jlong ptr) {
    User *obj = (User *) ptr;
    double rate = obj->getRate();
    return rate;
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getStatus(JNIEnv *env, jobject,
                                                                jlong ptr) {
    User *obj = (User *) ptr;
    int status = obj->getStatus();
    return status;
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getAvailable(JNIEnv *env, jobject ,
                                                                   jlong ptr) {
    User *obj = (User *)ptr;
    int available = obj->getAvailable();
    return available;
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getDuration(JNIEnv *env, jobject ,
                                                                  jlong ptr) {
    User *obj = (User *)ptr;
    int duration = obj->getDuration();
    return duration;
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getInSession(JNIEnv *env, jobject ,
                                                                   jlong ptr) {
    User *obj = (User *)ptr;
    int in_session = obj->getIn_session();
    return in_session;
}
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getStars(JNIEnv *env, jobject ,
                                                               jlong ptr) {
    User *obj = (User *)ptr;
    double stars = obj->getStars();
    return stars;
}
}
