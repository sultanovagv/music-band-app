package com.music.band;

import com.music.musician.Musician;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
@NoArgsConstructor
public class ManageBands {

    private static final List<Band> BANDS = Collections.synchronizedList(new ArrayList<>());
    private static final Map<Integer, List<List<String>>> LOGS_HISTORY = Collections.synchronizedMap(new HashMap<>());
    private static final Random RANDOM = new Random();

    public void addBand(Band band) {
        BANDS.add(band);
    }

    public List<Band> listBands() {
        return BANDS;
    }

    public void addMusicianToBrand(Musician musician) {
        int index = RANDOM.nextInt(BANDS.size());
        var band = BANDS.get(index);
        var isMusicianInBand = band.getMusicians().stream()
                .anyMatch(data -> data.getCode() == musician.getCode());
        if (!isMusicianInBand) {
            var musicians = new HashSet<>(band.getMusicians());
            musicians.add(musician);
            var log = musician.getName() + "  joined to " + band.getName();
            printAndSaveLog(band.getCode(), log);
        }
    }

    public void removeMusicianFromBrand(Musician musician) {
        int index = RANDOM.nextInt(BANDS.size());
        var band = BANDS.get(index);
        var isMusicianInBand = band.getMusicians().stream()
                .anyMatch(data -> data.getCode() == musician.getCode());
        if (!isMusicianInBand) {
            var musicians = new HashSet<>(band.getMusicians());
            musicians.remove(musician);
            var log = musician.getName() + "  left  " + band.getName();
            printAndSaveLog(band.getCode(), log);
        }
    }

    private static void printAndSaveLog(Integer bandCode, String log) {
        System.out.println(log);
        var value = LOGS_HISTORY.getOrDefault(bandCode, new ArrayList<>());
        value.add(List.of(log));
        LOGS_HISTORY.put(bandCode, value);
    }
}
