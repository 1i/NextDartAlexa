package com.onei;

import io.micronaut.core.annotation.Introspected;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Introspected
@XmlRootElement(name = "objStationData")
public class ResultModel {

    @XmlElement(name = "Traincode")
    private String trainCode;

    @XmlElement(name = "Stationfullname")
    private String stationName;

    @XmlElement(name = "Stationcode")
    private String stationCode;

    @XmlElement(name = "Origin")
    private String origin;

    @XmlElement(name = "Destination")
    private String destination;

    @XmlElement(name = "OriginTime")
    private String originTime;

    @XmlElement(name = "Destinationtime")
    private String destinationTime;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "Lastlocation")
    private String lastLocation;

    @XmlElement(name = "DueIn")
    private String dueIn;

    @XmlElement(name = "Late")
    private String late;

    @XmlElement(name = "Exparrival")
    private String expectedArrival;

    @XmlElement(name = "Expdepart")
    private String expectedDeparture;

    @XmlElement(name = "Scharrival")
    private String scheduledArrival;

    @XmlElement(name = "Schdepart")
    private String schDepart;

    @XmlElement(name = "Direction")
    private String direction;

    @XmlElement(name = "Traintype")
    private String trainType;

    @XmlElement(name = "Locationtype")
    //O = Origin, D = Destination, S= Stop
    private String locationType;

    @Override
    public String toString() {
        return "ResultModel{" +
                "trainCode='" + trainCode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", stationCode='" + stationCode + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", originTime='" + originTime + '\'' +
                ", destinationTime='" + destinationTime + '\'' +
                ", status='" + status + '\'' +
                ", lastLocation='" + lastLocation + '\'' +
                ", dueIn='" + dueIn + '\'' +
                ", late='" + late + '\'' +
                ", expectedArrival='" + expectedArrival + '\'' +
                ", expectedDeparture='" + expectedDeparture + '\'' +
                ", scheduledArrival='" + scheduledArrival + '\'' +
                ", schDepart='" + schDepart + '\'' +
                ", direction='" + direction + '\'' +
                ", trainType='" + trainType + '\'' +
                ", locationType='" + locationType + '\'' +
                '}';
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOriginTime() {
        return originTime;
    }

    public void setOriginTime(String originTime) {
        this.originTime = originTime;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }

    public String getDueIn() {
        return dueIn;
    }

    public void setDueIn(String dueIn) {
        this.dueIn = dueIn;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(String expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public String getExpectedDeparture() {
        return expectedDeparture;
    }

    public void setExpectedDeparture(String expectedDeparture) {
        this.expectedDeparture = expectedDeparture;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getSchDepart() {
        return schDepart;
    }

    public void setSchDepart(String schDepart) {
        this.schDepart = schDepart;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTrainType() {
        return trainType;
    }

    public ResultModel() {
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
