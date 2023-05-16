package com.music.band;

import com.music.Manufacturer;
import com.music.musician.Musician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Band {
    private Integer code;
    private String name;
    private Set<Musician> musicians = new HashSet<>();
    private Manufacturer manufacturer;
}
