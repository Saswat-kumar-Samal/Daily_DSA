package Daily_DSA.LinkedList;
import java.util.*;

///  finding the starting node where the loop is happening

public class FindingTheStartingNode {
    /// this is the brute Approach
    /// overall time --> O(n)
    /// overall space --> O(n)
    static Node BruteApproach(Node head){
        if(head == null) return null;
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        while (temp != null){
            if (map.containsKey(temp)) return temp;
            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }


    ///  this is the Optimal Approach by tortoise and hare
    /// overall time --> O(n)
    /// overall space --> O(1)
    static Node OptimalApproach(Node head){
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
