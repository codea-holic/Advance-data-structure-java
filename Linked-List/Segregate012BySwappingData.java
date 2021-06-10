import java.util.*;

public class Segregate012BySwappingData {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static void swap(ListNode l1, ListNode l2){
      int temp = l1.val;
      l1.val = l2.val;
      l2.val = temp;
    }

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode zero = head;
        ListNode one = head;
        ListNode curr = head;

        // zero -> (one - 1) 0's
        // one  -> (curr - 1) 1's
        // curr -> end : unknown
        // After one -> 2's
        while(curr != null){
          if(curr.val == 0){
            if(zero != curr) swap(zero,curr);
            if(zero == one) one = one.next;
            zero = zero.next;
          } 
          if(curr.val == 1){
            if(one != curr) swap(one, curr);
            one = one.next;
          } 
          curr = curr.next;
        }
        return head;
    }
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate012(h1);
        printList(h1);
    }
}