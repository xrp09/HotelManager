package com.inks.hb.authinfo.dao;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum = nums[0] + nums[1] + nums[2];
        for(int i = 0;i<nums.length - 2;i++) {
        int j = i+1;
        int k = nums.length - 1;
        while(j<k) {
            int tmp = nums[i]+nums[j]+nums[k];
            if(Math.abs(tmp - target) < Math.abs(closeNum - target)) {
                closeNum = tmp;
            }
            if(tmp < target) {
                j++;
            }else if(tmp > target) {
                k--;
            }else {
                return tmp;
            }
        }
    }
        return closeNum;
}
}


