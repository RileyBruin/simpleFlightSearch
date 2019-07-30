package simpleflightsearch.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Repo extends MongoRepository<Entity,Integer> {

    public List<Entity> findByFlightNumberContainingAndOriginContainingAndDestinationContainingAndDepartureContaining(
            String s1, String s2, String s3, String s4);


}
