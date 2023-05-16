package com.music.instrument;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Drum extends Instrument {
    private boolean hasHitHat;
}
