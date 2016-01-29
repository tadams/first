package com.tom.tolkien;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Character {
    String name;
    Race race;
}
