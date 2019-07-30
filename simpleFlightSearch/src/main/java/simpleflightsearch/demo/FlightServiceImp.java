package simpleflightsearch.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleflightsearch.demo.Req.FlightReq;
import simpleflightsearch.demo.Res.FlightRes;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImp implements FlightService{

    @Autowired
    Repo repo;

    @Override
    public List<FlightRes> getFlights(FlightReq flightReq) {
        return repo.findByFlightNumberContainingAndOriginContainingAndDestinationContainingAndDepartureContaining(
            flightReq.getFlight_num(),
            flightReq.getOrigin(),
            flightReq.getDestination(),
            flightReq.getDate())
            .stream().map( e->{

            FlightRes flightRes = new FlightRes();
            flightRes.setFlightNumber(e.getFlightNumber());
            flightRes.setCarrier(e.getCarrier());
            flightRes.setOrigin(e.getOrigin());
            flightRes.setDeparture(e.getDeparture());
            flightRes.setDestination(e.getDestination());
            flightRes.setArrival(e.getArrival());
            flightRes.setAircraft(e.getAircraft());
            flightRes.setDistance(e.getDistance());
            flightRes.setTravelTime(e.getTravelTime());
            flightRes.setStatus(e.getStatus());
            return flightRes;
        }).collect(Collectors.toList());

    }
}
