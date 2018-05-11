package com.thinktwice.cs.leetcode;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseInteger_7 {

    public int reverse(int x) {
        //get value of x on each digit
        int x1 = x < 0 ? 0 - x : x;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int mod = -1;
        while (x1 >= 0) {
            if (x1 >= 0 && x1 <= 9) {
                arrayList.add(x1);
                break;
            }
            mod = x1 % 10;
            x1 = x1 / 10;
            arrayList.add(mod);

        }
        //add back by pow10
        int size = arrayList.size();
        int rtn = 0;
        for (int temp : arrayList) {
            rtn += temp * Math.pow(10, --size);
        }
        if (rtn == 2147483647) {
            rtn = 0;
        }
        System.out.println(arrayList);
        rtn = x < 0 ? 0 - rtn : rtn;
        return rtn;

    }


    public int reverse2(int x) {
        //get value of x on each digit
        int x1 = x < 0 ? 0 - x : x;
        StringBuilder sb = new StringBuilder();
        int mod = -1;
        while (x1 >= 0) {
            if (x1 >= 0 && x1 <= 9) {
                sb.append(x1);
                break;
            }
            mod = x1 % 10;
            x1 = x1 / 10;
            sb.append(mod);
        }

        String s = sb.toString().replaceFirst("^0+", "");
        int rtn = 0;
        try {
            rtn = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println(e);
        }
        rtn = x < 0 ? 0 - rtn : rtn;
        return rtn;

    }

    public static void main(String[] args) {
        ReverseInteger_7 r = new ReverseInteger_7();
        System.out.println(r.reverse2(0));
        System.out.println(r.reverse2(2340));
        System.out.println(r.reverse2(-2340));
    }
}
