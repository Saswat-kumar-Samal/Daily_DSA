package Daily_DSA.LinkedList;
import java.util.ArrayList;
///  segregating odd and even nodes in the linked list

public class SegregateOddEven {
    ///  this is the Naive Solution
    /// overall time -->  O(2n)
    /// overall space --> O(n)
    static Node NaiveApproach(Node head){
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null && temp.next != null){   //---- O(n/2)
            list.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) list.add(temp.data);
        temp = head.next;
        while(temp != null && temp.next != null){ //----> O(n/2)
            list.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) list.add(temp.data);
        int i=0; temp = head;
        while(temp != null){                   // -----> O(n)
            temp.data = list.get(i++);
            temp = temp.next;
        }
        return head;
    }




    /// this is the Optimal solution
    /// overall time --> O(n)
    /// overall space --> O(1)
    static Node OptimalSolution(Node head){
        if(head == null) return null;
        if(head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node backup = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = backup;
        return head;
    }
    public static void main(String[] args) {

    }
}
