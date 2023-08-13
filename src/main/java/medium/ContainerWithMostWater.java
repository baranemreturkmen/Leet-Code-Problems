package medium;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {

    static List<int[]> integerArraysList = new ArrayList<>();

    public static void main(String[] args) {
        initializeIntegerArraysList();
        for(int[] intArrayValue: integerArraysList){
            System.out.println(calculateMaxArea(intArrayValue));
        }
    }

    private static int calculateMaxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            max = Math.max(max, area);
            if(height[left] < height[right]) left++;
            else if(height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return max;
    }

    private static void initializeIntegerArraysList(){
        int[] intArray = {1,8,6,2,5,4,8,3,7};
        int[] intArray2 = {1,1};

        integerArraysList.add(intArray);
        integerArraysList.add(intArray2);
    }
}
