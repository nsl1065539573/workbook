package com.nansl.datastruct;

public class BinaryTreeNode {
  private Integer val;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  public BinaryTreeNode() {}

  public BinaryTreeNode(Integer val) {
    this.val = val;
  }

  public BinaryTreeNode(Integer val, BinaryTreeNode left, BinaryTreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public Integer getVal() {
    return val;
  }

  public void setVal(Integer val) {
    this.val = val;
  }

  public BinaryTreeNode getLeft() {
    return left;
  }

  public void setLeft(BinaryTreeNode left) {
    this.left = left;
  }

  public BinaryTreeNode getRight() {
    return right;
  }

  public void setRight(BinaryTreeNode right) {
    this.right = right;
  }
}
