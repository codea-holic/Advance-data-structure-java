package OpenSourse;
import java.util.*;

class segregateEvenOdd {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
 

    public static ListNode segregateEvenOdd(ListNode head) {
    	ListNode odd = null, oddTail = null;
        ListNode even = null, evenTail = null;
        ListNode curr = head;
 
        while (curr != null)
        {
            if ((curr.val & 1) != 0)        // current node is odd
            {
                // handle head for the first odd node
                if (odd == null) {
                    odd = oddTail = curr;
                }
                else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            else    // current node is even
            {
                // handle head for the first even node
                if (even == null) {
                    even = evenTail = curr;
                }
                else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }
            curr = curr.next;
        }
 
        // if the list contains at least one even node
        if (even != null)
        {
            head = even;
            evenTail.next = odd;
        }
        // special case – list contains all odd nodes
        else {
            head = odd;
        }
 
        // null to terminate the list; otherwise, it will go into an infinite loop
        if (oddTail != null) {
            oddTail.next = null;
        }
 
        return head;
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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        scn.close();
    }
} 
