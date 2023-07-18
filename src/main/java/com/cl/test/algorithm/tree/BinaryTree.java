package com.cl.test.algorithm.tree;

import com.cl.test.algorithm.base.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 *

     *        0
     *      /   \
     *     1     2
     *    / \   /  \
     *   3   4 5    6
     *  /            \
     * 7              8
 *    /                \
 *   9                  10
 * @author chenlian
 * @version 1.0
 * @date 2023/7/12 17:35
 */
@Slf4j
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode head = init();


        //prefixTraversal(head);
        //suffixTraversal(head);
        //middleTraversal(head);

        //prefixNoRecursion(head);
        //middleNoRecursion(head);
        //suffixNoRecursion(head);

        //reverse(head);
        //reverseNoRecursion(head);

        //prefixTraversal(head);

        levelTraversal(head);
        levelTraversalPer(head);
        log.info("最小深度是:{}",minDepth(head));
        log.info("最大深度是:{}",maxDepth(head));
    }




    public static void prefixTraversal(TreeNode head){
        if (head == null){
            return;
        }
        log.info(head.value + "\n");
        prefixTraversal(head.left);
        prefixTraversal(head.right);

    }


    public static void suffixTraversal(TreeNode head){
        if (head == null){
            return;
        }

        suffixTraversal(head.left);
        suffixTraversal(head.right);

        log.info(head.value + "\n");
    }


    public static void middleTraversal(TreeNode head){
        if (head == null){
            return;
        }

        middleTraversal(head.left);
        log.info(head.value + "\n");
        middleTraversal(head.right);

    }



    public static void prefixNoRecursion(TreeNode head){
        if (head == null){
            return;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(head);
        while (!stack.empty()){

            TreeNode current = stack.pop();
            log.info(current.value + "\n");
            if (current.right != null){
                stack.push(current.right);
            }

            if (current.left != null){
                stack.push(current.left);
            }
        }
    }






    public static void middleNoRecursion(TreeNode head){
        if (head == null){
            return;
        }

        List<TreeNode> duplicateList = new ArrayList<>(4);

        Stack<TreeNode> stack = new Stack();
        TreeNode current = head;

        stack.push(current);

        while (current != null || !stack.isEmpty()){

            while (current.left != null){
                stack.push(current.left);
                current = current.left;
            }

            current = stack.pop();
            if (!duplicateList.contains(current)) {
                duplicateList.add(current);
                log.info(current.value + "\n");
            }
            if (current.right != null){
                stack.push(current.right);
                current = current.right;
            }
        }
    }




    public static void suffixNoRecursion(TreeNode head){
        if (head == null){
            return;
        }

        //返回数据
        Stack<TreeNode> result = new Stack<>();

        Stack<TreeNode> stack = new Stack();
        stack.push(head);
        while (!stack.empty()){

            TreeNode current = stack.pop();
            log.info(current.value + "\n");
            result.push(current);
            if (current.left != null){
                stack.push(current.left);
            }

            if (current.right != null){
                stack.push(current.right);
            }
        }

        while (!result.empty()){
            log.info(result.pop().value + "\n");
        }

    }



    public static void reverse(TreeNode head){
        if (head == null){
            return;
        }

        //已经将左右交换了
        TreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;

        reverse(head.left);
        reverse(head.right);
    }


    public static void reverseNoRecursion(TreeNode head){
        if (head == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.empty()){
            TreeNode current = stack.pop();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }

    public static void levelTraversal(TreeNode head){
        if (head == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            log.info("当前节点:{}",current.value);

            if (current.left != null){
                queue.offer(current.left);
            }

            if (current.right != null){
                queue.offer(current.right);
            }
        }
    }


    public static void levelTraversalPer(TreeNode head){
        if (head == null){
            return;
        }

        List<List<TreeNode>> totalList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            List<TreeNode> preList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                preList.add(current);

                if (current.left != null){
                    queue.offer(current.left);
                }

                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            totalList.add(preList);
        }

        log.info("层级遍历的数据:");
        for (List<TreeNode> list : totalList) {
            List<String> valueList = list.stream().map(o -> String.valueOf(o.value)).collect(Collectors.toList());
            log.info("数据:{}",String.join(",",valueList));
        }
    }


    public static int minDepth(TreeNode head){
        if (head == null){
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left == null){
                    return depth;
                }else {
                    queue.offer(current.left);
                }

                if (current.right == null){
                    return depth;
                }else {
                    queue.offer(current.right);
                }
            }
        }

        return depth;
    }


    public static int maxDepth(TreeNode head){
        if (head == null){
            return 0;
        }

        int leftDepth = maxDepth(head.left) + 1;
        int rightDepth = maxDepth(head.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }


    private static TreeNode init() {
        TreeNode head = new TreeNode();
        head.value  = 0;

        TreeNode one = new TreeNode();
        one.value = 1;

        TreeNode two = new TreeNode();
        two.value = 2;

        TreeNode three = new TreeNode();
        three.value = 3;

        TreeNode four = new TreeNode();
        four.value = 4;

        TreeNode five = new TreeNode();
        five.value = 5;

        TreeNode six = new TreeNode();
        six.value = 6;

        TreeNode seven = new TreeNode();
        seven.value = 7;

        TreeNode eight = new TreeNode();
        eight.value = 8;

        TreeNode nine = new TreeNode();
        nine.value = 9;

        TreeNode ten = new TreeNode();
        ten.value = 10;

        head.left = one;
        head.right = two;

        one.left = three;
        one.right = four;

        two.left = five;
        two.right = six;

        three.left = seven;

        seven.left = nine;

        six.right = eight;
        eight.right = ten;

        return head;
    }

}