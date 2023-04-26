package com.ziroh.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Input {
    List<Object> inputs = new ArrayList<>();

    public void addInput(Object object){
        inputs.add(object);
    }

}
