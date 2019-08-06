package com.stackroute.trackservice.repository;
import com.stackroute.trackservice.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer>
{
//    @Query(value = "select p from Track p where p.trackName like ?1 ")
    List<Track> findByTrackName(String trackName);
}
