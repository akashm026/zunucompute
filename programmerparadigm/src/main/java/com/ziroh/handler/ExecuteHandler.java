package com.ziroh.handler;

import com.ziroh.compute.pojo.Input;
import com.ziroh.compute.pojo.Output;

public interface ExecuteHandler {
    Output execute(Input inputs);
}
