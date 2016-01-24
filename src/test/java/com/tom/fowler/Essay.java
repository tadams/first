package com.tom.fowler;

import lombok.Data;
import lombok.experimental.Builder;

import java.util.Set;

@Data
@Builder
public class Essay {

    String title;
    int wordCount;
    EssayType type;
    Set<EssayTag> tags;
}
