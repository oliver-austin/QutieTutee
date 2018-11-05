//
// Created by Poe on 11/5/2018.
//

#include <string>
#include "StudentProfile.h"

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileEditActivity_saveProfile(JNIEnv *env, jobject ,
                                                                        jstring userName) {
    const char *path = env->GetStringUTFChars(userName, NULL);
    std::string userNameJava = std::string(path);
    return env->NewStringUTF(userNameJava.c_str());
}
}
