package com.onei;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Properties;

@Singleton
public class NextTrainClient {
    private final RxHttpClient httpClient;
    private final URI uri;
    private final  String rootPath = NextTrainClient.class.getClassLoader().getResource("").getPath();
    private final  String appConfigPath = rootPath + "stations.properties";
    private final  Properties appProps = new Properties();
    private static final Logger log = LoggerFactory.getLogger(NextTrainClient.class);


    public NextTrainClient(@Client RxHttpClient httpClient) {
        this.httpClient = httpClient;
        this.uri = UriBuilder.of("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML")
                .queryParam("StationCode", "mhide")
                .build();
    }

    Maybe<List<ResultModel>> fetchPackages() {
        HttpRequest<?> req = HttpRequest.GET(uri);
        Flowable flowable = httpClient.retrieve(req, Argument.listOf(ResultModel.class));
        return (Maybe<List<ResultModel>>) flowable.firstElement();
    }

    public String getResultsForStation(String station){
        StringBuilder sb = new StringBuilder();
        Maybe<List<ResultModel>> forStation = getForStation(station);
        List<ResultModel> resultModels = forStation.blockingGet();

        sb.append("Next train for " ).append(station);
        for (ResultModel result : resultModels){
        sb.append(result.getDueIn());
        sb.append(" minutes.");
        }
        return sb.toString();
    }

    public Maybe<List<ResultModel>> getForStation(String station) {

        String stationCode = getStationCode(station);

        URI uri = UriBuilder.of("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML")
                .queryParam("StationCode", stationCode)
                .build();
        HttpRequest<?> request = HttpRequest.GET(uri);
        Flowable flowable = httpClient.retrieve(request, Argument.listOf(ResultModel.class));
        return (Maybe<List<ResultModel>>) flowable.firstElement();
    }

    private String getStationCode(String location) {
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            log.error("Config file load error");
            e.printStackTrace();
        }
        if (location.contains(" ")) {
            location = location.replace(" ", "");
        }
        String station = appProps.getProperty(location.toLowerCase());

        if (station == null || station.isEmpty()) {
            log.error("Could not find location for {}", location);
            station = "SKILL";
        }
        return station;
    }
}
