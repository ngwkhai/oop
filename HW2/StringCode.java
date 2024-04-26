package oop.HW2;

import java.util.HashSet;

public class StringCode {
    public String blowup(String str) {
        char[] s = str.toCharArray();
        int i = 0;
        while(i < s.length) {
            if (s[i] >= '0' && s[i] <= '9') {
                int k = s[i] - '0';
                char c = s[i + 1];
                char[] temp = new char[s.length + k - 1];
                for (int j = 0; j < i; j++) temp[j] = s[j];
                for (int j = i; j < i + k; j++) temp[j] = c;
                for (int j = i; j < s.length - 1; j++) temp[j + k] = s[j + 1];
                s = temp;
            }
            i++;
        }
        return new String(s);
    }

    public int maxRun(String str) {
        char[] s = str.toCharArray();
        int maxi = 1, max = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == s[i - 1]) maxi++;
            else maxi = 1;
            if (maxi > max) max = maxi;
        }
        return max;
    }

    public boolean stringIntersect(String a, String b, int len) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }
        for (int i = 0; i <= b.length() - len; i++) {
            if (set.contains(b.substring(i, i + len))) {
                return true;
            }
        }
        return false;
    }

    public void main(String[] args) {
        System.out.println(blowup(args[0]));
        System.out.println(maxRun(args[0]));
        int len = Integer.parseInt(args[2]);
        System.out.println(stringIntersect(args[0], args[1], len));
    }
}
