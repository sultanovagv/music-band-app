package com.music.instrument;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Instrument {
    public String name;
    public long code;
}
