package Daily_DSA.LinkedList.DoublyLinkedList;

import org.w3c.dom.Node;

class NodeDoubly{
    int data;
    NodeDoubly next;
    NodeDoubly prev;
    NodeDoubly(int data, NodeDoubly next, NodeDoubly prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    NodeDoubly(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}



public class DoublyLinkedListBasic{
    static NodeDoubly ConvertToDoublyLinkedList(int[] arr){
        NodeDoubly head = new NodeDoubly(arr[0]);
        NodeDoubly prev = head;
        for (int i = 1; i<=arr.length-1; i++){
            NodeDoubly temp = new NodeDoubly(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    static void PrintDLL(NodeDoubly head){
        System.out.print("null --> ");
        while (head != null){
            System.out.print(head.data + " --> ");
            head = head.next;
        }
        System.out.println("null");
    }



    // deletion of nodes in doubly linked list

    static NodeDoubly DeleteHead(NodeDoubly head){
        if (head == null || head.next == null) return null;
        NodeDoubly temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    }

    static NodeDoubly DeleteTail(NodeDoubly head){
        if (head == null || head.next == null) return null;
        NodeDoubly temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
        return head;
    }

    static NodeDoubly DeleteKthElement(NodeDoubly head, int k){
        if (head == null || head.next == null) return null;
        NodeDoubly temp = head;
        int cnt = 0;
        while (temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        NodeDoubly backEle = temp.prev;
        NodeDoubly front = temp.next;
        if (backEle == null && front == null) return null;
        else if (backEle == null) return DeleteHead(head);
        else if (front == null) return DeleteTail(head);
        else {
            backEle.next = front;
            front.prev = backEle;
            temp.next = temp.prev = null;
        }
        return head;

    }

    static NodeDoubly DeleteGivenNode(NodeDoubly head, NodeDoubly node){
        NodeDoubly backEle = node.prev;
        NodeDoubly front = node.next;
        if (front == null) {
            backEle.next = front;
            node.prev = null;
            return head;
        }
        backEle.next = front;
        front.prev = backEle;
        node.next = node.prev = null;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {12,5,6,78,9,5};
        NodeDoubly head = ConvertToDoublyLinkedList(arr);
        PrintDLL(head);
        PrintDLL(DeleteKthElement(head, 3));
    }
}

