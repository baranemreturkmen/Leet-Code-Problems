package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LongestPalindromeSubstring {

    static List<String> stringList = new ArrayList<>();

    //TODO: Measure 2 methods execution time. Is second approach implements better performance?

    public static void main(String[] args) {
        initializeExampleStrings();

        System.out.println("Result of longest palindrome substring: ");
        for(String string: stringList){
            System.out.println(resultOfLongestPalindrome(string));
        }

        System.out.println("---------------------");

        System.out.println("Result of longest palindrome substring with better performance: ");
        for(String string: stringList){
            System.out.println(resultOfLongestPalindromeWithBetterPerformance(string));
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
            //For the test cases which have same char characters on String.
            if(charList.stream().collect(Collectors.toSet()).size()==1){
                palindromicList.add(s);
                break;
            }
            if(charList.get(i) == charList.get(beginIndex)){
                String palindromicString = s.substring(beginIndex,i+1);
                //check palindromic situation
                if(palindromicString.equals(returnReversedString(palindromicString))){
                    palindromicList.add(s.substring(beginIndex,i+1));
                    //beginIndex=i;
                }
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

    private static String resultOfLongestPalindromeWithBetterPerformance(String s){
        if(s.isBlank() || Objects.isNull(s)){
            return "";
        }

        int start = 0;
        int end = 0;

        for(int i=0; i<s.length();i++){
            int len1 = expandFromMiddle(s,i,i);
            int len2 = expandFromMiddle(s,i,i+1);
            int maxLen = Math.max(len1,len2);
            if(maxLen > end - start){
                start = i - ((maxLen-1)/2);
                end = i + (maxLen/2);
            }
        }
        return s.substring(start,end + 1);
    }

    private static void initializeExampleStrings(){
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "ccc";
        String s4 = "aacabdkacaa";
        String s5 = "bananas";
        String s6 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        stringList.add(s1);
        stringList.add(s2);
        stringList.add(s3);
        stringList.add(s4);
        stringList.add(s5);
        stringList.add(s6);
    }

    private static String returnReversedString(String s){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        return stringBuilder.reverse().toString();
    }

    private static int expandFromMiddle(String s, int left, int right){
        while (left >= 0 && right< s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
