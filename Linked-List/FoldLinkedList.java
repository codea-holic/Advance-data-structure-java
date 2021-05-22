/* 
Question:- List-given: 1->2->3->4->5->6->7->null
Required-list:- 1->7->2->6->3->5->4->null
*/
import java.util.*;

class FoldLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // first one is for odd and second is for even
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = null;
        
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    
    public static void fold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        if(head.next.next == null){
            return;
        }
        
        ListNode mid = midNode(head);
        ListNode revHead = reverse(mid.next);
        mid.next = null;
        
        ListNode curr1 = head;
        ListNode curr2 = revHead;
        ListNode forw1 = null;
        ListNode forw2 = null;
        
        while(curr2 != null){
            
            //back up
            forw1 = curr1.next;
            forw2 = curr2.next;
            
            // Links
            curr1.next = curr2;
            curr2.next = forw1;
            
            // Move
            curr1 = forw1;
            curr2 = forw2;
        }
        
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}