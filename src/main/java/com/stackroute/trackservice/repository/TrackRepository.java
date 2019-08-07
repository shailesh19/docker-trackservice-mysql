package com.stackroute.trackservice.repository;
import com.stackroute.trackservice.domain.Track;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer>
{
    @Query(value = "select p from Track p where p.trackName like ?1 ")
    List<Track> findByTrackName(String trackName);
}
