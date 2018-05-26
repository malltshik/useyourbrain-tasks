package ru.malltshik.tasks;

import java.util.HashSet;

/**
 * In this task you have to find a first letter which has a duplicate ones in source string
 * For instance:
 * "ABCDEAFG" -> "A"
 * "ABCDEBFG" -> "B"
 * "LBCBADGC" -> "B"
 * "ABCDEFG" -> null
 */
class RepeatableCharacter {

    // O(n^2)
    static String findRepeatableCharacter(String str) {
        String[] source = str.split("");
        String result = null;
        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[j].equals(source[i])) {
                    result = source[i];
                    break;
                }
            }
            if (result != null) break;
        }
        return result;
    }

    // O(n)
    static String quickFindRepeatableCharacter(String str) {
        String[] source = str.split("");
        String result = null;

        HashSet<String> store = new HashSet<>();

        for (String letter : source) {
            if(store.contains(letter)) {
                result = letter;
                break;
            } else {
                store.add(letter);
            }
        }

        return result;
    }

}
