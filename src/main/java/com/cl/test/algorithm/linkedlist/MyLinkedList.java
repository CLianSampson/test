package com.cl.test.algorithm.linkedlist;

import com.cl.test.algorithm.base.LinkedNode;
import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * 链表类
 * @author sampson chen
 * @date 2021年09月10日 9:33
 */
public class MyLinkedList {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        LinkedNode linkedList = createLinkedList(nums);
        printNode(linkedList);

        //linkedList = traversal(linkedList);
        linkedList = reverse(linkedList);
        printNode(linkedList);
    }

    public static void printNode(LinkedNode head){
        if (head == null){
            return;
        }

        do {
            System.out.println(head.valeue + ",");
            head = head.next;
        }while (head != null);
    }


    /**
     * 链表创建，注意头结点
     * @param nums 数组
     * @return 链表头结点
     */
    public static LinkedNode createLinkedList(int[] nums){
        if (nums.length == 0) return null;

        LinkedNode head = null;
        LinkedNode current = null;
        for (int val : nums) {
            if (head == null){
                head = new LinkedNode();
                current = head;
                current.valeue = val;
                continue;
            }

            LinkedNode node = new LinkedNode();
            node.valeue = val;

            current.next = node;
            current = node;
        }

        return head;
    }



    public static LinkedNode traversal(LinkedNode old){
        if (old == null) return null;

        LinkedNode head = null;
        LinkedNode current = null;

        LinkedNode next = null;

        while (old != null) {
            if (old == null){
                break;
            }
            System.out.println(old.valeue);

            if (null == current){
                current = old;

                head = old;

                old = old.next;
                current.next = null;
            }else {
                head = old;

                old = old.next;

                head.next = current;

                current = head;
            }
        }

        return head;
    }






    public static LinkedNode reverse(LinkedNode old){
        if (null == old){
            return null;
        }

        LinkedNode current = null;
        LinkedNode head = null;
        //中间变量存储第二次循环遍历后的值, 用来赋值给current
        LinkedNode temp = null;

        while (old != null){
            if (current == null){
                current = old;
                head = current;

                old = old.next;
                current.next = null;
            }else {

                temp = old;

                head = old;

                old = old.next;
                head.next = current;

                current = temp;

            }
        }

        return head;
    }
















}
