package de.jawb.jmh.benchmark.example.uniquechars;

import java.util.HashSet;
import java.util.Set;

public class UniqueChars {

    public static String getDistinctCharString_A_1(String s1, String s2) {
        Set<Character> set = new HashSet<>(s1.length() + s2.length());

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (char c : chars1) {
            set.add(c);
        }

        for (char c : chars2) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder(set.size());

        for (char c : set) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static String getDistinctCharString_A_2(String s1, String s2) {
        Set<Character> set = new HashSet<>(s1.length() + s2.length() + 5, 1.0f);

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (char c : chars1) {
            set.add(c);
        }

        for (char c : chars2) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder(set.size());

        for (char c : set) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static String getDistinctCharString_B_1(String s1, String s2) {
        Set<Character> set = new HashSet<>(s1.length() + s2.length() + 5, 1.0f);

        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            set.add(s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder(set.size() + 10);

        for (char c : set) {
            sb.append(c);
        }

        return sb.toString();
    }

}
