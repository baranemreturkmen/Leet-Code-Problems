package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestPalindromeSubstring {

    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        initializeExampleStrings();

        System.out.println("Result of longest palindrome substring: ");
        for(String string: stringList){
            System.out.println(resultOfLongestPalindrome(string));
        }
    }

    private static String resultOfLongestPalindrome(String s){
        List<Character> charList = s.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        List<String> palindromicList = new ArrayList();

        int beginIndex = 0;
        int i=0;
        int outerIndex=0;

        while(beginIndex<charList.size()){
            if(charList.stream().collect(Collectors.toSet()).size()==1){
                palindromicList.add(s);
                break;
            }
            if(charList.get(i) == charList.get(beginIndex)){
                palindromicList.add(s.substring(beginIndex,i+1));
                beginIndex=i;
            }
            i++;
            if(i==charList.size()){
                outerIndex++;
                i=outerIndex;
                beginIndex=outerIndex;
            }
        }

        return palindromicList.stream().
                max(Comparator.comparingInt(String::length)).get();
    }

    private static void initializeExampleStrings(){
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "ccc";

        stringList.add(s1);
        stringList.add(s2);
        stringList.add(s3);
    }

}
