package Daily_DSA.LinkedList;


/// Add two given linked list

public class AddTwoLinkedList {
    /// this is the Optimal approach
    /// overall time --> O( max(n1, n2) )   n1 - len of linked list 1 , n2 - len of linked list 2
    /// overall space --> O ( max(n1, n2) )  for storing the result only not for solving the problem
    static Node OptimalSolution(Node head1, Node head2){
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        int carry = 0;
        int sum = 0;
        Node t1 = head1;
        Node t2 = head2;
        while(t1 != null || t2 != null){
            sum = carry;
            if(t1 != null) sum += t1.data;
            if(t2 != null) sum += t2.data;
            Node newNode = new Node(sum % 10);
            carry = (sum < 10) ? 0 : 1;
            curr.next = newNode;
            curr = curr.next;
            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }
        if(carry == 1){
            Node newNode = new Node(1);
            curr.next = newNode;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {

    }
}
