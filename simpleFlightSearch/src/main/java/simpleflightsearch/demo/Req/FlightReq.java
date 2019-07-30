package simpleflightsearch.demo.Req;

import java.util.Date;

public class FlightReq {
    private String flight_num;
    private String origin;
    private String destination;
    private String date;


    public String getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(String flight_num) {
        this.flight_num = flight_num;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
