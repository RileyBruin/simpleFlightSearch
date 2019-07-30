package simpleflightsearch.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simpleflightsearch.demo.Req.FlightReq;
import simpleflightsearch.demo.Res.FlightRes;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class Controller {

    @Autowired
    FlightService flightService;

    @PostMapping("/flight")
    public List<FlightRes> flight(@RequestBody FlightReq flightReq){
        return flightService.getFlights(flightReq);
    }

}
