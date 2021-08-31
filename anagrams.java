import java.util.*;

public class anagrams {
    public static boolean findAnagram(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        Map <Character, Integer> mapA = new TreeMap <>();
        Map <Character, Integer> mapB = new TreeMap <>();
        for (int i=0;i<a.length();i++) {
            if (mapA.containsKey(a.charAt(i))) {
                mapA.put(a.charAt(i), mapA.get(a.charAt(i)) + 1);
            } else {
                mapA.put(a.charAt(i), 1);
            }
        }
        for (int j=0;j<b.length();j++) {
            if (!mapA.containsKey(b.charAt(j))) {
                return false;
            }
            if (mapB.containsKey(b.charAt(j))) {
                mapB.put(b.charAt(j), mapB.get(b.charAt(j)) + 1);
            } else {
                mapB.put(b.charAt(j), 1);
            }

        }

        List <Character> xters = new ArrayList <Character>(mapA.keySet());
        for (char f : xters) {
            if (!mapB.containsKey(f) || mapB.get(f) != mapA.get(f)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";

        System.out.println(findAnagram(a, b));

    }
}
