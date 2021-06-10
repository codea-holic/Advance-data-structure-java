import java.util.*;

// Time complexity -> O(n)
public class Segregate012BySwappingNodes {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy0 = new ListNode(-1);
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        ListNode zero = dummy0;
        ListNode one = dummy1;
        ListNode two = dummy2;
        
        while(head != null){
            
            if(head.val == 0){
                zero.next = head;
                zero = zero.next;
            } else if(head.val == 1){
                one.next = head;
                one = one.next;
            } else{
                two.next = head;
                two = two.next;
            }
            head = head.next;
        }
        
        // zero.next = null;
        // one.next = null;
        two.next = null;
        
        one.next = dummy2.next;
        zero.next = dummy1.next;
        
        return dummy0.next;
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