package com.music;

import com.music.band.Band;
import com.music.band.ManageBands;
import com.music.instrument.Guitar;
import com.music.instrument.Piano;
import com.music.musician.ManageMusicians;
import com.music.musician.Musician;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MenuOptions {
    private static final ManageBands MANAGE_BANDS = new ManageBands();
    private static final ManageMusicians MANAGE_MUSICIANS = new ManageMusicians();

    static {
        var guitar = Guitar.builder().code(1).name("guitar").numberOfStrings(6).stringSize(0.8).build();
        var musician1 = Musician.of(1, "Ilea Emend", guitar);
        MANAGE_MUSICIANS.addMusician(musician1);
        var piano = Piano.builder().code(2).name("piano").numberOfKeys(12).isAcoustic(true).build();
        var musician2 = Musician.of(2, "Mr Angel", piano);
        MANAGE_MUSICIANS.addMusician(musician2);
        MANAGE_BANDS.addBand(Band.of(2, "I’d Seen", new HashSet<>(), Manufacturer.of(1, "Fibson")));
        MANAGE_BANDS.addBand(Band.of(1, "Adrenal’Ex", Set.of(musician1), Manufacturer.of(1, "Al")));
    }

    public void listBands() {
        MANAGE_BANDS.listBands().forEach(System.out::println);
    }

    public void playOneNight() {
        var musicians = MANAGE_MUSICIANS.listMusicians();
        var random = new Random();
        int index = random.nextInt(musicians.size());
        var musician = musicians.get(index);
        MANAGE_BANDS.removeMusicianFromBrand(musician);
        index = random.nextInt(musicians.size());
        MANAGE_BANDS.addMusicianToBrand(musicians.get(index));
    }

    public void exit() {
        System.out.println("Operations are executed !");
        System.exit(0);
    }

}