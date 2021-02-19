package javaProjectExample.src;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        //finding middle of linked list 
        // ListNode node5 = new ListNode(5);
        // ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);
        // ListNode midNode = new ListNode();
        // midNode = getMiddleNode(node1);
        // System.out.println("Middle node: " + midNode.val);

        //sorting squares of a sorted list
        int[] sortedNums = {-4,-1,0,3,10}; 
        sortedNums = sortedSquares(sortedNums);
        for (int i : sortedNums) {
            System.out.println(i);
        }
        // System.out.println(Arrays.toString(sortedNums));

    }
    public static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast=head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static int[] sortedSquares(int[] nums) {
        int numsLen = nums.length;
        int[] result = new int[numsLen];
        int negPointer = 0;

        if (nums[nums.length - 1] >= 0){  //if whole list isn't negative
            while (nums[negPointer] < 0) {
                negPointer ++;
            }
        }

        int posPointer = negPointer;
        negPointer --;
        int resultPointer = 0; 

        //merge neg and positive sides
        while ((0 <= negPointer) && (posPointer < numsLen)){
            if (Math.abs(nums[negPointer]) <= Math.abs(nums[posPointer])) {
                result[resultPointer] = nums[negPointer] * nums[negPointer];
                negPointer --;
            } else {
                result[resultPointer] = nums[posPointer] * nums[posPointer];
                posPointer ++;
            }
            resultPointer ++;
        }

        //append the rest
        if (0 <= negPointer) {
            while (0 <= negPointer) {
                result[resultPointer] = nums[negPointer] * nums[negPointer];
                negPointer --; 
                resultPointer ++;
            } 
        } else {
            while (posPointer < numsLen) {
                result[resultPointer] = nums[posPointer] * nums[posPointer];
                posPointer ++; 
                resultPointer ++;
            }
        }
        return result;
    }


    
}
