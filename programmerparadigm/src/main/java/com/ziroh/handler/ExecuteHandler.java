package com.ziroh.handler;


import com.ziroh.common.pojo.Input;
import com.ziroh.common.pojo.Output;

public interface ExecuteHandler {
    Output execute(Input inputs);
}
