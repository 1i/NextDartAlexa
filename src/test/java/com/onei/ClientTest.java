package com.onei;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.RequestEnvelope;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.reactivex.Maybe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@MicronautTest

public class ClientTest {

    @Inject
    @Client
    RxStreamingHttpClient client;
    NextTrainClient nextTrainClient ;

//    @BeforeAll
//    static void setUp(){
//        nextTrainClient = new NextTrainClient(client);
//    }

    @Test
    void test(){
        nextTrainClient = new NextTrainClient(client);
        Maybe<List<ResultModel>> listMaybe = nextTrainClient.fetchPackages();
        List<ResultModel> resultModels = listMaybe.blockingGet();
        System.out.println("results " +resultModels.size());
        ResultModel resultModel = resultModels.get(0);
        System.out.println("result " + resultModel.toString());
    }

    @Test
    void getStation(){
        nextTrainClient = new NextTrainClient(client);
        Maybe<List<ResultModel>> howth = nextTrainClient.getForStation("howth");
        List<ResultModel> resultModels = howth.blockingGet();
        System.out.println("results " +resultModels.size());
        ResultModel resultModel = resultModels.get(0);
        System.out.println("result " + resultModel.toString());
    }

    @Test
    void handler(){
        LaunchRequestHandler launchRequestHandler = new LaunchRequestHandler();
        launchRequestHandler.nextTrainClient.getForStation("howth");
    }

}
