package Daily_DSA.LinkedList;

///  finding the middle of the LinkedList


public class MiddleOfLL {
    /// this is the brute force approach
    /// overall time -> O(n) + O(n/2)
    /// overall space -> O(1)
    static Node BruteForce(Node head){
        int n = BasicUnderStanding.LengthOfLinkedList(head);  // time -> O(n)
        System.out.println("length is :- "+n);
        int midNode = (n/2)+1;
        Node temp = head;
        while (temp != null){                // time -> O(n/2)
            midNode--;
            if (midNode == 0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }


    ///  this is the Optimal approach with algo called tortoise & hare
    /// this algo is based on slow and fast pointer , slow pointer will move 1 step and fast pointer will move 2 steps
    /// overall time --> O(n/2)
    /// overall space --> O(1)
    static Node OptimalSolution(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = BasicUnderStanding.ConvertToLinkedList(arr);
        System.out.println(OptimalSolution(head).data);
    }
}
