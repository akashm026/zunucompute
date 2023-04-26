package com.ziroh.compute;

import com.ziroh.common.Input;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class JarReadTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final ClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new URL("file:" + "C:\\ZirohLabs\\oanalytics\\ZunuCompute\\processor\\src\\main\\resources\\usecase1-1.0-SNAPSHOT.jar")}, JarReadTest.class.getClassLoader());
        JarFile jarFile = new JarFile("C:\\ZirohLabs\\oanalytics\\ZunuCompute\\processor\\src\\main\\resources\\usecase1-1.0-SNAPSHOT.jar");
        JarInputStream jarInputStream = new JarInputStream(new FileInputStream("C:\\ZirohLabs\\oanalytics\\ZunuCompute\\processor\\src\\main\\resources\\usecase1-1.0-SNAPSHOT.jar"));
        JarEntry jarEntry = jarInputStream.getNextJarEntry();
        String className = jarEntry.getName().replaceAll("/", "\\.");
//        className = className.substring(0, className.length() - 6);
        System.out.println(className);
        final Class<?> loadedClass = Class.forName("com.usecase.CalculatorExecutor", true, classLoader);
        for (var method : loadedClass.getDeclaredMethods()) {
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getParameters()));
//            System.out.println(loadedClass.getDeclaredConstructor());
            Input input = new Input();
            input.addInput(1);
            input.addInput(2);
//            List<String> stringList = new ArrayList<>();
//            stringList.add("hello");
//            System.out.println(method);
//            var string = "hello";
//            String[] strings = new String[]{"Hello"};

            System.out.println(method.invoke(loadedClass.getDeclaredConstructor().newInstance(), input));
//            method.invoke(loadedClass.getDe, input);
        }

//        Class.forName()
//        final Class<?> functionClass = classLoader.getParent().getClass().getName();
    }

}