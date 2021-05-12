package ETC.ReverseLinkedList;

import model.ListNode;

public class ReverseLinkedList {
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode curr = null;
        ListNode result = null;
        while(l1 != null){
            curr = l1.next;
            l1.next = result;
            result = l1;
            l1 = curr;
        }

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
