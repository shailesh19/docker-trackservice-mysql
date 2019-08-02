package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException            // Save Track
    {
        if (trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistsException("Track already exists in DB!");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackbyId(int trackId) throws TrackNotFoundException          // Get Track by Id
    {
        if (trackRepository.existsById(trackId))
        {
            Track retrievedTrack = trackRepository.findById(trackId).get();
            return retrievedTrack;

        } else
            {
            throw new TrackNotFoundException("Track not found!");
        }
    }

    @Override
    public List<Track> getAllTracks() throws Exception               // Get all Tracks
    {
        if (trackRepository.findAll().isEmpty())
            throw new Exception();
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> deleteTrackById(int trackId) throws TrackNotFoundException       // Delete Track by Id
    {
        Optional optional;
        if (trackRepository.existsById(trackId))
        {
            optional = trackRepository.findById(trackId);
            if (optional.isPresent())
                trackRepository.deleteById(trackId);
            return optional;
        }
        else
            throw new TrackNotFoundException("Track not found!");
    }

    @Override
    public Track updateTrackById(int trackId, Track trackToUpdate)         // Update Track by Id
    {
        trackRepository.findById(trackId).get().setTrackName(trackToUpdate.getTrackName());
        return trackRepository.save(trackRepository.findById(trackId).get());
    }

    @Override
    public List<Track> findTrackByName(String trackName) {
        List<Track> foundTrack = trackRepository.findByTrackName(trackName);
        return (List<Track>) foundTrack;
    }
}
