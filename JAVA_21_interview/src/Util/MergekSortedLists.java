package Util;

public class MergekSortedLists {

    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }



    private Node divideAndConquer(Node[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;
        Node l1 = divideAndConquer(lists, left, mid);
        Node l2 = divideAndConquer(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    public  Node mergeKLists(Node[] lists) {
        if (lists.length == 0) return null;
        return divideAndConquer(lists, 0, lists.length - 1);
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MergekSortedLists sc=new MergekSortedLists();
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next=new Node(3);
        head2.next.next=new Node(4);
        Node head3 = new Node(2);
        head3.next=new Node(6);
        Node [] list=new Node[]{
                head,head2,head3
        };

        Node node = sc.mergeKLists(list);
        printList(node);
        System.out.println(node);


    }
}
