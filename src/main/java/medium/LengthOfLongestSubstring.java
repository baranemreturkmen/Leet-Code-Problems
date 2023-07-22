package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LengthOfLongestSubstring {

    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        initializeExampleStrings();

        for(String string: stringList){
            System.out.println(lengthOfLongestSubstring(string));
        }

        //TODO:New problem. What if we've have to return substrings also. What we've have to do?

    }

    private static void initializeExampleStrings(){
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        stringList.add(s1);
        stringList.add(s2);
        stringList.add(s3);
    }

    private static int lengthOfLongestSubstring(String s) {
        int firstPointer = 0;
        int lastPointer = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet();

        while(firstPointer+lastPointer-1 < s.length()){
            if(!hashSet.contains(s.charAt(lastPointer))){
                hashSet.add(s.charAt(lastPointer));
                lastPointer++;
                max = Math.max(hashSet.size(),max);
            }
            else{
                hashSet.remove(s.charAt(firstPointer));
                firstPointer++;
            }
        }
        return max;
    }

    private static String resultOfLongestSubstring(String s){
        return "";
    }

}
