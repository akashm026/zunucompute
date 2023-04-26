package com.ziroh.compute.handler;

import com.ziroh.common.Input;
import com.ziroh.common.Node;
import com.ziroh.common.Output;
import com.ziroh.handler.ExecuteHandler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

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
            for (var method : loadedClass.getDeclaredMethods()) {
                output = (Output) method.invoke(loadedClass.getDeclaredConstructor(calculatorClass).newInstance(calculatorClass.newInstance()), input);
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

}
