package com.thinktwice.cs.leetcode;

import java.util.HashMap;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        //mapping
        int i=0;
        for(int temp: nums){
            sumMap.put(temp,i++);
        }
        int[] rtn= new int[2];
        //find using HashMap
        i=0;
        for(int temp: nums){
            Integer v=sumMap.get(target-temp);
            if(v!=null&&v>i){
                rtn[0]=i;
                rtn[1]=v;
                return rtn;
            }
            i++;
        }
        return rtn;
    }
}
