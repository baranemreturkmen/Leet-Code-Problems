package medium;

import java.util.*;
import java.util.stream.Collectors;

public class LengthOfLongestSubstring {

    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        initializeExampleStrings();

        System.out.println("Result of longest substring length: ");
        for(String string: stringList){
            System.out.println(lengthOfLongestSubstring(string));
        }

        System.out.println("Result of longest substring: ");
        for(String string: stringList){
            System.out.println(resultOfLongestSubstring(string));
        }

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

    //It's useless, but I like the way of converting Strings to Set of Characters.
    private static Set<Character> setOfLongestSubstring(String s){
        Set<Character> charsSet = s.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());

        return charsSet;
    }

    private static String resultOfLongestSubstring(String s){
        String subString = "";
        List<String> resultList = new ArrayList<>();
        int beginIndex = 0;

        for(int i=0;i<s.length();i++){

            if(subString.contains(s.substring(i,i+1))){
                resultList.add(subString);
                subString = s.substring(i,i+1);
                beginIndex=i;
                continue;
               }

            subString =s.substring(beginIndex,i+1);
        }

        return resultList.stream().
                max(Comparator.comparingInt(String::length)).get();
    }

}
