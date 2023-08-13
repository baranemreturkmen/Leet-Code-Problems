package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerToRoman {

    static List<Integer> integerList = new ArrayList<>();
    static HashMap<Integer, String> romanHashMap = new HashMap();

    public static void main(String[] args) {

        initializeIntegerList();
        initializeRomanNumbers();

        for(Integer intValue: integerList){
            System.out.println(convertToRomanNumber(intValue));
        }

    }

    private static void initializeIntegerList(){
        //1 <= num <= 3999
        integerList.add(20);
        integerList.add(58);
        integerList.add(1994);
        integerList.add(3);
        integerList.add(21);
    }

    private static void initializeRomanNumbers(){
        romanHashMap.put(1,"I");
        romanHashMap.put(5,"V");
        romanHashMap.put(10,"X");
        romanHashMap.put(50,"L");
        romanHashMap.put(100,"C");
        romanHashMap.put(500,"D");
        romanHashMap.put(1000,"M");
        romanHashMap.put(4,"IV");
        romanHashMap.put(9,"IX");
        romanHashMap.put(40,"XL");
        romanHashMap.put(90,"XC");
        romanHashMap.put(400,"CD");
        romanHashMap.put(900,"CM");
    }

    private static String convertToRomanNumber(int num){
        List<Integer> romanKeysSorted = romanHashMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        String romanNumber = "";

        for (Integer romanKey: romanKeysSorted){
            if(num / romanKey != 0){
                if(romanHashMap.get(romanKey).equals("I")){
                    romanNumber = romanNumber + romanHashMap.get(romanKey).repeat(num/romanKey);
                }
                else if(romanHashMap.get(romanKey).equals("X")){
                    romanNumber = romanNumber + romanHashMap.get(romanKey).repeat(num/romanKey);
                }
                else if(romanHashMap.get(romanKey).equals("C")){
                    romanNumber = romanNumber + romanHashMap.get(romanKey).repeat(num/romanKey);
                }
                else if(romanHashMap.get(romanKey).equals("M")){
                    romanNumber = romanNumber + romanHashMap.get(romanKey).repeat(num/romanKey);
                }
                else{
                    romanNumber = romanNumber + romanHashMap.get(romanKey);
                }
                num = num%romanKey;
            }
        }

        return romanNumber;
    }

}
