package medium;

import java.util.*;

public class ThreeSum {

    static List<int[]> integerArraysList = new ArrayList<>();

    public static void main(String[] args) {
        initializeIntegerArraysList();
        long startTime;
        long endTime;

        System.out.println("Result of three sum: ");
        startTime = System.nanoTime();
        for (int[] intArrayValue: integerArraysList){
            System.out.println(calculateThreeSum(intArrayValue));
            System.out.println("--------------------------");
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for first approach is: "+(endTime-startTime)+" nano seconds");
        //1001458 nano seconds

        System.out.println("Result of three sum with set: ");
        startTime = System.nanoTime();
        for (int[] intArrayValue: integerArraysList){
            System.out.println(calculateThreeSumWithSet(intArrayValue));
            System.out.println("--------------------------");
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for second approach is: "+(endTime-startTime)+" nano seconds");
        //257500 nano seconds

        //Second approache is approximately 4 times better than first approache.

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

    private static List<List<Integer>> calculateThreeSumWithSet(int[] nums){
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if (sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);
    }

    private static void initializeIntegerArraysList(){
        int[] intArray = {-1,0,1,2,-1,-4};
        int[] intArray2 = {0,1,1};
        int[] intArray3 = {0,0,0};

        integerArraysList.add(intArray);
        integerArraysList.add(intArray2);
        integerArraysList.add(intArray3);
    }

}
