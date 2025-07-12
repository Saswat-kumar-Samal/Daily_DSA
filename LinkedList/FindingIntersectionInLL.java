package Daily_DSA.LinkedList;
import java.util.*;


///  finding the intersection point of linked list

public class FindingIntersectionInLL {

    ///  this is the brute force approach
    /// overall time --> O(n1 + n2)
    /// overall space --> O(n1) or O(n2) depending upon which linked list you are storing
    static Node NaiveSolution(Node head1, Node head2){
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head1;
        while(temp != null){
            map.put(temp, 1);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null){
            if (map.containsKey(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }



    /// this is the Better solution
    /// overall time --> O(n1 + 2 * n2)
    /// overall space --> O(1)
    static Node BetterSolution(Node head1, Node head2){
        Node temp = head1; int n1 = 0;
        while (temp != null){
            n1++;
            temp = temp.next;
        }
        temp = head2; int n2 = 0;
        while (temp != null){
            n2++;
            temp = temp.next;
        }

        if(n1 <= n2){
            return CollisionPoint(head1, head2, n2-n1);
        }else{
            return CollisionPoint(head2, head1, n1-n2);
        }
    }
    static Node CollisionPoint(Node head1, Node head2, int dist){
        Node t1 = head1;
        Node t2 = head2;
        while (dist != 0){
            dist--;
            t2 = t2.next;
        }
        while (t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }



    /// this is the Optimal Solution
    /// overall time --> O(n1 + n2)
    /// overall space --> O(1)
    static Node OptimalSolution(Node head1, Node head2){
        if(head1 == null || head2 == null) return null;
        Node t1 = head1;
        Node t2 = head2;
        while (t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
            if (t1 == t2) return t1;
            if (t1 == null) t1 = head2;
            if (t2 == null) t2 = head1;
        }
        return t1;
    }
    public static void main(String[] args) {

    }
}
