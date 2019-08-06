package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class TrackController
{
    private TrackService trackService;

    public TrackController()
    {
    }

    @Autowired
    public TrackController( TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException
    {
        ResponseEntity responseEntity;

            Track track1 = trackService.saveTrack(track);
            responseEntity = new ResponseEntity(track1,HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;

            Track track = trackService.getTrackById(trackId);
            responseEntity = new ResponseEntity(track, HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("alltrack")
    public ResponseEntity<?> getAllTracks() throws Exception
    {
        ResponseEntity responseEntity;

            List<Track> listOfTracks=trackService.getAllTracks();
            responseEntity = new ResponseEntity(listOfTracks, HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping("deletetrack/{trackID}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int trackID) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;

            Optional deletedTrack = trackService.deleteTrackById(trackID);
            trackService.deleteTrackById(trackID);
            return new ResponseEntity<>(deletedTrack,HttpStatus.OK);
    }

    @PutMapping("track/{trackId}")
    public ResponseEntity<?> updateTrackById(@PathVariable int trackId, @RequestBody Track updateTrack)
    {
        Track updatedTrack = trackService.updateTrackById(trackId,updateTrack);
        return new ResponseEntity<>(updatedTrack,HttpStatus.OK);
    }

    @GetMapping("tracks/{trackName}")
    public ResponseEntity<?> findTrackByName(@PathVariable String trackName)
    {
        List<Track> foundTrack = trackService.findTrackByName(trackName);
        return new ResponseEntity<>(foundTrack,HttpStatus.FOUND);
    }
}
