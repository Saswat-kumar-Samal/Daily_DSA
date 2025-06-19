package Daily_DSA.LinkedList;
import java.util.*;

///  detecting loop in the linked list

public class DetectLoopInLL {
    ///  this is Brute Approach
    ///  overall time --> O(n)
    /// overall space --> O(n)
    static boolean BruteApproach(Node head){
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            if(map.containsKey(temp)){
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }


    ///  this is the Optimal solution by using the tortoise & hare
    ///  overall time --> O(n)
    /// overall space --> O(1)
    static boolean OptimalSolution(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
