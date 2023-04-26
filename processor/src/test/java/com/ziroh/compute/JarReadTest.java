package com.ziroh.compute;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class JarReadTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final ClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new URL("file:" + "C:\\ZirohLabs\\oanalytics\\ZunuCompute\\processor\\src\\main\\resources\\interfacejar-1.0-SNAPSHOT.jar")}, JarReadTest.class.getClassLoader());
        JarFile jarFile = new JarFile("C:\\ZirohLabs\\oanalytics\\ZunuCompute\\processor\\src\\main\\resources\\interfacejar-1.0-SNAPSHOT.jar");
        JarInputStream jarInputStream = new JarInputStream(new FileInputStream("C:\\ZirohLabs\\oanalytics\\ZunuCompute\\processor\\src\\main\\resources\\interfacejar-1.0-SNAPSHOT.jar"));
        JarEntry jarEntry = jarInputStream.getNextJarEntry();
        String className = jarEntry.getName().replaceAll("/", "\\.");
//        className = className.substring(0, className.length() - 6);
        System.out.println(className);
        final Class<?> loadedClass = Class.forName("org.example.ExecuteHandlerImplementation", true, classLoader);
        for(var method: loadedClass.getDeclaredMethods()){
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getParameters()));
            List<String> stringList = new ArrayList<>();
            stringList.add("hello");
            System.out.println(method);
            var string = "hello";
            String[] strings = new String[]{"Hello"};

            System.out.println(method.invoke(loadedClass.getDeclaredConstructor().newInstance(), (Object) strings));
        }

//        Class.forName()
//        final Class<?> functionClass = classLoader.getParent().getClass().getName();
    }

}