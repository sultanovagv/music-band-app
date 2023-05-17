package com.music;

import com.music.band.Band;
import com.music.band.BandManager;
import com.music.instrument.Guitar;
import com.music.instrument.Piano;
import com.music.instrument.Synthesizer;
import com.music.musician.Musician;
import com.music.musician.MusicianManager;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuOptions {
    private static final BandManager BAND_MANAGER = new BandManager();
    private static final MusicianManager MUSICIAN_MANAGER = new MusicianManager();

    static {
        var guitar = Guitar.builder().code(1).name("guitar").numberOfStrings(6).stringSize(0.8).build();
        var musician1 = Musician.of(1, "Ilea Emend", guitar);
        MUSICIAN_MANAGER.addMusician(musician1);
        var piano = Piano.builder().code(2).name("piano").numberOfKeys(12).isAcoustic(true).build();
        var musician2 = Musician.of(2, "Mr Angel", piano);
        MUSICIAN_MANAGER.addMusician(musician2);
        var synthesizer = Synthesizer.builder().code(2).name("piano").numberOfKeys(12).hasLed(true).build();
        var musician3 = Musician.of(3, "Jut Leghorn", synthesizer);
        MUSICIAN_MANAGER.addMusician(musician3);
        BAND_MANAGER.addBand(Band.of(2, "I’d Seen", Set.of(musician3), Manufacturer.of(1, "Fibson")));
        BAND_MANAGER.addBand(Band.of(1, "Adrenal’Ex", Set.of(musician1), Manufacturer.of(1, "Al")));
    }

    public void listBands() {
        BAND_MANAGER.listBands().forEach(System.out::println);
    }

    public void playOneNight() {
        var musiciansWithoutBand = new HashSet<Musician>();
        var bands = BAND_MANAGER.listBands();
        bands.forEach(band -> {
            var musician = BAND_MANAGER.removeRandomMusicianFromBand(band);
            if (musician != null) {
                musiciansWithoutBand.add(musician);
            }
        });

        var bandMusicians = bands.stream()
                .flatMap(band -> band.getMusicians().stream())
                .collect(Collectors.toList());

        MUSICIAN_MANAGER.listMusicians().stream()
                .filter(musician -> !bandMusicians.contains(musician))
                .forEach(musiciansWithoutBand::add);

        musiciansWithoutBand.forEach(BAND_MANAGER::addMusicianToRandomBand);
    }

    public void exit() {
        System.out.println("Operations are executed !");
        System.exit(0);
    }

}