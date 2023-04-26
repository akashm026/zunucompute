//package com.ziroh.compute;
//
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLClassLoader;
//
//public class App {
//
//    public static void main(String[] args) {
//        test();
//    }
//
//    public static void test(){
//
//        try{
//
//            final Class<?> functionClass = getClassFromFunctionJar("com.hello.HelloFunction");
//
//            final Object functionClassObject = functionClass.newInstance();
//
//            if(functionClassObject instanceof RequestHandler){
//
//                @SuppressWarnings("unchecked")
//                final RequestHandler<Object> handler = RequestHandler.class.cast(functionClassObject);
//
//                final Object inputObject = getRequestClass(functionClass).newInstance();
//
//                handler.handle(inputObject);
//
//
//            }
//
//        }catch(final Exception e){
//
//            System.err.println(e.getMessage());
//
//        }
//    }
//
//    public static Class<?> getRequestClass(final Class<?> cls) throws FunctionInvokerException{
//
//        try{
//            final Type[] types = cls.getGenericInterfaces();
//
//            for(Type type : types){
//
//                //check RequestHandler
//                if(type.getTypeName().contains(RequestHandler.class.getName())){
//
//                    final ParameterizedType parameterizedType = (ParameterizedType) type;
//
//                    // [0]=> Request Type
//                    final String inputClassName = parameterizedType.getActualTypeArguments()[0].getTypeName();
//                    return getClassFromFunctionJar(inputClassName);
//
//                }
//
//            }
//
//            throw new Exception("UNABLE_TO_FIND_REQUEST_TYPE");
//
//        }catch(final Exception e){
//            throw new FunctionInvokerException(e);
//        }
//
//    }
//
//    private static Class<?> getClassFromFunctionJar(final String className) throws ClassNotFoundException, MalformedURLException {
//        final ClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new URL("file:" + "/jar-location/hello.jar")}, App.class.getClassLoader());
//        return Class.forName(className, true, classLoader);
//    }
//
//}