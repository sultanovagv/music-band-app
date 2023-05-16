package com.music.instrument;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Banjo extends Instrument {
    private int numberOfStrings;
    private double stringSize;
}
