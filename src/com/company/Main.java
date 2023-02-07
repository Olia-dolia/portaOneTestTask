package com.company;

import java.util.*;

public class Main {

    public static void isCorrect(String input){//find exception
        try {
            if(!input.isEmpty()){
                System.out.println("Unique letter is: " + findUniqLetter(buildString(input)));
            } else {
                System.out.println("String is empty!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static String buildString(String inputStr) {
        StringBuilder strFromWords = new StringBuilder();
        String[] words = inputStr.split("\\W+");//get word from str
        for (String w : words) {
            strFromWords.append(findFirstLetter(w));//build str from unique letters
        }
        return strFromWords.toString();
    }

    public static Character findFirstLetter(String inputWord) {
        char[] letters = inputWord.toCharArray(); //get letters from word
        LinkedHashMap<Character, Integer> lettersMap = new LinkedHashMap<>();//to save letter's order

        for (char l : letters) {
            lettersMap.merge(l, 1, Integer::sum); //put in map, increase if repeated
        }

        lettersMap.entrySet().removeIf(new_Map -> new_Map.getValue() > 1); //delete not unique letters

        return lettersMap.entrySet().stream().findFirst().get().getKey();//return first letter from unique map
    }

    public static Character findUniqLetter(String inputStr) {
        return  findFirstLetter(inputStr);//get first unique letter
    }

    public static void main(String[] args) {
        long m = System.currentTimeMillis();

        String inputText = "The Tao gave birth to machine language.  Machine language gave birth\n" +
                " to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within \n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "    -- Geoffrey James, \"The Tao of Programming\"";

        isCorrect(inputText);
        System.out.println("Runtime: " + (double) (System.currentTimeMillis() - m));
    }
}
