//
// Created by Tyler Lee on 2018-11-13.
//

#include <jni.h>
#include <string>

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_saveProfile(JNIEnv *env, jobject ,
                                                                    jstring userName, jstring userClassTeach, jstring userContact,
                                                                  jstring userRate, jstring userBio) {
    const char *path = env->GetStringUTFChars(userName, NULL);
    std::string userNameJava = std::string(path);
    return env->NewStringUTF(userNameJava.c_str());
}
}