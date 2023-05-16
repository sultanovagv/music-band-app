package com.music.musician;

import com.music.instrument.Instrument;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Musician {
    private long code;
    private String name;
    private Instrument instrument;
}
