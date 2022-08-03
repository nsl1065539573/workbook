package com.nansl.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 */
public class InsertionSorter {
  public static void main(String[] args) {
    int n = 1000;
    int[] arr = new int[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      arr[i] = random.nextInt(n);
    }
    sort(arr);
    for (int i = 1; i < n; i++) {
      if (arr[i] < arr[i - 1]) {
        throw new RuntimeException("sort failed!");
      }
    }
    System.out.println("sort success");
  }

  public static void sort(int[] arr) {
    if (arr == null || arr.length < 1) {
      return;
    }
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      int temp = arr[j];
      while (j > 0 && temp < arr[j - 1]) {
        arr[j] = arr[j - 1];
        j--;
      }
      if (j != i) {
        arr[j] = temp;
      }
    }
  }
}
