package com.ziroh.compute.handler;

import com.ziroh.compute.pojo.Input;
import com.ziroh.compute.pojo.Node;
import com.ziroh.compute.pojo.Output;

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
            }, ExecutionHandler.class.getClassLoader());

            final Class<?> loadedClass = Class.forName(lambdaFunction, true, classLoader);

            for (var method : loadedClass.getDeclaredMethods()) {
                output = (Output) method.invoke(loadedClass.getDeclaredConstructor().newInstance(), input);
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

}
