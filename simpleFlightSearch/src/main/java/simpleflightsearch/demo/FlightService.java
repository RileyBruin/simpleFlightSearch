package simpleflightsearch.demo;

import simpleflightsearch.demo.Req.FlightReq;
import simpleflightsearch.demo.Res.FlightRes;

import java.util.List;

public interface FlightService {

    public List<FlightRes> getFlights(FlightReq flightReq);

}
