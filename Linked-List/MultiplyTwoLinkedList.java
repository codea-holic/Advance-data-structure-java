import java.util.*;

public class MultiplyTwoLinkedList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
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
    
    static int multiplierCount = 0;
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
        
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        
        ListNode head = new ListNode(-1);
        ListNode itr = head;
        
        int carry = 0;
        
        while(c1 != null || c2 != null || carry != 0){
            
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);
            
            int ld = sum % 10;
            carry = sum / 10;
            
            itr.next = new ListNode(ld);
            itr = itr.next;
            
            
            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }
        
        return reverse(head.next);
    }

    public static ListNode multiplyWithSingleDigit(ListNode l1, int d){
        
        if(l1 == null || d == 0) return new ListNode(0);
        
        ListNode c1 = l1;
        ListNode head = new ListNode(-1);
        ListNode itr = head;
        
        int carry = 0;
        while(c1 != null){
            int mul = carry + c1.val * d ;
            
            int ld = mul % 10;
            carry = mul / 10;
            
            itr.next = new ListNode(ld);
            itr = itr.next;
            
            c1 = c1.next;
        }
        
        if(carry != 0){
            itr.next = new ListNode(carry);
        }
        
        return reverse(head.next);
    }
    
    public static ListNode adjustResult(ListNode l1){
        
        if(multiplierCount == 0){
            multiplierCount++;
            return l1;
        }
            
        
        ListNode itr = l1;
        // this is used to reach at the end of Linked List
        while(itr.next != null){
            itr = itr.next;
        }
        
        int c = multiplierCount;
        // System.out.println(c);
        while(c-- > 0){
            // System.out.println("itrerator val = " + itr.val);
            ListNode node = new ListNode(0);
            itr.next = node;
            itr = itr.next;
        }

        multiplierCount++;
        // System.out.println(multiplierCount);
        return l1;
    }
    
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        // handle corner cases
        if(l1 == null || l2 == null) return new ListNode(0);
        
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        
        ListNode res = null;
        
        while(c2 != null){
            int digit = c2.val;
            
            ListNode ansOfSingleDigit = multiplyWithSingleDigit(c1, digit);
            // System.out.println("After multiplication with " + digit);
            // printList(ansOfSingleDigit);
            
            if(digit == 0){
                multiplierCount++;
            } else{
                ansOfSingleDigit = adjustResult(ansOfSingleDigit);
                // System.out.println("After adjust of result with digit " + digit);
                // printList(ansOfSingleDigit);
            }
            
            res = addTwoNumbers(res, ansOfSingleDigit);
            // System.out.println("After addition of 2 numbers " + digit);
            // printList(res);
            c2 = c2.next;
        }
        
        return res;
    }
    

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

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
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}