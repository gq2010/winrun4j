/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Peter Smith
 *******************************************************************************/

#ifndef JNI_UTILS_H
#define JNI_UTILS_H

#include "../common/Runtime.h"
#include <stdio.h>
#include <string.h>
#include <jni.h>

class JNI 
{
public:
	static void ClearJavaException(JNIEnv* env);
	static bool RunMainClass( JNIEnv* env, TCHAR* mainClass, TCHAR* progArgs[] );
	static const char* CallJavaStringMethod(JNIEnv* env, jclass clazz, jobject obj, char* name);
	static jstring NewJavaString(JNIEnv *env, TCHAR * str);
	static jobjectArray CreateRunArgs( JNIEnv *env, TCHAR * args[] );
};

#endif // JNI_UTILS_H