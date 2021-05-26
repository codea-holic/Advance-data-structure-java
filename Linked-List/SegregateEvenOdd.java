import java.util.*;

class segregateEvenOdd {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static void swap(ListNode node1, ListNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode even = head;
        ListNode odd = head;
        
        
        // Below code is segregate 0 to e even number and e to odd are odd
        while(odd != null){
            if(odd.val % 2 == 0){
                swap(odd, even);
                odd = odd.next;
                even = even.next;
            } else{
                odd = odd.next;
            }
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
    }
}