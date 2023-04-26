package com.ziroh.compute;

import com.ziroh.common.Input;
import com.ziroh.common.pojo.LambdaFunction;
import com.ziroh.common.pojo.Node;
import com.ziroh.compute.handler.ExecutionHandler;

public class NewFlowTest {
    public static void main(String[] args) {
        Node node = new Node();
        node.setLambdaFunction(new LambdaFunction("C:\\ZirohLabs\\oanalytics\\ZunuCompute\\processor\\src\\main\\resources\\usecase1-1.0-SNAPSHOT.jar", "com.usecase.CalculatorExecutor"));

        ExecutionHandler executor  = new ExecutionHandler();
        Input input = new Input();
        input.addInput(1);
        input.addInput(2);
        System.out.println(executor.execute(node, input));
    }
}
