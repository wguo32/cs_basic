package com.thinktwice.cs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Integer2EnglishWords_273 {

  String[] units = new String[] {"Billion", "Million", "Thousand", ""};
  String[] nums =
      new String[] {
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
      };

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    char[] array = String.valueOf(num).toCharArray();
    String rtn = "";
    String tmpUnit = null;
    int row = array.length / 3 + (array.length % 3 != 0 ? 1 : 0);
    int zeroCnt = 12 - array.length;
    char[] arrayNew = new char[12];
    for (int i = 0; i < zeroCnt; i++) {
      arrayNew[i] = '0';
    }
    for (int i = 0; i < array.length; i++) {
      arrayNew[i + zeroCnt] = array[i];
    }

    for (int i = 0; i < 4; i++) {

      int i0 = 0 + i * 3;
      int i1 = 1 + i * 3;
      int i2 = 2 + i * 3;

      char a = arrayNew[i0];
      char b = arrayNew[i1];
      char c = arrayNew[i2];
      String tmp = "";
      // a
      if (a != '0') {
        tmp += nums[Integer.parseInt(a + "") - 1] + " Hundred ";
      }
      // b
      if (b != '0') {
        if (b == '1') {
          if (c == '0') {
            tmp += nums[9];
          } else {
            tmp += nums[Integer.parseInt(b + "" + c) - 1];
          }
        } else {
          tmp += nums[Integer.parseInt(b + "") + 17];
        }
      }
      // c
      if (c != '0' & b != '1') {
        tmp += " " + nums[Integer.parseInt(c + "") - 1];
      }

      if (tmp != null && !"".equals(tmp)) {
        tmpUnit = units[i];
        rtn += tmp + " " + tmpUnit + " ";
      }
    }
    return rtn.trim().replace("  ", " ");
  }

  public static void main(String[] args) {
    Integer2EnglishWords_273 a = new Integer2EnglishWords_273();
    System.out.println(a.numberToWords(2034500670));
  }
}
