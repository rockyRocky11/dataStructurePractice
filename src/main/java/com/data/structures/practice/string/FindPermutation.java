package com.data.structures.practice.string;

public class FindPermutation {
    public static void main(String[] args) {
       //String s1 = "ab", s2 = "eidbaooo";
        //String s1 = "ab", s2 = "eidabooo";
        //String s1 = "hello", s2 = "ooolleoooleh";
        //String  s1 = "ab", s2 = "eidboaoo";
        //String  s1 = "ab", s2 = "ab";
        //String  s1 = "ab", s2 = "ba";
        String  s1 = "abc", s2 = "bbbca";
        //String  s1 = "adc", s2 = "dcda";
        //String  s1 = "a", s2 = "ab";
        //String  s1 = "abc", s2 = "ccccbbbbaaaa";
        System.out.println(checkInclusionBest(s1, s2));
        //System.out.println(checkInclusion1(s1, s2));
        //System.out.println(checkInclusionByStartChar(s1, s2));
    }

    public static boolean checkInclusionBest(String s1, String s2) {
        int len = s1.length();
        if (s2.length() < len || len == 0)
            return false;

        if (len == 1)
            return s2.contains(s1);

        int[] freq = new int[26];
        for (int i = 0; i < len; i++)
            freq[s1.charAt(i) - 'a']++;

        int l = 0, r = 0;

        while (r < s2.length()) {
            freq[s2.charAt(r) - 'a']--;

            if (r - l + 1 == len) {
                if (nullFreq(freq))
                    return true;
                freq[s2.charAt(l++) - 'a']++;
            }
            r++;
        }
        return false;
    }

    public static boolean nullFreq(int[] freq) {
        for (int i = 0; i < freq.length; i++)
            if (freq[i] != 0)
                return false;
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] s1CountArray = new char[26];
        char[] s1Array = s1.toCharArray();
        for (char val : s1Array) {
            s1CountArray[val - 97]++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String curr = s2.substring(i, i + s1.length());
            char[] s2CountArray = new char[26];
            char[] s2Array = curr.toCharArray();
            for (char val : s2Array) {
                s2CountArray[val - 97]++;
            }
            boolean anyMis = false;
            for (char val : s1Array) {
                if (s1CountArray[val - 97] != s2CountArray[val - 97]) {
                    anyMis = true;
                }
            }
            if (!anyMis) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] s1CountArray = new char[26];
        char[] s1Array = s1.toCharArray();
        for (char val : s1Array) {
            s1CountArray[val - 97]++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String curr = s2.substring(i, i + s1.length());
            char[] s2CountArray = new char[26];
            char[] s2Array = curr.toCharArray();
            for (char val : s2Array) {
                s2CountArray[val - 97]++;
            }
            boolean anyMis = false;

            for (int j = 0; j < s1CountArray.length; j++) {
                if (s1CountArray[j] != s2CountArray[j]) {
                    anyMis = true;
                }
            }
            if (!anyMis) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusionByStartChar(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        char firstChar = s1Array[0];
        int s2MidPoint = s2.indexOf(firstChar, 0);
        boolean anyLeftMis = false;
        boolean anyRightMis = false;
        boolean leftExist = false;
        boolean rightExist = false;
        while (s2MidPoint - (s1.length()-1) >= 0) {
            leftExist=true;
            int start = s2MidPoint;
            for (int i = 0; i < s1Array.length; i++) {
                char curr = s1Array[i];

                boolean anyCurrMis = false;
                while (start > (s2MidPoint - (s1Array.length ))) {
                    if (curr == s2Array[start ]) {
                        anyCurrMis = true;
                        start--;
                        break;
                    }

                    start--;
                }
                if (!anyCurrMis) {
                    anyLeftMis = true;
                    break;
                }
            }
            s2MidPoint = s2.indexOf(firstChar, s2MidPoint) != s2MidPoint ? s2.indexOf(firstChar, s2MidPoint) : -1;

        }
        if ((leftExist && anyLeftMis) || !leftExist) {

            s2MidPoint = s2.indexOf(firstChar, 0);
            while (s2MidPoint + s1.length() <= s2.length()) {
                rightExist=true;
                int start = s2MidPoint;
                for (int i = 0; i < s1Array.length; i++) {
                    char curr = s1Array[i];

                    boolean anyCurrMis = false;
                    while (start <= (s2MidPoint + (s1Array.length ))) {
                        if (curr == s2Array[start ]) {
                            anyCurrMis = true;
                            start++;
                            break;
                        }

                        start++;
                    }
                    if (!anyCurrMis) {
                        anyRightMis = true;
                        break;
                    }
                }

                s2MidPoint = s2.indexOf(firstChar, s2MidPoint) != s2MidPoint ? s2.indexOf(firstChar, s2MidPoint) : s2.length();

            }
        }
        if ((!anyLeftMis && leftExist) ||  (rightExist && !anyRightMis)) {
            return true;
        }

        return false;
    }
}
