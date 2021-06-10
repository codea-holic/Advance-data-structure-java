import java.util.*;

public class Segregate01BySwapDate {
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
        
        ListNode zero =  head;
        // ListNode one = head;
        ListNode curr =  head;
        
        while(curr != null){
            
            if(curr.val == 0){
                if(zero != curr){
                    swap(zero, curr);
                }
                zero = zero.next;
                curr = curr.next;
            }else{
                curr = curr.next;
            }
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