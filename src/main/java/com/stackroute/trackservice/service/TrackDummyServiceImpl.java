package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackDummyServiceImpl implements TrackService
{

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException
    {
        return null;
    }

    @Override
    public Track getTrackById(int trackId) throws TrackNotFoundException
    {
        return null;
    }

    @Override
    public List<Track> getAllTracks() throws Exception
    {
        return null;
    }

    @Override
    public Optional deleteTrackById(int trackId) throws TrackNotFoundException
    {
        return Optional.empty();
    }

    @Override
    public Track updateTrackById(int trackId, Track trackToUpdate)
    {
        return null;
    }

    @Override
    public List<Track> findTrackByName(String trackName)
    {
        return null;
    }
}
