package com.thinktwice.cs.dsalgo;

public class BinarySearch {

  public static int binarySearch(String[] sorts, String x, int low, int high) {
    if (low > high) {
      return -1;
    }
    int m = (low + high) / 2;
    int cmp = x.compareTo(sorts[m]);
    if (cmp < 0) {
      return binarySearch(sorts, x, low, m);
    } else if (cmp > 0) {
      return binarySearch(sorts, x, m, high);
    } else {
      return m;
    }
  }

  public static void main(String[] args) {
    String[] inputs = {"a", "b", "c", "d", "e", "f", "g"};
    int m = binarySearch(inputs, "h", 0, inputs.length - 1);
    System.out.println(m);
  }
}
