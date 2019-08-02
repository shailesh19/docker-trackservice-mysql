package com.stackroute.trackservice.repository;
import com.stackroute.trackservice.domain.Track;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer>
{

}
