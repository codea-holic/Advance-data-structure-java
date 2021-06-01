import java.util.*;

public class IntersectionNodeUsingDifferenceMethod {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static int lengthOfLL(ListNode head){
        if(head == null) return 0;
        if(head.next == null) return 1;
        
        ListNode ptr = head;
        int length = 0;
        while(ptr != null){
            length++;
            ptr = ptr.next;
        }
        
        return length;
    }
    
    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int lenA = lengthOfLL(headA);
        // System.out.println(lenA);
        int lenB = lengthOfLL(headB);
        // System.out.println(lenB);
        
        ListNode ptr1 = null, ptr2 = null;
        
        if(lenA > lenB){
            
            ptr1 = headA;
            ptr2 = headB;
            
        } else{
            
            ptr2 = headA;
            ptr1 = headB;
        }
        
        // System.out.println(pt)
        
        int diff = Math.abs(lenA - lenB);
        // System.out.println(diff);
        while(diff-- > 0){
            ptr1 = ptr1.next;
        }
        
        while(ptr1 != null && ptr2 != null){
            
            if(ptr1 == ptr2) return ptr1;
            // System.out.println("ptr1 data " +ptr1.val);
            ptr1 = ptr1.next;
            // System.out.println("ptr2 data " + ptr2.val);
            ptr2 = ptr2.next;
        }
        
        return null;
    }

    // Input_code===================================================

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}