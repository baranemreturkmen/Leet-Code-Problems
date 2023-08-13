package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static List<int[]> integerArrayList = new ArrayList<>();

    public static void main(String[] args) {
        initializeIntegerList();
        for (int[] intArrayValue: integerArrayList){
            System.out.println(calculateThreeSum(intArrayValue));
            System.out.println("--------------------------");
        }
    }

    private static List<List<Integer>> calculateThreeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the pointers
                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;
    }

    private static void initializeIntegerList(){
        int[] intArray = {-1,0,1,2,-1,-4};
        int[] intArray2 = {0,1,1};
        int[] intArray3 = {0,0,0};

        integerArrayList.add(intArray);
        integerArrayList.add(intArray2);
        integerArrayList.add(intArray3);
    }

}
