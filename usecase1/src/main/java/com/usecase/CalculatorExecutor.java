package com.usecase;


import com.ziroh.common.Input;
import com.ziroh.common.Output;
import com.ziroh.handler.ExecuteHandler;

import java.util.List;

/**
 * @author Samarjeet
 */
public class CalculatorExecutor implements ExecuteHandler {
    private final Calculator calculator;

    public CalculatorExecutor() {
        calculator = new Calculator();
    }

//    public CalculatorExecutor(Calculator calculator) {
//        this.calculator = calculator;
//    }

    @Override
    public Output execute(Input inputs) {
        var data = inputs.getInputs();
        if(data.isEmpty()){
            throw new RuntimeException("Invalid inputs");
        }
        int first = (Integer) data.get(0);
        int second = (Integer) data.get(1);
        int result = calculator.add(first, second);
        Output output = new Output();
        output.setOutputs(List.of(result));
        return output;
    }
}
