package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
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
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException
    {
        ResponseEntity responseEntity;
        try
        {
            Track track1 = trackService.saveTrack(track);
            responseEntity = new ResponseEntity(track1,HttpStatus.CREATED);
        }
        catch (TrackAlreadyExistsException tae)
        {
            responseEntity = new ResponseEntity(tae.getMessage(),HttpStatus.CONFLICT);
            tae.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        try
        {
            Track track = trackService.getTrackbyId(trackId);
            responseEntity = new ResponseEntity(track, HttpStatus.OK);
        }
        catch (TrackNotFoundException tnf)
        {
            responseEntity = new ResponseEntity(tnf.getMessage(),HttpStatus.CONFLICT);
            tnf.printStackTrace();
        }

        return responseEntity;
//        Track retrievedTrack = trackService.getTrackbyId(trackId);
//        return new ResponseEntity<>(retrievedTrack,HttpStatus.OK);
    }

    @GetMapping("alltrack")
    public ResponseEntity<?> getAllTracks() throws Exception
    {
        ResponseEntity responseEntity;
        try
        {
            List<Track> listOfTracks=trackService.getAllTracks();
            responseEntity = new ResponseEntity(listOfTracks, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        return responseEntity;
    }

    @DeleteMapping("deletetrack/{trackID}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int trackID) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.deleteTrackById(trackID);
            responseEntity = new ResponseEntity("Track Deleted",HttpStatus.OK);
//            return new ResponseEntity<>(deletedTrack,HttpStatus.OK);
        }
        catch (TrackNotFoundException tnf)
        {
            responseEntity = new ResponseEntity(tnf.getMessage(),HttpStatus.CONFLICT);
            tnf.printStackTrace();
        }
        return responseEntity;
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
