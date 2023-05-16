package com.music.instrument;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Synthesizer extends Instrument {
    private int numberOfKeys;
    private boolean hasLed;
}
