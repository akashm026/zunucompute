//package com.ziroh.compute;
//
//import com.ziroh.annotation.includeslambdafunction;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Arrays;
//
//public class ProcessingAnnotation {
//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        AnnotationTest annotationTest = new AnnotationTest();
////        var testValue = annotationTest.testqwerty();
////        Annotation annotation = annotationTest.getClass().getAnnotation(includeslambdafunction.class);
////        includeslambdafunction includeslambdafunction = (includeslambdafunction) annotation;
//        for(Method method: annotationTest.getClass().getDeclaredMethods()){
//            System.out.println(method.getAnnotation(includeslambdafunction.class));
//            System.out.println(Arrays.toString(Arrays.stream(method.getParameterTypes()).toArray()));
//            method.invoke(annotationTest.getClass().getDeclaredConstructor().newInstance(), "Hello");
//        }
////        System.out.println(AnnotationTest.class.isAnnotationPresent(includeslambdafunction.class));
//    }
//}
