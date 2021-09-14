package com.cl.test.algorithm.linkedlist;

import com.cl.test.algorithm.base.LinkedNode;

/**
 * 链表类
 * @author sampson chen
 * @date 2021年09月10日 9:33
 */
public class MyLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 链表创建，注意头结点
     * @param nums
     * @return
     */
    public LinkedNode createLinkedList(int[] nums){
        if (nums.length == 0) return null;

        LinkedNode head = null;
        for (int val : nums) {
            if (head == null){
                head = new LinkedNode();
            }
        }

        return null;
    }


}
