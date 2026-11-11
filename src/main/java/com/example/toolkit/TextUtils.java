package com.example.toolkit;

import java.util.Locale;

/**
 * Small string helpers. Every method treats {@code null} as an empty string.
 */
public final class TextUtils {

    private TextUtils() {
    }

    /** Returns {@code text} reversed. */
    public static String reverse(String text) {
        if (text == null) {
            return "";
        }
        return new StringBuilder(text).reverse().toString();
    }

    /**
     * Whether {@code text} reads the same backwards, ignoring case and every character
     * that is not a letter or a digit. An empty or {@code null} text is a palindrome.
     */
    public static boolean isPalindrome(String text) {
        if (text == null) {
            return true;
        }
        String cleaned = text.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /** Counts the English vowels (a, e, i, o, u) in {@code text}, ignoring case. */
    public static int countVowels(String text) {
        if (text == null) {
            return 0;
        }
        int count = 0;
        for (char c : text.toLowerCase(Locale.ROOT).toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Capitalizes the first letter of every word and lowercases the rest.
     * Words are separated by whitespace; runs of whitespace become a single space.
     */
    public static String capitalizeWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }
        String[] words = text.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase(Locale.ROOT));
        }
        return result.toString();
    }

    /**
     * Shortens {@code text} to at most {@code maxLength} characters, ending with "..."
     * when it was cut.
     *
     * @throws IllegalArgumentException when {@code maxLength} is less than 3
     */
    public static String truncate(String text, int maxLength) {
        if (maxLength < 3) {
            throw new IllegalArgumentException("maxLength must be at least 3");
        }
        if (text == null) {
            return "";
        }
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength - 3) + "...";
    }
}
