import java.util.*;
public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static void AddFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            newNode = head;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static Node convertArr2ll(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    private static int LengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    //remove first
    public static Node removeHead(Node head) {
        if(head == null) {
            return null;
        }
        head = head.next;
        return head;
    }
    //remove last
    public static Node removeLast(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    //remove kth ele
    public static Node removeKth(Node head, int k) {
        if(head == null) return head;
        if(k == 1) {
            head = head.next;
            return head;
        }
        int count = 1;
        Node temp = head;
        Node prev =  null;
        while(temp != null) {
            count++;
            if(count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    //remove node by their value
    public static Node removeEle(Node head, int val) {
        if(head == null) return head;
        if(head.data == val) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev =  null;
        while(temp != null) {
            if(temp.data == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = {12, 10, 5, 4};
        Node head = convertArr2ll(arr);
        print(head);
    }
}