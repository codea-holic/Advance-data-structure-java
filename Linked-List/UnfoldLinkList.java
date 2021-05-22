import java.util.*;

class UnfoldLinkList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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
    
    public static void unfold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode fh = head; // first head
        ListNode sh = head.next; // second head
        
        ListNode fp = head;  // first prev
        ListNode sp = head.next;  // second prev
        
        while(sp != null && sp.next != null){
            // Back up
            ListNode f = sp.next;
            
            // Links
            fp.next = f;
            sp.next = f.next;
            
            // Move
            fp = f;
            sp = f.next;
        }
        fp.next = null;
        
        sh = reverse(sh);
        fp.next = sh;
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
        unfold(head);
        printList(head);
        scn.close();
    }
}