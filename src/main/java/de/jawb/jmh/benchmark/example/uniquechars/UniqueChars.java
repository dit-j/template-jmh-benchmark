package de.jawb.jmh.benchmark.example.uniquechars;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueChars {

    //
    // ---------------------- A ---------------------------------------
    //
    
    public static String getDistinctCharString_A_1(String s1, String s2) {
        return _joinA(new LinkedHashSet<>(), s1, s2);
    }
    
    public static String getDistinctCharString_A_2(String s1, String s2) {
        return _joinA(new LinkedHashSet<>(s1.length() + s2.length()), s1, s2);
    }
        
    public static String getDistinctCharString_A_3(String s1, String s2) {
        return _joinA(new LinkedHashSet<>(s1.length() + s2.length() + 5, 1.0f), s1, s2);
    }
    
    public static String getDistinctCharString_A_4(String s1, String s2) {
        return _joinA(new LinkedHashSet<>((s1.length() + s2.length()) * 2, 1.0f), s1, s2);
    }
    
    private static String _joinA(Set<Character> set, String s1, String s2){ 
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        
        for (char c : chars1) set.add(c);
        for (char c : chars2) set.add(c);
        
        StringBuilder sb = new StringBuilder(set.size());
        for (char c : set) sb.append(c);
        return sb.toString();
    }
    
    //
    // ---------------------- B ---------------------------------------
    //
    
    public static String getDistinctCharString_B_1(String s1, String s2) {
        return _joinB(new LinkedHashSet<>(), s1, s2);
    }
    
    public static String getDistinctCharString_B_2(String s1, String s2) {
        return _joinB(new LinkedHashSet<>(s1.length() + s2.length()), s1, s2);
    }
        
    public static String getDistinctCharString_B_3(String s1, String s2) {
        return _joinB(new LinkedHashSet<>(s1.length() + s2.length() + 5, 1.0f), s1, s2);
    }
    
    public static String getDistinctCharString_B_4(String s1, String s2) {
        return _joinB(new LinkedHashSet<>((s1.length() + s2.length()) * 2, 1.0f), s1, s2);
    }
    
    private static String _joinB(Set<Character> set, String s1, String s2){ 
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        
        for (char c : chars1) set.add(c);
        for (char c : chars2) set.add(c);

        StringBuilder sb = new StringBuilder(set.size());
        set.forEach(ch -> sb.append(ch));
        return sb.toString();
    }
    
    //
    // ---------------------- C ---------------------------------------
    //
    
    public static String getDistinctCharString_C_1(String s1, String s2) {
        return _joinC(new LinkedHashSet<>(), s1, s2);
    }
    
    public static String getDistinctCharString_C_2(String s1, String s2) {
        return _joinC(new LinkedHashSet<>(s1.length() + s2.length()), s1, s2);
    }
        
    public static String getDistinctCharString_C_3(String s1, String s2) {
        return _joinC(new LinkedHashSet<>(s1.length() + s2.length() + 5, 1.0f), s1, s2);
    }
    
    public static String getDistinctCharString_C_4(String s1, String s2) {
        return _joinC(new LinkedHashSet<>((s1.length() + s2.length()) * 2, 1.0f), s1, s2);
    }
    
    private static String _joinC(Set<Character> set, String s1, String s2){ 
        for (char c : s1.toCharArray()) set.add(c);
        for (char c : s2.toCharArray()) set.add(c);

        StringBuilder sb = new StringBuilder(set.size());
        for (char c : set) sb.append(c);
        return sb.toString();
    }

    //
    // ---------------------- D ---------------------------------------
    //
    
    public static String getDistinctCharString_D_1(String s1, String s2) {
        return _joinD(new LinkedHashSet<>(), s1, s2);
    }
    
    public static String getDistinctCharString_D_2(String s1, String s2) {
        return _joinD(new LinkedHashSet<>(s1.length() + s2.length()), s1, s2);
    }
        
    public static String getDistinctCharString_D_3(String s1, String s2) {
        return _joinD(new LinkedHashSet<>(s1.length() + s2.length() + 5, 1.0f), s1, s2);
    }
    
    public static String getDistinctCharString_D_4(String s1, String s2) {
        return _joinD(new LinkedHashSet<>((s1.length() + s2.length()) * 2, 1.0f), s1, s2);
    }
    
    private static String _joinD(Set<Character> set, String s1, String s2){ 
        for (char c : s1.toCharArray()) set.add(c);
        for (char c : s2.toCharArray()) set.add(c);

        StringBuilder sb = new StringBuilder(set.size());
        set.forEach(ch -> sb.append(ch));
        return sb.toString();
    }

    //
    // ---------------------- F ---------------------------------------
    //
    
    public static String getDistinctCharString_F(String s1, String s2) {
        boolean[] memory = new boolean[200];
        
        StringBuilder sb = new StringBuilder(s1.length() + s2.length());
        
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int codepoint = (int) ch;
            
            boolean exists = memory[codepoint];
            memory[codepoint] = true;
            
            if (!exists) sb.append(ch);
        }
        
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            int codepoint = (int) ch;
            boolean exists = memory[codepoint];
            
            memory[codepoint] = true;
            
            if (!exists) sb.append(ch);
        }
        
        return sb.toString();
    }

    //
    // ---------------------- E ---------------------------------------
    //
    
    public static String getDistinctCharString_E_1(String s1, String s2) {
        return Stream.of(s1, s2)//
                .map(String::chars)//
                .flatMap(intStream -> intStream.mapToObj(charCode -> (char) charCode))//
                .distinct().map(character -> new String(new char[] { character }))//
                .collect(Collectors.joining());
    }

    public static String getDistinctCharString_E_2(String s1, String s2) {
        return Stream.of(s1, s2)//
                .map(String::chars)//
                .flatMap(intStream -> intStream.mapToObj(charCode -> (char) charCode))//
                .distinct().map(ch -> String.valueOf(ch.charValue()))
                .collect(Collectors.joining());
    }
    
}
