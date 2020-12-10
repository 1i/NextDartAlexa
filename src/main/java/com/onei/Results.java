package com.onei;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ArrayOfObjStationData")
public class Results {

    public Results() {
    }

    @XmlElementWrapper(name = "ArrayOfObjStationData")
    @XmlElement(name ="objStationData")
    List<ResultModel> resultModels;

    @Override
    public String toString() {
        return "Results{" +
                "resultModels=" + resultModels +
                '}';
    }
}
