package com.music.band;

import com.music.musician.Musician;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class BandManager {

    private static final List<Band> BANDS = Collections.synchronizedList(new ArrayList<>());
    private static final Random RANDOM = new Random();

    public void addBand(Band band) {
        BANDS.add(band);
    }

    public List<Band> listBands() {
        return BANDS;
    }

    public void addMusicianToRandomBand(Musician musician) {
        var isMusicianBoundToAnyBand = BANDS.stream()
                .flatMap(band -> band.getMusicians().stream())
                .anyMatch(data -> data.getCode() == musician.getCode());
        if (!isMusicianBoundToAnyBand) {
            var random = new Random();
            int index = random.nextInt(BANDS.size());
            var band = BANDS.get(index);
            var musicians = new HashSet<>(band.getMusicians());
            musicians.add(musician);
            band.setMusicians(musicians);
            var log = musician.getName() + "  joined to " + band.getName();
            System.out.println(log);
        }
    }

    public Musician removeRandomMusicianFromBand(Band band) {
        Musician musician = null;
        var musicians = band.getMusicians();
        if (musicians.size() > 0) {
            var random = new Random();
            var bandMusicians = musicians.toArray(new Musician[0]);
            int index = random.nextInt(bandMusicians.length);
            musician = bandMusicians[index];
            musicians = new HashSet<>(musicians);
            musicians.remove(musician);
            band.setMusicians(musicians);
            var log = musician.getName() + "  left  " + band.getName();
            System.out.println(log);
        }
        return musician;
    }

}
