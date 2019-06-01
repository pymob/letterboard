package de.max.letterboard.service;

import de.max.letterboard.DatabaseComponent;
import de.max.letterboard.model.QueryMottoResult;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

@Service
public class QueryMottoService {
    private final DatabaseComponent database;

    public QueryMottoService(DatabaseComponent databaseComponent) {
        database = databaseComponent;
    }

    public Optional<QueryMottoResult> handleMotto(@NotEmpty String motto) {
        List<String> chars = Arrays.asList(motto.toUpperCase().split(""));
        Set<Character> ignored = new HashSet<>();
        final Map<Character, Long> count = chars.stream()
                .map(item -> item.charAt(0))
                .filter(item -> {
                    boolean  containsItem = database.contains(item);
                    if (!containsItem) {
                        ignored.add(item);
                    }
                    return containsItem;
                })
                .collect(Collectors.groupingBy(identity(), counting()));
        QueryMottoResult result = QueryMottoResult.builder()
                .text(motto)
                .count(count)
                .ignored(ignored)
                .build();
        return Optional.of(result);
    }
}
