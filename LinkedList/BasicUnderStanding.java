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


    ///  Deleting the nodes from the LinkedList

    /// removing the head of the LinkedList
    static Node removeHead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }


    ///  remove the tail of the LinkedList
    static Node removeTail(Node head){
        if (head == null || head.next == null) return head;
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
        return head;
    }


    ///  removing the kth element in the LinkedList
    /// time -> O(k)  no of k it will run
    static Node removeKthElement(Node head, int k){
        if (head == null) return head;
        if (k == 1){
            head = head.next;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null){
            cnt++;
            if (cnt == k){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    ///  delete the node by value
    /// time - O(n)
    static Node removeNodeByValue(Node head, int val){
        if (head == null) return head;
        if (head.data == val){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null){
            if (temp.data == val){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }



    ///  inserting nodes in the linkedList

    /// inserting in the head of the LinkedList
    static Node InsertHead(Node head, int val){
        Node temp = new Node(val, head);
        return temp;
    }



    /// adding the element in the last of the LinkedList
    static Node InsertLast(Node head, int val){
        if (head == null){
            return new Node(val);
        }
        Node newNode = new Node(val);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }


    /// inserting at given Kth position
    static Node InsertAtKthPos(Node head, int val ,int k){
        if (head == null){
            if (k == 1){
                return new Node(val);
            }else{
                return head;
            }
        }
        if (k == 1){
            return InsertHead(head, val);
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            cnt++;
            if (cnt == k-1){
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }



    ///  insert the value before the value 'val'
    static Node InsertBeforeVal(Node head, int ele, int val){
        if (head == null){
            return null;
        }
        if (head.data == val){
            return new Node(ele, head);
        }
        Node temp = head;
        while (temp.next != null){
            if (temp.next.data == val){
                Node newNode = new Node(ele, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {12,15,19,5,16,45};
        Node head = ConvertToLinkedList(arr);
        //System.out.println(head.data);
        TraversingLinkedList(head);
        //System.out.println(LengthOfLinkedList(head));
        //System.out.println(SearchInLinkedList(head, 56));
        //System.out.println(removeHead(head).data);
        //head = removeHead(head);
        //TraversingLinkedList(removeTail(head));
        head = InsertBeforeVal(head, 100,12);
        TraversingLinkedList(head);

    }
}
