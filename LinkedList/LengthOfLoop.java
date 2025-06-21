package Daily_DSA.LinkedList;
import java.util.*;

///  find the loop of in LinkedList if it is existed

public class LengthOfLoop {
    /// this is the BruteForce approach by using hashing
    /// overall time --> O(n)
    /// overall space --> O(n)
    static int BruteSolution(Node head){
        if (head == null || head.next == null) return 0;
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int cnt = 1;
        while (temp != null){
            if (map.containsKey(temp)){
                return cnt - map.get(temp);
            }
            map.put(temp, cnt);
            cnt++;
            temp = temp.next;
        }
        return 0;
    }


    ///  this is the Optimal Approach by using tortoise and hare
    /// overall time -->  nearly  O(2n)
    /// overall space --> O(1)
    static int OptimalApproach(Node head){
        if (head == null || head.next == null) return 0;
        Node slow = head;
        Node fast = head;
        int cnt = 1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return 0;
        slow = slow.next;
        while(slow != fast){
            cnt++;
            slow = slow.next;
        }
        return cnt;
    }
    public static void main(String[] args) {

    }
}
