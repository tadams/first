package com.tom;

import com.tom.zombie.Zombie;
import org.hamcrest.Matcher;

public class ZombieMatcher {

//    public static Matcher<Zombie> is(Zombie.Type type) {
//        return new FuncTypeSafeMatcher<Zombie>(z -> z.getType() == type,
//                                              (d) -> d.appendText("Zombie should be " + type),
//                                              (z, d) -> d.appendText("was " + z.getType()));
//    }
//
//    public static Matcher<Zombie> isKilled() {
//        return new FuncTypeSafeMatcher<Zombie>(z -> !z.isAlive(),
//                                              (d) -> d.appendText("Zombie should be killed"),
//                                              (z, d) -> d.appendText("was alive"));
//    }
//
//    public static Matcher<Zombie> isAlive() {
//        return new FuncTypeSafeMatcher<Zombie>(Zombie::isAlive,
//                                               (d) -> d.appendText("Zombie should be alive"),
//                                               (z, d) -> d.appendText("was killed"));
//    }

}
