package Daily_DSA.LinkedList;

///  delete the nth node from the back of the linked list

public class DeleteNthNodeFromBack {
    /// this is the naive approach
    /// overall time --> O(len) + O(len - n) nearly O(2 * len)     len -> length of the LinkedList
    /// overall space --> O(1)
    static Node NaiveSolution(Node head, int n){
        if(head == null) return null;
        if(head.next == null){
            if(n == 1) return null;
            else return head;
        }
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        if(cnt == n){
            Node newHead = head.next;
            return newHead;
        }
        temp = head;
        int rem = cnt-n;
        while(temp != null){
            rem--;
            if(rem == 0){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }



    ///  this is the Optimal Solution
    /// overall time --> O(len)   len -> length of the LinkedList
    /// overall space --> O(1)
    static Node OptimalSolution(Node head, int n){
        if(head == null) return null;
        if(head.next == null){
            if(n == 1) return null;
            else return head;
        }
        Node fast = head;
        for(int i=1; i <= n; i++) fast = fast.next;
        Node slow = head;
        if(fast == null){
            Node newHead = head.next;
            return newHead;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {

    }
}
