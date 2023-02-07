package com.company;

import java.util.*;

public class Main {

    public static String buildString(String inputStr) {
        StringBuilder strFromWords = new StringBuilder();
        String[] words = inputStr.split("\\W+");
        for (String w : words) {
            strFromWords.append(findFirstLetter(w));
        }
        return strFromWords.toString();
    }

    public static Character findFirstLetter(String inputWord) {
        char[] letters = inputWord.toCharArray();
        LinkedHashMap<Character, Integer> lettersMap = new LinkedHashMap<>();

        for (char l : letters) {
            lettersMap.merge(l, 1, Integer::sum);
        }

        lettersMap.entrySet().removeIf(new_Map -> new_Map.getValue() > 1);

        return lettersMap.entrySet().stream().findFirst().get().getKey();
    }

    public static Character findUniqLetter(String inputStr) {
        return  findFirstLetter(inputStr);
    }

    public static void main(String[] args) {
        long m = System.currentTimeMillis();

        String inputText = "The Tao gave birth to machine language.  Machine language gave birth\n" +
                "to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand \n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within\n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "        -- Geoffrey James, \"The Tao of Programming\"";
        System.out.println(findUniqLetter(buildString(inputText)));
        System.out.println((double) (System.currentTimeMillis() - m));
    }
}
