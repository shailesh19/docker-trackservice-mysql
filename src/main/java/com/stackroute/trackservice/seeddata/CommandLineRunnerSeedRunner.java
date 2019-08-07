package com.stackroute.trackservice.seeddata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerSeedRunner implements CommandLineRunner
{
    private TrackRepository trackRepository;

    @Autowired
    public CommandLineRunnerSeedRunner(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Track track1 = new Track(04,"Wanted You","Fav");
        trackRepository.save(track1);
        Track track2 = new Track(05,"My Year","Fav");
        trackRepository.save(track2);
        Track track3 = new Track(06,"Cold","Fav");
        trackRepository.save(track3);
    }
}
