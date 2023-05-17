package com.music.musician;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class MusicianManager {

    private static final List<Musician> MUSICIANS = Collections.synchronizedList(new ArrayList<>());

    public void addMusician(Musician musician) {
        MUSICIANS.add(musician);
    }

    public List<Musician> listMusicians() {
        return MUSICIANS;
    }
}
