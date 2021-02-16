package com.company;

public class Question6 {

    private static final String[] ALPHABET = new String[]{"A", "B", "C", "D", "E"
            , "F", "G", "H", "I", "J"
            , "K", "L", "M", "N", "O"
            , "P", "Q", "R", "S", "T"
            , "U", "V", "W", "X", "Y"
            , "Z"};

    public static String capitalize(String s) {
        return s.toUpperCase();
    }

    public static int findLetterIndex(String letter) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (letter.equalsIgnoreCase(ALPHABET[i])) {
                return i;
            }
        }

        return -1;
    }

    public static String encode(String s) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int letterIndex = findLetterIndex(String.valueOf(s.charAt(i)));

            if (letterIndex != -1) {
                int newLetterIndex = letterIndex + 3;
                if (newLetterIndex > ALPHABET.length - 1) {
                    encoded.append(ALPHABET[newLetterIndex - ALPHABET.length]);
                } else {
                    encoded.append(ALPHABET[newLetterIndex]);
                }
            } else {
                encoded.append(s.charAt(i));
            }
        }

        return encoded.toString();
    }

    public static String decode(String s) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int letterIndex = findLetterIndex(String.valueOf(s.charAt(i)));

            if (letterIndex != -1) {
                int newLetterIndex = letterIndex - 3;
                if (newLetterIndex >= 0) {
                    encoded.append(ALPHABET[newLetterIndex]);
                } else {
                    encoded.append(ALPHABET[ALPHABET.length + newLetterIndex]);
                }
            } else {
                encoded.append(s.charAt(i));
            }
        }

        return encoded.toString();
    }

    public static void main(String[] args) {
        String[] message = new String[]{"KHOOR SSE115G/SSJ115G VWXGHQWV,", "WKLV VHPHVWHU LV YHUB VKRUW.", "SOHDVH ZRUN KDUG.", "NLQG UHJDUGV,", "YXBLVLOH PHPDQL"};

        for (String text : message) {
            System.out.println(decode(capitalize(text)));
        }
    }
}
