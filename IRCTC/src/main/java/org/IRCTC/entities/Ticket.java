package org.IRCTC.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.IRCTC.entities.Train;

import java.util.Date;

import static java.lang.String.format;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    private String ticketId;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateofTravel() {
        return dateofTravel;
    }

    public void setDateofTravel(String dateofTravel) {
        this.dateofTravel = dateofTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    private String userId;

    private String source;

    private String destination;

    private String dateofTravel;

    private Train train;

    public String getTicketInfo(){
        return String.format("Ticket Id : %s belongs to User %s from %s to %s on %s ",ticketId,userId,source,
                destination,dateofTravel);
    }
}
