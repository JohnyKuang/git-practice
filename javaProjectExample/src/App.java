package javaProjectExample.src;

public class App {
    public static void main(String[] args) throws Exception {
        // testFile myTestFile = new testFile;
        // System.out.println(testFile.multiplyBy5(2));
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        
        ListNode midNode = new ListNode();
        midNode = middleNode(node1);

        System.out.println("Middle node: " + midNode.val);

    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast=head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
