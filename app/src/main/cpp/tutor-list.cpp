//
// Created by Owner on 2018-11-20.
//
#include <jni.h>
#include <string>
#include "User.cpp"
#include "User.h"

extern "C" {


JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorListActivity_getStudentCourse(JNIEnv *env, jobject,
                                                                       jlong ptr) {
    User *obj = (User *) ptr;
    std::string course = obj->getSCourse();
    return env->NewStringUTF(course.c_str());
}

}
