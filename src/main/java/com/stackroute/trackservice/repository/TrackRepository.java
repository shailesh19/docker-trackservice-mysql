package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Tells Spring that this is Repository/Database class

public interface TrackRepository extends MongoRepository<Track, Integer>
{
    List<Track> findByTrackName(String trackName);
}
