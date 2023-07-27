package medium;

import java.util.Scanner;

public class ZigzagConversion {

    private static final String INPUT = "PAYPALISHIRING";
    private static int numRows;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Satır sayısını giriniz : ");
        numRows = input.nextInt();
        System.out.println(convert(INPUT,numRows));
    }

    private static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] sbs = new StringBuilder[numRows];

        int row = 0;
        int dir = 0;

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            row += dir;
            sbs[row].append(c);
            if (row == 0 || row == numRows - 1) {
                dir = (dir == 0) ? 1 : -dir;
            }
        }
        return returnTotalResult(sbs);
    }

    private static String returnTotalResult(StringBuilder[] sbs) {
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb: sbs) {
            result.append(sb.toString());
        }
        return result.toString();
    }

}
