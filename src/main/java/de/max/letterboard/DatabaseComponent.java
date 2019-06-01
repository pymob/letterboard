package de.max.letterboard;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseComponent {
    private static final Map<Character, Integer> LETTERS;

    static {
        LETTERS = new HashMap<>();
        addLetter('A', 6);
        addLetter('B', 3);
        addLetter('C', 3);
        addLetter('D', 4);
        addLetter('E', 6);
        addLetter('F', 3);
        addLetter('G', 3);
        addLetter('H', 3);
        addLetter('I', 4);
        addLetter('J', 2);
        addLetter('K', 4);
        addLetter('L', 4);
        addLetter('M', 4);
        addLetter('N', 4);
        addLetter('O', 6);
        addLetter('P', 4);
        addLetter('Q', 1);
        addLetter('R', 4);
        addLetter('S', 4);
        addLetter('T', 4);
        addLetter('U', 2);
        addLetter('V', 2);
        addLetter('W', 2);
        addLetter('X', 2);
        addLetter('Y', 2);
        addLetter('Z', 2);
        // numbers
        addLetter('1', 2);
        addLetter('2', 2);
        addLetter('3', 2);
        addLetter('4', 2);
        addLetter('5', 2);
        addLetter('6', 2);
        addLetter('7', 2);
        addLetter('8', 2);
        addLetter('9', 2);
        addLetter('0', 2);
        // special characters
        addLetter('#', 2);
        addLetter('!', 2);
        addLetter('?', 2);
        addLetter('&', 2);
    }

    private static void addLetter(char letter, int count) {
        LETTERS.put(letter, count);
    }

    public boolean contains(char item) {
        return LETTERS.containsKey(item);
    }
}
