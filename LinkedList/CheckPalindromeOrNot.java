package Daily_DSA.LinkedList;

import java.util.Stack;

///  check the linked list is palindrome or not


public class CheckPalindromeOrNot {
    ///  this is the Brute approach
    /// overall time --> O(2n)
    /// overall space --> O(n)
    static boolean BruteApproach(Node head){
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (!st.isEmpty()){
            if (temp.data != st.pop()) return false;
            temp = temp.next;
        }
        return true;
    }



    /// this is the Optimal Solution
    /// overall time --> O(2n)
    /// overall space --> O(1)
    static boolean OptimalApproach(Node head){
        if(head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = ReverseLL(slow.next);
        Node left = head, right = newHead;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    static Node ReverseLL(Node head){
        if(head == null) return null;
        if(head.next == null) return head;
        Node prev = null;
        Node temp = head;
        Node front = temp.next;
        while(front != null){
            temp.next = prev;
            prev = temp;
            temp = front;
            front = front.next;
        }
        temp.next = prev;
        return temp;
    }
    public static void main(String[] args) {

    }
}
