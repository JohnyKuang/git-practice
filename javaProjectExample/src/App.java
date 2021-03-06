package javaProjectExample.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //// finding middle of linked list
         ListNode node5 = new ListNode(5);
         ListNode node4 = new ListNode(4, node5);
         ListNode node3 = new ListNode(3, node4);
         ListNode node2 = new ListNode(2, node3);
         ListNode node1 = new ListNode(1, node2);
         ListNode midNode = new ListNode();
         midNode = getMiddleNode(node1);
         System.out.println("Middle node: " + midNode.val);

        //// swap nodes in pairs
        // node1 = swapPairs(node1);
        // ListNode node = node1;
        // while (node != null) {
        // System.out.println(node.val);
        // node = node.next;
        // }

        //// merge two sorted lists

        //// reverse linked list
        // node1 = reverseList(node1);
        // while (node1 != null) {
        // System.out.println(node1.val);
        // node1 = node1.next;
        // }

        //// sorting squares of a sorted list
        // int[] sortedNums = {-4,-1,0,3,10};
        // sortedNums = sortedSquares(sortedNums);
        // for (int i : sortedNums) {
        // System.out.println(i);
        // }
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

        if (nums[nums.length - 1] >= 0) { // if whole list isn't negative
            while (nums[negPointer] < 0) {
                negPointer++;
            }
        }

        int posPointer = negPointer;
        negPointer--;
        int resultPointer = 0;

        // merge neg and positive sides
        while ((0 <= negPointer) && (posPointer < numsLen)) {
            if (Math.abs(nums[negPointer]) <= Math.abs(nums[posPointer])) {
                result[resultPointer] = nums[negPointer] * nums[negPointer];
                negPointer--;
            } else {
                result[resultPointer] = nums[posPointer] * nums[posPointer];
                posPointer++;
            }
            resultPointer++;
        }

        // append the rest
        if (0 <= negPointer) {
            while (0 <= negPointer) {
                result[resultPointer] = nums[negPointer] * nums[negPointer];
                negPointer--;
                resultPointer++;
            }
        } else {
            while (posPointer < numsLen) {
                result[resultPointer] = nums[posPointer] * nums[posPointer];
                posPointer++;
                resultPointer++;
            }
        }
        return result;
    }

    // public static ListNode swapPairs(ListNode head) {
    // if (head == null) {
    // return null;
    // }
    // if (head.next == null){
    // return head;
    // }
    // ListNode nextPairHead = head.next.next;
    // ListNode nextElem = head.next;
    // nextElem.next = head;
    // head.next = swapPairs(nextPairHead);
    // return nextElem;
    // }

    // public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // if (l1 == null) {
    // return l2;
    // }
    // if (l2 == null){
    // return l1;
    // }
    // if (l1.val <= l2.val) {
    // l1.next = mergeTwoLists(l1.next, l2);
    // return l1;
    // } else{
    // l2.next = mergeTwoLists(l1, l2.next);
    // return l2;
    // }
    // }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public int search(int[] nums, int target) {// search rotated sorted array
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public int searchHelper(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] <= nums[mid]) { // left half sorted
            if (nums[start] <= target && target <= nums[mid]) {
                return searchHelper(nums, target, start, mid - 1);
            } else {
                return searchHelper(nums, target, mid + 1, end);
            }
        } else {
            if (nums[mid] <= target && target <= nums[end]) {
                return searchHelper(nums, target, mid + 1, end);
            } else {
                return searchHelper(nums, target, start, mid - 1);
            }
        }
    }

    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return climbStairsHelper(n, memo);
    }

    public int climbStairsHelper(int n, HashMap<Integer, Integer> memo) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo));

        return memo.get(n);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> previousSets = subsets(Arrays.copyOfRange(nums, 0, nums.length - 1));
        List<List<Integer>> newSets = new ArrayList<>();
        if (previousSets.isEmpty()) {
            previousSets.add(new ArrayList<>());
        }

        for (List<Integer> set : previousSets) {
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(nums[nums.length - 1]);
            newSets.add(newSet);
        }
        List<List<Integer>> resultSet = new ArrayList<>(previousSets);
        resultSet.addAll(newSets);
        return resultSet;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1p = m - 1;
        int num2p = n - 1;
        int num1ResultP = nums1.length - 1;
        while (0 <= num1p && 0 <= num2p) {
            if (nums1[num1p] < nums2[num2p]) {
                nums1[num1ResultP] = nums2[num2p--];
            } else {
                nums1[num1ResultP] = nums1[num1p--];
            }
            num1ResultP--;
        }
        // append the rest
        if (num1p < 0) {
            while (0 <= num2p) {
                nums1[num1ResultP--] = nums2[num2p--];
            }
        } else {
            while (0 <= num1p) {
                nums1[num1ResultP--] = nums1[num1p--];
            }
        }
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) { // -1 means imbalanced
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left != null) {
            return minDepth(root.left) + 1;
        } else {
            return minDepth(root.right) + 1;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        // first do inorder traversal to get an array and then make a new tree from that
        // array
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        TreeNode newRoot = new TreeNode(), current = newRoot;
        for (Integer v : vals) {
            current.right = new TreeNode(v);
            current = current.right;
        }
        return newRoot.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] total = new int[nums.length];
        total[0] = nums[0];
        if (nums[0] <= nums[1]) {
            total[1] = nums[1];
        } else {
            total[1] = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (total[i - 2] + nums[i] <= total[i - 1]) {
                total[i] = total[i - 1];
            } else {
                total[i] = total[i - 2] + nums[i];
            }
        }
        return total[total.length - 1];
    }

    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 != 0) {
                    j += 2;
                }
                // swap
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

}
