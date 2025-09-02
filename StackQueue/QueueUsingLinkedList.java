package Daily_DSA.StackQueue;


///  implementing Queue using linked list

class QueueNode{
    int val;
    QueueNode next;
    QueueNode(int val, QueueNode next){
        this.val = val;
        this.next = next;
    }
}
public class QueueUsingLinkedList {
    QueueNode start = null, end = null;
    int CurSize = 0;
    ///  push operation
    public void  push(int ele){
        QueueNode newNode = new QueueNode(ele,null);
        if (start == null){
            start = end = newNode;
        }else{
            end.next = newNode;
            end = newNode;
        }
        CurSize++;
    }


    ///  pop operation
    public int pop(){
        if (start == null){
            System.out.println("we do not have any thing");
            return -1;
        }
        QueueNode temp = start;
        start = start.next;
        temp.next = null;
        CurSize--;
        return temp.val;
    }


    ///  peek operation
    public int peek(){
        return start.val;
    }
    public static void main(String[] args) {

    }
}
