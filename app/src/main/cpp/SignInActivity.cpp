//
// Created by Shira Eisen on 2018-11-10.
//

#include <jni.h>
#include <string>

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_SignInActivity(JNIEnv *env, jobject, jstring emailAddress,
                                                jstring password) {
    const char *pathToEmail = env->GetStringUTFChars(emailAddress, NULL);
    const char *pathToPwrd = env->GetStringUTFChars(password, NULL);
    std::string emailAddressJava = std::string(pathToEmail);
    std::string passwordJava = std::string(pathToPwrd);
    return env->NewStringUTF(emailAddressJava.c_str());
}
}

