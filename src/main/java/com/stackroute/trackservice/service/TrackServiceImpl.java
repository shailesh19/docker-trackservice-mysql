package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService
{
    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track)             // Save Track
    {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackbyId(int trackId)          // Get Track by Id
    {
        Track retrievedTrack = trackRepository.findById(trackId).get();
        return retrievedTrack;

    }

    @Override
    public List<Track> getAllTracks()               // Get all Tracks
    {
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> deleteTrackById(int trackId)         // Delete Track by Id
    {
         Optional optional = trackRepository.findById(trackId);
         if(optional.isPresent())
             trackRepository.deleteById(trackId);
         return optional;
    }

    @Override
    public Track updateTrackById(int trackId, Track trackToUpdate)         // Update Track by Id
    {
        trackRepository.findById(trackId).get().setTrackName(trackToUpdate.getTrackName());
        return trackRepository.save(trackRepository.findById(trackId).get());
    }

    @Override
    public List<Track> findTrackByName(String trackName)
    {
        List<Track> foundTrack = trackRepository.findByTrackName(trackName);
        return (List<Track>) foundTrack;
    }
}
