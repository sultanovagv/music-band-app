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

@Data
@NoArgsConstructor
public class ManageBands {

    private static final List<Band> BANDS = Collections.synchronizedList(new ArrayList<>());
    private static final Map<Integer, List<List<String>>> LOGS_HISTORY = Collections.synchronizedMap(new HashMap<>());

    public void addBand(Band band) {
        BANDS.add(band);
    }

    public List<Band> listBands() {
        return BANDS;
    }

    public void addMusicianToBrand(Musician musician, Integer bandCode) {
        var band = BANDS.stream().filter(data -> data.getCode().equals(bandCode)).findFirst();
        band.ifPresent(data -> {
            var musicians = new HashSet<>(data.getMusicians());
            musicians.add(musician);
            var log = musician.getName() + "  joined to " + data.getName();
            printAndSaveLog(bandCode, log);
        });
    }

    public void removeMusicianFromBrand(Musician musician, Integer bandCode) {
        var band = BANDS.stream().filter(data -> data.getCode().equals(bandCode)).findFirst();
        band.ifPresent(data -> {
            var musicians = new HashSet<>(data.getMusicians());
            musicians.remove(musician);
            var log = musician.getName() + "  left  " + data.getName();
            printAndSaveLog(bandCode, log);
        });
    }

    private static void printAndSaveLog(Integer bandCode, String log) {
        System.out.println(log);
        var value = LOGS_HISTORY.getOrDefault(bandCode, new ArrayList<>());
        value.add(List.of(log));
        LOGS_HISTORY.put(bandCode, value);
    }
}
