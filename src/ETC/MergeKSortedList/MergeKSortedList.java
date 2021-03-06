package ETC.MergeKSortedList;

import model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        MergeKSortedList a = new MergeKSortedList();
        ListNode result = a.mergeKLists(list);
        while(result !=null) {
            System.out.println(result.val);
            result= result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists){
        ListNode newHead = new ListNode(0);

//        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val - b.val));
        ListNode p = newHead;

        for (ListNode node: lists){
            if (node != null)
                queue.offer(node);
        }

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null)
                queue.offer(node.next);
        }
        return newHead.next;
    }

    Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };
}
