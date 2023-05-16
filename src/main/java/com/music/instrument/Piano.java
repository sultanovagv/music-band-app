package com.music.instrument;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Piano extends Instrument {
    private int numberOfKeys;
    private boolean isAcoustic;
}
