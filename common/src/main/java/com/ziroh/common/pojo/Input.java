package com.ziroh.common.pojo;

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
