package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService
{
    public Track saveTrack(Track track);
    public Track getTrackbyId(int trackId);
    public List<Track> getAllTracks();
    public Optional deleteTrackById(int trackId);
    public Track updateTrackById(int trackId, Track trackToUpdate);
    public List<Track> findTrackByName(String trackName);
}
