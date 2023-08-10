package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseInteger {

    static List<Integer> integerList = new ArrayList<>();
    private static final long NANO_TO_MILLISECONDS_CONSTANT = 1_000_000;

    public static void main(String[] args) {
        initializeInts();
        long startTime;
        long endTime;

        System.out.println("Result of reverse integer: ");
        startTime = System.nanoTime();
        for(int intElement: integerList){
            System.out.println(resultOfReverseInteger(intElement));
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for first approach is: "+(endTime-startTime)/NANO_TO_MILLISECONDS_CONSTANT+" milliseconds");
        //Nearly 2 milliseconds.

        System.out.println("-------------------------------------");

        System.out.println("Result of reverse integer without Character list: ");
        startTime = System.nanoTime();
        for(int intElement: integerList){
            System.out.println(resultOfReverseIntegerWithoutCharacterList(intElement));
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for second approach is: "+(endTime-startTime)/NANO_TO_MILLISECONDS_CONSTANT+" milliseconds");
        //Nearly 5 milliseconds.

        /*Whoops! I was wrong! Working with Character of list offers better solution than String charAt.
        * Why?
        * That's the explanation:
        * https://stackoverflow.com/questions/51896947/opertion-performance-between-arraylist-or-single-string*/
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

    private static int resultOfReverseIntegerWithoutCharacterList(int x){
        if(x == 0){
            return x;
        }
        Integer wraperx =x;
        String strx = wraperx.toString();

        boolean control = false;
        if(strx.charAt(0) == '-'){
            strx = strx.substring(1);
            control = true;
        }

        String strxNew = "";
        for(int i= strx.length()-1;i>=0;i--){
            if(strx.charAt(i) == -1 && i== strx.length()-1){
                strx = strx.substring(0,strx.length()-1);
                continue;
            }
            strxNew = strxNew + strx.charAt(i);
        }
        try{
            x = Integer.valueOf(strxNew);
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
