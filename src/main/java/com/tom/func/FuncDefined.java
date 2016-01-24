package com.tom.func;

import java.util.function.Function;

public class FuncDefined {

    String prefix = "p1";

    Function<String, String> prefixFunction = s -> s + prefix;

}
