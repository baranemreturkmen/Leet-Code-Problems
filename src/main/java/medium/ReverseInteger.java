package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseInteger {

    static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {
        initializeInts();
        for(int intElement: integerList){
            System.out.println(resultOfReverseInteger(intElement));
        }
    }

    private static List<Integer> initializeInts(){
        integerList.add(0);
        integerList.add(1230);
        integerList.add(-1230);
        integerList.add(567);
        integerList.add(-567);
        integerList.add(120);
        integerList.add(901000);
        integerList.add(1534236469);
        integerList.add(50078);
        integerList.add(-30060);

        return integerList;
    }

    //TODO: Solve the problem without Character of list for better performance.
    private static int resultOfReverseInteger(int x){
        if(x == 0){
            return x;
        }
        Integer wraperx =x;
        String strx = wraperx.toString();
        List<Character> charList = strx.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        strx = "";
        boolean control = false;
        if(charList.get(0).equals('-')){
            charList.remove(0);
            control = true;
        }

        for(int i= charList.size()-1;i>=0;i--){
            if(charList.get(i).equals('0') && i== charList.size()-1){
                charList.remove(i);
                continue;
            }
            strx = strx + charList.get(i);
        }
        try{
            x = Integer.valueOf(strx);
        }
        catch (NumberFormatException numberFormatException){
            return 0;//If reverse of the integer out of 2^32 or -2^32 we should return 0.
        }

        if(control){
            x = x*-1;
        }
        return x;
    }

}
