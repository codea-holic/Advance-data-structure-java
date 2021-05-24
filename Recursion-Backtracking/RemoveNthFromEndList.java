import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(n-- > 0){
            fast = fast.next;
            
            // prevent from null pointer exception when n > List size
            if(fast.next == null){
                if(n == 1) return head.next;
                else return null;
            }
        }
        
        while(fast != null){
            slow = slow.next;
            prev = prev.next;
            fast = fast.next;
        }
        
        prev.next = slow.next;
        
        return dummy.next;
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

        int m = scn.nextInt();
        removeNthFromEnd(h1, m);
        printList(h1);
    }
}