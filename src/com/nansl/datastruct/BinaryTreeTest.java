package com.nansl.datastruct;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTest {
  public static void main(String[] args) {
    BinaryTreeNode root = buildTree();
    System.out.println("preOrder------>");
    List<Integer> list = preOrderWithRecursion(root);
    System.out.println(list);
    list = preOrderWithIteration(root);
    System.out.println(list);
    System.out.println("inOrderWithIteration------>");
    list = inOrderWithRecursion(root);
    System.out.println(list);
    System.out.println(inOrderWithIteration(root));
    System.out.println("postOrderWithRecursion----->");
    System.out.println(postOrderWithRecursion(root));
    System.out.println(postOrderWithIteration(root));
    System.out.println(postOrderWithIteration1(root));
    System.out.println("levelOrder------->");
    System.out.println(levelOrder(root));
  }

  private static BinaryTreeNode buildTree() {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.setLeft(new BinaryTreeNode(10));
    root.setRight(new BinaryTreeNode(3));
    root.getLeft().setLeft(new BinaryTreeNode(11));
    root.getRight().setLeft(new BinaryTreeNode(54));
    root.getRight().getLeft().setLeft(new BinaryTreeNode(41));
    root.getRight().getLeft().setRight(new BinaryTreeNode(21));
    root.getLeft().getLeft().setLeft(new BinaryTreeNode(24));
    root.getLeft().getLeft().getLeft().setLeft(new BinaryTreeNode(123));
    return root;
  }

  public static List<Integer> preOrderWithRecursion(BinaryTreeNode root) {
    List<Integer> res = new LinkedList<>();
    preOrderWithRecursion(root, res);
    return res;
  }

  private static void preOrderWithRecursion(BinaryTreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.getVal());
    preOrderWithRecursion(root.getLeft(), list);
    preOrderWithRecursion(root.getRight(), list);
  }

  public static List<Integer> preOrderWithIteration(BinaryTreeNode root) {
    Stack<BinaryTreeNode> stack = new Stack<>();
    List<Integer> res = new LinkedList<>();
    while (root != null || !stack.empty()) {
      while (root != null) {
        res.add(root.getVal());
        stack.push(root.getRight());
        root = root.getLeft();
      }
      // 右子结点
      root = stack.pop();
    }
    return res;
  }

  public static List<Integer> inOrderWithRecursion(BinaryTreeNode root) {
    List<Integer> res = new LinkedList<>();
    inOrderWithRecursion(root, res);
    return res;
  }

  private static void inOrderWithRecursion(BinaryTreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inOrderWithRecursion(root.getLeft(), res);
    res.add(root.getVal());
    inOrderWithRecursion(root.getRight(), res);
  }

  public static List<Integer> inOrderWithIteration(BinaryTreeNode root) {
    Stack<BinaryTreeNode> stack = new Stack<>();
    List<Integer> res = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.getLeft();
      }
      root = stack.pop();
      res.add(root.getVal());
      root = root.getRight();
    }
    return res;
  }

  public static List<Integer> postOrderWithRecursion(BinaryTreeNode root) {
    List<Integer> res = new LinkedList<>();
    postOrderWithRecursion(root, res);
    return res;
  }

  private static void postOrderWithRecursion(BinaryTreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    postOrderWithRecursion(root.getLeft(), res);
    postOrderWithRecursion(root.getRight(), res);
    res.add(root.getVal());
  }

  /**
   * 方法一：根->右->左 逆序即为 左->右->根
   */
  public static List<Integer> postOrderWithIteration(BinaryTreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        res.addFirst(root.getVal());
        stack.push(root.getLeft());
        root = root.getRight();
      }
      root = stack.pop();
    }
    return res;
  }

  /**
   * 方法二：用一个pre来记录被访问过的右子结点，避免重复访问
   */
  public static List<Integer> postOrderWithIteration1(BinaryTreeNode root) {
    List<Integer> res = new LinkedList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    // 记录上一个被访问的结点
    BinaryTreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      // 顺序 左 右 根  所以先把左遍历完
      while (root != null) {
        stack.push(root);
        root = root.getLeft();
      }
      root = stack.pop();
      // 如果当前结点的右子结点为空或者被访问过，则访问当前结点 即 根
      if (root.getRight() == null || pre == root.getRight()) {
        res.add(root.getVal());
        pre = root;
        // 下一次循环会从栈中弹出上一个节点
        root = null;
      } else {
        // 右子结点未被访问，需要入栈等待访问
        stack.push(root);
        root = root.getRight();
      }
    }
    return res;
  }

  public static List<Integer> levelOrder(BinaryTreeNode root) {
    List<BinaryTreeNode> list = new LinkedList<>();
    List<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    list.add(root);
    int size = 1;
    while (!list.isEmpty()) {
      while (size > 0) {
        BinaryTreeNode node = list.remove(0);
        if (node.getLeft() != null) {
          list.add(node.getLeft());
        }
        if (node.getRight() != null) {
          list.add(node.getRight());
        }
        res.add(node.getVal());
        size --;
      }
      size = list.size();
    }
    return res;
  }
}
