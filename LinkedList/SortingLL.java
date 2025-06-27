package Daily_DSA.LinkedList;
import java.util.*;

/// sorting the linked list

public class SortingLL {
    /// this is the Naive Approach
    /// overall time --> O(n) + O(n * log n) + O(n)
    /// overall space --> O(n)
    static Node NaiveSolution(Node head){
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            list.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        int i = 0;
        while(temp != null){
            temp.data = list.get(i++);
            temp = temp.next;
        }
        return head;
    }



    ///  this is the Optimal Approach by applying merge sort algorithm on linked list
    /// overall time --> O(log n * (n + n/2) )
    /// overall space --> O(1)
    static Node MergeTwoLL(Node leftHead, Node RightHead){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while(leftHead != null && RightHead != null){
            if(leftHead.data <= RightHead.data){
                temp.next = leftHead;
                leftHead = leftHead.next;
            }else{
                temp.next = RightHead;
                RightHead = RightHead.next;
            }
            temp = temp.next;
        }
        if(leftHead != null) temp.next = leftHead;
        else temp.next = RightHead;
        return dummyNode.next;
    }
    static Node OptimalSolution(Node head){
        if(head == null || head.next == null) return head;
        Node middle = FindMiddle(head);
        Node RightHead = middle.next;
        middle.next = null;
        Node leftHead = head;

        Node left = OptimalSolution(leftHead);
        Node right = OptimalSolution(RightHead);
        return MergeTwoLL(left, right);
    }
    static Node FindMiddle(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {

    }
}
