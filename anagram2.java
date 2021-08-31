import java.util.*;
public class anagram2 {

    public static boolean isAnagram(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        char tempArray[] = a.toLowerCase().toCharArray();
        Arrays.sort(tempArray); //0(nlogn)


        char tempArray2[] = b.toLowerCase().toCharArray();
        Arrays.sort(tempArray2);  //0(nlogn)

        int[] freqA = new int[tempArray.length];
        int[] freqB = new int[tempArray2.length];

        for (int i = 0; i < tempArray.length; i++) {
            freqA[i] = 1;
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[i] == tempArray[j]) {
                    freqA[i]++;
                    //Set string[j] to 0 to avoid printing visited character
                    tempArray[j] = '0';
                }
            }
        }

        for (int i = 0; i < tempArray2.length; i++) {
            freqB[i] = 1;
            for (int j = i + 1; j < tempArray2.length; j++) {
                if (tempArray2[i] == tempArray2[j]) {
                    freqB[i]++;
                    //Set string[j] to 0 to avoid printing visited character
                    tempArray2[j] = '0';
                }
            }
        }

        for(int i=0;i<freqA.length;i++){
            if(freqA[i] != freqB[i]){
                return false;
            }else {
                continue;
            }
        }
        return true;
    }
    public static void main(String[] args){

        String a = "listen";
        String b = "silent";

        System.out.println(isAnagram(a, b));

    }
}
