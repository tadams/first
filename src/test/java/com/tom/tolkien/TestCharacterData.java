package com.tom.tolkien;

import java.util.Arrays;
import java.util.List;

public class TestCharacterData {

    public static Character BILBO  = new Character("Bilbo", Race.HOBBIT);
    public static Character FRODO  = new Character("Fodo", Race.HOBBIT);
    public static Character SAM    = new Character("Sam", Race.HOBBIT);
    public static Character MERRY  = new Character("Merry", Race.HOBBIT);
    public static Character PIPPIN = new Character("Pippin", Race.HOBBIT);

    public static Character ARAGORN = new Character("Aragorn", Race.MAN);
    public static Character BOROMIR = new Character("Boromir", Race.MAN);
    public static Character GANDALF = new Character("Gandalf", Race.MAN);

    public static Character LEGOLAS = new Character("Legolas", Race.ELF);
    public static Character GIMLI   = new Character("Gimli", Race.DWARF);

    public static List<Character> CHARACTERS = Arrays.asList(BILBO, FRODO, SAM, ARAGORN, BOROMIR);

    public List<Character> createList() {
        return Arrays.asList(BILBO, FRODO, SAM, ARAGORN, BOROMIR);
    }

    public List<Character> fellowshipOfTheRing() {
        return Arrays.asList(FRODO, SAM, MERRY, PIPPIN, ARAGORN, BOROMIR, GANDALF, LEGOLAS, GIMLI);
    }

}
