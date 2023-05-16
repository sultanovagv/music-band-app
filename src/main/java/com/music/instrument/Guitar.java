package com.music.instrument;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Guitar extends Instrument {
    private int numberOfStrings;
    private double stringSize;
}
