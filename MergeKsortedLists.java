import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
 class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class MergeKsortedLists {

    public static ListNode makeList(int[] arr){
        if(arr.length==0)
                return null;

        ListNode head = new ListNode(arr[0],null);
        ListNode temp = head;
        for(int i=1;i<arr.length;i++){
            temp.next = new ListNode(arr[i],null);
            temp = temp.next;
        }
        return head;
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (node1,node2) -> node1.val - node2.val
        );

        ListNode ans = null;
        ListNode temp = null;
        for(int i=0;i< lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            if(ans==null){
                ans = top;
                temp = top;
            }
            else if(top!=null){
                temp.next = top;
                temp = temp.next;
            }
            if(top.next!=null)
                pq.add(top.next);
        }
        return ans;

    }
    public static void print(ListNode head){
        System.out.println("sorted nodes");
        while(head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();

    }
    public static void main(String[] args) {
            ListNode[] input1 = new ListNode[]{
                                makeList(new int[]{1,4,5}),
                                makeList(new int[]{1,3,4}),
                                makeList(new int[]{2,6})
                                };
            ListNode head = mergeKLists(input1);
            print(head);

    }
}
