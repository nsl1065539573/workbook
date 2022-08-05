package com.nansl.datastruct;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class MinHeap {
  private int[] data;
  private int size;

  public MinHeap(int capacity) {
    data = new int[capacity];
    size = 0;
  }

  public static void main(String[] args) {
    PriorityQueue<Integer> qu = new PriorityQueue<>(10);

    MinHeap minHeap = new MinHeap(10);
    Random random = new Random();
    for (int i = 0; i < 5; i++) {
      qu.offer(i);
      minHeap.push(i);
    }
    for (int i = 0; i < 1000000; i++) {
      int temp = random.nextInt(1000000);
      if (temp > minHeap.peek()) {
        minHeap.pop();
        minHeap.push(temp);
      }
      if (temp > qu.peek()) {
        qu.poll();
        qu.offer(temp);
      }
    }
    System.out.println(minHeap);
    System.out.println(qu);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    for (int i = 0; i < size; i++) {
      if (i < size - 1) {
        stringBuilder.append(data[i]).append(", ");
        continue;
      }
      stringBuilder.append(data[i]).append(']');
    }
    return stringBuilder.toString();
  }

  public Integer peek() {
    if (size == 0) {
      return null;
    }
    return data[0];
  }

  public int pop() {
    if (size == 0) {
      throw new RuntimeException("out of index");
    }
    int res = data[0];
    data[0] = data[size - 1];
    size --;
    adjust(0);
    return res;
  }

  public void push(int val) {
    if (size == data.length) {
      int[] arr = new int[data.length << 1];
      System.arraycopy(data, 0, arr, 0, size);
      data = arr;
    }
    data[size] = val;
    size++;
    adjust((size - 2) / 2);
  }

  private void adjust(int i) {
    if (size < i || size < 0) {
      return;
    }
    int temp = data[i];
    for (int k = i * 2 + 1; k < size; k = k * 2 + 1) {
      if (k + 1 < size && data[k + 1] < data[k]) {
        k++;
      }
      if (data[k] < temp) {
        data[i] = data[k];
        i = k;
      } else {
        break;
      }
      data[i] = temp;
    }
  }
}
