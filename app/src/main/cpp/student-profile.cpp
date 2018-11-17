#include <jni.h>
#include <string>
#include "User.cpp"

extern "C" {
JNIEXPORT void JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_saveProfile(JNIEnv *env, jobject , jlong ptr,
                                                                    jstring userNameJava, jstring userCourseJava) {
    // Get C++ User object fields
    User *obj = (User *)ptr;
    std::string name = obj->getName();
    std::string course = obj->getSCourse();

    //Get fields from GUI in C++
    const char *pathName = env->GetStringUTFChars(userNameJava, NULL);
    std::string nameGUI = std::string(pathName);
    const char *pathCourse = env->GetStringUTFChars(userCourseJava, NULL);
    std::string courseGUI = std::string(pathCourse);

    //Compare GUI and C++ object values, if different update C++ object values
    if(courseGUI != course || nameGUI != name){
        obj->setSCourse(courseGUI);
        obj->setName(nameGUI);

    }
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getUserName(JNIEnv *env, jobject ,
                                                                    jlong ptr) {
    User *obj = (User *)ptr;
    std::string name = obj->getName();
    return env->NewStringUTF(name.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getStudentCourse(JNIEnv *env, jobject ,
                                                                    jlong ptr) {
    User *obj = (User *)ptr;
    std::string course = obj->getSCourse();
    return env->NewStringUTF(course.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getEmail(JNIEnv *env, jobject ,
                                                                         jlong ptr) {
    User *obj = (User *)ptr;
    std::string email = obj->getEmail();
    return env->NewStringUTF(email.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getPassword(JNIEnv *env, jobject ,
                                                                         jlong ptr) {
    User *obj = (User *)ptr;
    std::string password = obj->getPwrd();
    return env->NewStringUTF(password.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getTutorCourse(JNIEnv *env, jobject ,
                                                                         jlong ptr) {
    User *obj = (User *)ptr;
    std::string t_course = obj->getTCourse();
    return env->NewStringUTF(t_course.c_str());
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getTutor(JNIEnv *env, jobject ,
                                                                 jlong ptr) {
    User *obj = (User *)ptr;
    int tutor = obj->getTutor();
    return tutor;
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getBio(JNIEnv *env, jobject ,
                                                                 jlong ptr) {
    User *obj = (User *)ptr;
    std::string bio = obj->getBio();
    return env->NewStringUTF(bio.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getContact(JNIEnv *env, jobject ,
                                                               jlong ptr) {
    User *obj = (User *)ptr;
    std::string contact = obj->getContact();
    return env->NewStringUTF(contact.c_str());
}
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getRate(JNIEnv *env, jobject ,
                                                                 jlong ptr) {
    User *obj = (User *)ptr;
    double rate = obj->getRate();
    return rate;
}
}