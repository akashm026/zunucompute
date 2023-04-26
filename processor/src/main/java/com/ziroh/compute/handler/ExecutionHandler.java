package com.ziroh.compute.handler;

import com.ziroh.common.Input;
import com.ziroh.common.Node;
import com.ziroh.common.Output;
import com.ziroh.handler.ExecuteHandler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class ExecutionHandler {
    public Output execute(Node node, Input input) {
        var lambdaFunction = node.getLambdaFunction().getEntryFunction();
        var lambdaLocation = node.getLambdaFunction().getJarLocation();
        Output output = new Output();

        try {
            final ClassLoader classLoader = URLClassLoader.newInstance(new URL[]{
                    new URL("file:" + lambdaLocation)
            }, ExecuteHandler.class.getClassLoader());
            var calculatorClass = Class.forName("com.usecase.Calculator", true, classLoader); // We need to pass this calculator
            final Class<?> loadedClass = Class.forName(lambdaFunction, true, classLoader);
            getDependentClass(loadedClass);
            for (var method : loadedClass.getDeclaredMethods()) {
                output = (Output) method.invoke(loadedClass.getDeclaredConstructor(calculatorClass).newInstance(calculatorClass.newInstance()), input);
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

    /**
     * @param inputClass the class whose object we want to create
     * @return class that is reqd. to create object of inputClass
     */
    private Class<?> getDependentClass(Class<?> inputClass) {
        var constructors = inputClass.getDeclaredConstructors();
        System.out.println("Total number of constructors available:" + constructors.length);
        Arrays.stream(constructors)
                .forEach(constructor -> {
                    Arrays.stream(constructor.getParameterTypes()).forEach(aClass -> {
                        System.out.println(aClass.getName());
                    });
                });
        return inputClass;
    }

    /* TODO: What if the executor has multiple constructors and how do we know which one the use to create object for the executor ? */
}
