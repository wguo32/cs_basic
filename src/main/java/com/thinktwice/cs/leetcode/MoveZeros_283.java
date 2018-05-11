package com.thinktwice.cs.leetcode;

public class MoveZeros_283 {

    public void moveZeroes(int[] nums) {
        int tmp=0;
        int tmpNext=0;
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                tmp=nums[j];
                tmpNext=nums[i];
                if (tmp==0){
                    nums[i]=tmp;
                    nums[j]=tmpNext;
                }
            }
        }
    }
    public void moveZeroes2(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos]= nums[i];
                pos++;
            }
        }
        for(;pos<nums.length; pos++){
            nums[pos] = 0;
        }
    }
    public static void main(String[] args) {
        MoveZeros_283 a =new MoveZeros_283();
        a.moveZeroes2(new int[]{0, 1, 0, 0, 3, 14});
    }

}
