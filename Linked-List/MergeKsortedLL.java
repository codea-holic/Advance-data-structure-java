import java.util.*;

class MergeKSortedLL {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKListSol(ListNode[] lists, int si, int ei) {
        if(si > ei) return null;
        if(si == ei){
            return lists[si];
        }
        // Write your code here
        // si -> start index
        // ei -> end index
        int mid = (si + ei) / 2;
        ListNode l1 = mergeKListSol(lists, si, mid);
        ListNode l2 = mergeKListSol(lists, mid + 1, ei);
        return MergeTwoLL(l1, l2);
    }
    
    public static ListNode mergeKLists(ListNode [] lists){
       return mergeKListSol(lists, 0, lists.length - 1);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    
    public static ListNode MergeTwoLL(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode prev = dummy;
        
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            } else{
                prev.next = c2;
                c2 = c2.next;
            }
            
            prev = prev.next;
        }
        
        prev.next = (c1 == null) ? c2 : c1;
        return dummy.next;
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}