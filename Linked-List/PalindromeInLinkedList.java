import java.util.*;

class PalindromeInLinkedList {
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

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode mid = midNode(head);
        ListNode rlist = reverse(mid.next);
        ListNode i = head;
        ListNode j = rlist;
        boolean flag = true;
        while(j != null){
            if(i.val != j.val){
                flag = false;
                break;
            }
            
            i = i.next;
            j = j.next;
        }
        
        // return the same list that we found from main function
        rlist = reverse(rlist);
        mid.next = rlist;
        
        return flag;
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

        System.out.println(isPalindrome(dummy.next));
    }
}