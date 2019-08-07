package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService
{
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public Track getTrackById(int trackId) throws TrackNotFoundException;
    public List<Track> getAllTracks() throws Exception;
    public Optional deleteTrackById(int trackId) throws TrackNotFoundException;
    public Track updateTrackById(int trackId, Track trackToUpdate);
    public List<Track> findTrackByName(String trackName);
}
