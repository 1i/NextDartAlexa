package com.onei;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class EndToEnd {

    @Inject
    NextTrainClient nextTrainClient;

    @Test
    void test(){
      nextTrainClient.getForStation("howth");
    }
}
