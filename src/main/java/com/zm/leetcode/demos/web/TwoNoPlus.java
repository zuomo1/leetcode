package com.zm.leetcode.demos.web;

import java.util.HashMap;
import java.util.Map;

public class TwoNoPlus {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ints);

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length-1);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
            System.out.println(1);
            System.out.println(map);
        }
        return new int[0];
    }
}
