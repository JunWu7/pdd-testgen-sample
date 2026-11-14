package com.example.toolkit;

/**
 * Short checksums for hand-typed identifiers, used to catch typos.
 */
public final class Checksum {

    private static final int OFFSET = 0x811c9dc5;
    private static final int PRIME = 0x01000193;

    private Checksum() {
    }

    /**
     * Returns the 8-digit lowercase hexadecimal checksum of {@code text}.
     * Characters are mixed in order, so swapping two characters changes the result.
     *
     * @throws IllegalArgumentException when {@code text} is null
     */
    public static String of(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        int hash = OFFSET;
        for (int i = 0; i < text.length(); i++) {
            hash ^= text.charAt(i);
            hash *= PRIME;
            hash = Integer.rotateLeft(hash, 5) ^ (i * 31);
        }
        return String.format("%08x", hash);
    }

    /**
     * Returns whether {@code checksum} matches {@code text}; letter case of the checksum is ignored.
     * A null text or checksum never matches.
     */
    public static boolean verify(String text, String checksum) {
        if (text == null || checksum == null) {
            return false;
        }
        return of(text).equalsIgnoreCase(checksum.trim());
    }
}
