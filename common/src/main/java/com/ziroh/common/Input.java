package com.ziroh.common;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Input {
    List<Object> inputs;

    public Input(){
        inputs = new ArrayList<>();
    }

    public void addInput(Object input){
        inputs.add(input);
    }
}
