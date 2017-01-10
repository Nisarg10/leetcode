package com.leetcode.ransomnote;

import java.util.HashMap;

/**
 * Created by Nisarg on 1/10/2017.
 */
public class RansomNote {

    public static boolean optimalSolution(String ransomNote, String magazine){
        int[] table = new int[128];
        for (char c : magazine.toCharArray())   table[c]++;
        for (char c : ransomNote.toCharArray())
            if (--table[c] < 0) return false;
        return true;
    }

    public static void lessEfficientSolution(String ransomNote, String magazine){
        char[] mag = magazine.toCharArray();
        char[] ransom = ransomNote.toCharArray();

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < mag.length; i++) {
            if (charCount.containsKey(mag[i]))
                charCount.put(mag[i], charCount.get(mag[i]) + 1);
            else
                charCount.put(mag[i], 1);
        }

        for (int i = 0; i < ransom.length; i++) {
            if (charCount.containsKey(ransom[i])) {
                if (charCount.get(ransom[i]) > 0)
                    charCount.put(ransom[i], charCount.get(ransom[i]) - 1);
                else {
                    System.out.println("FALSE");
                    break;
                }
            } else {
                System.out.println("FALSE");
                break;
            }
        }
        System.out.println("TRUE");
    }

    public static void main(String[] args) {
        String ransomNote = "aaf";
        String magazine = "aab";

        lessEfficientSolution(ransomNote, magazine);
        System.out.println(optimalSolution(ransomNote, magazine));
    }

}

