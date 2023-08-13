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
        String s4 = "pwwkeweeemrnl";

        stringList.add(s1);
        stringList.add(s2);
        stringList.add(s3);
        stringList.add(s4);
    }

    private static int lengthOfLongestSubstring(String s) {
        int firstPointer = 0;
        int lastPointer = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet();

        while(lastPointer< s.length()){
            if(!hashSet.contains(s.charAt(lastPointer))){
                /*HashSet'e ekleme konusunda yoklama yaparken firstPointer'a göre hep öndeyim.
                  Eklemeyeceksem elemanın kendisi varsa eğer ben artmıyorum geriden silme işlemi için
                  kullandığım firstPointer indeksi artıyor. Totalde length kadar String'i gezmiş oluyorum.
                  Geriden de tarama yapıyorum sileceğim hashset'te ki elemanı geriden gelerek kaldığım yerden
                  buluyorum. Kaldığım yerden devam ettiğim için geriden gelirken silinmesi gereken subString silinene kadar
                  firstIndex 1 artıyor. Çünkü benim lastPointer'ım asıl String'de aynı yere bakmaya
                  devam ettiği için durmadan else'e düşüyorum ve firstPointer hashset'de eleman silmeye devam ediyor.
                  firstPointer son aşamada geriden geldiği için en son lastPointer'ın baktığı karakteri siliyor ve lastPointer
                  ile firstPointer tamamen eşitleniyor. Son adımda firstPointer tamamen hashset'i boşalttığı zaman lastPointer
                  aynı yere baksa dahi hashset asıl string'de lastPointer'ın baktığı yeri içermiyor ve ilk işlemi ile
                  aynı karakter çıkana kadar hashset karakter eklemeye devam ediyorum. Tüm string dolaşıldığı zamana
                  kadar bu işlemler devinim halinde tekrarlanıyor. Doldur boşalt yapıyoruz. Önce lastPointer aynı karakter
                  gelene kadar hashset'i dolduruyor. firstPointer aynı karakter silinene kadar hashset'i boşaltıyor. Tüm bu
                  işlemler arasında max value'yu substring için buluyoruz.*/
                hashSet.add(s.charAt(lastPointer));
                lastPointer++;
                max = Math.max(hashSet.size(),max);
            }
            else{
                //Sileceği elemana bakarken geriden geliyor. Ve hep kaldığı yerden devam ediyor
                hashSet.remove(s.charAt(firstPointer));
                firstPointer++;
            }
        }
        return max;
    }

    //Whoops! It's not useless anymore :)
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
            /*We need that if block because if longest subString end of the main string we can not add
            * subString to result list due to our algorithm in for loop!*/
            if(i==s.length()-1 && setOfLongestSubstring(subString).size()==subString.length()){
                resultList.add(subString);
            }
        }

        return resultList.stream().
                max(Comparator.comparingInt(String::length)).get();
    }

}
