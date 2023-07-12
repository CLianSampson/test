package com.cl.test.algorithm.tree;

import com.cl.test.algorithm.base.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO 类功能描述
 *
 *        0
 *      /   \
 *     1     2
 *    / \   /  \
 *   3   4 5    6
 *
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
        middleTraversal(head);
    }




    public static void prefixTraversal(TreeNode head){
        if (head == null){
            return;
        }

        prefixTraversal(head.left);
        log.info(head.value + "\n");
        prefixTraversal(head.right);

    }


    public static void suffixTraversal(TreeNode head){
        if (head == null){
            return;
        }

        prefixTraversal(head.left);
        prefixTraversal(head.right);

        log.info(head.value + "\n");
    }


    public static void middleTraversal(TreeNode head){
        if (head == null){
            return;
        }

        log.info(head.value + "\n");

        prefixTraversal(head.left);
        prefixTraversal(head.right);

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

        head.left = one;
        head.right = two;

        one.left = three;
        one.right = four;

        two.left = five;
        two.right = six;

        return head;
    }

}