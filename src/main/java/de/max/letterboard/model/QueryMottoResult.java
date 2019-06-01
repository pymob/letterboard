package de.max.letterboard.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Builder
public class QueryMottoResult {
    private String text;
    private Map<Character, Long> count;
    private Set<Character> ignored;
}
