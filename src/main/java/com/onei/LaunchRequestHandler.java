package com.onei;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.request.Predicates;
import io.reactivex.Maybe;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Singleton
public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.requestType(LaunchRequest.class));
    }

    NextTrainClient nextTrainClient;
    @Override
    public Optional<Response> handle(HandlerInput input) {


        IntentRequest intent = (IntentRequest) input.getRequestEnvelope().getRequest();
        Map<String, Slot> slots = intent.getIntent().getSlots();
        String station = slots.get("station").getValue();
        String result = nextTrainClient.getResultsForStation(station);


        System.out.println(result);

        return input.getResponseBuilder()
                .withSpeech(result)
                .withSimpleCard("Results for in Ireland & England ", result)
                .build();
    }

}
