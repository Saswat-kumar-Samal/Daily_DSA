package Daily_DSA.LinkedList;

class Node{
    int data;
    Node next;
    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class BasicUnderStanding {
    /// this function is converting the Array to LinkedList
    static Node ConvertToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<=arr.length-1; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    ///  Traversing in the LinkedList
    /// time - O(n)
    static void TraversingLinkedList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+ " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    ///  finding the length of a LinkedList
    /// time - O(n)
    static int LengthOfLinkedList(Node head){
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }


    /// search in a LinkedList
    /// time - O(n)
    static String SearchInLinkedList(Node head, int val){
        Node temp = head;
        while(temp != null){
            if (temp.data == val) return "yes";
            temp = temp.next;
        }
        return "No";
    }

    public static void main(String[] args) {
        int[] arr = {12,15,19,5,16,45};
        Node head = ConvertToLinkedList(arr);
        //System.out.println(head.data);
        //TraversingLinkedList(head);
        //System.out.println(LengthOfLinkedList(head));
        System.out.println(SearchInLinkedList(head, 56));
    }
}
