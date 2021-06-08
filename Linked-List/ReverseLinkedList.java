package LinkedList;
import java.util.*;

class ReverseLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
    	Stack<ListNode > stk = new Stack<ListNode> (); 
    	  
        // Push the elements of list to stack 
        ListNode ptr = head; 
        while (ptr.next != null) 
        { 
            stk.push(ptr); 
            ptr = ptr.next; 
        } 
      
        // Pop from stack and replace 
        // current nodes value' 
        head = ptr; 
        while (!stk.isEmpty())
        { 
            ptr.next = stk.peek(); 
            ptr = ptr.next; 
            stk.pop(); 
        } 
        ptr.next = null; 
          
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

        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
head = head.next;
        }
    }
}
