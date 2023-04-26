package com.ziroh.common;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ziroh.common.LambdaFunction;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Node {
    private Integer index;
    private String jobId;
    private int graphId;
    private int workerId;

    private List<Integer> inputNodes = new ArrayList<>();

    private List<Integer> outputNodes = new ArrayList<>();
    @JsonIgnore
    private LambdaFunction lambdaFunction;

    private Boolean attachedData;

    private List<String> attachedDataPathList;

    private Boolean isCustom;

    private Boolean isExecuted;

    private String jarFile;

    private Boolean isMultiprocessing;

    @BsonCreator()
    public Node(@BsonProperty("index") int index) {
        this.index = index;
    }

    public void addInputNode(Integer node) {
        inputNodes.add(node);
    }

    public void addOutputNode(Integer node) {
        outputNodes.add(node);
    }

    public List<Integer> getInputNodes() {
        if (Objects.isNull(this.inputNodes)) {
            return new ArrayList<>();
        }
        return this.inputNodes;
    }

    public List<Integer> getOutputNodes() {
        if (Objects.isNull(this.outputNodes)) {
            return new ArrayList<>();
        }
        return this.outputNodes;
    }
}
