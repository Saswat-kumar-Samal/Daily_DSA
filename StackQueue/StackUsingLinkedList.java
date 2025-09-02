package Daily_DSA.StackQueue;

///  implementation of stack using the inked list

class StackNode{
    int val;
    StackNode next;
    StackNode(int val, StackNode next){
        this.val = val;
        this.next = next;
    }
}
public class StackUsingLinkedList {
    StackNode top = null;
    int CurSize = 0;

    ///  push operation
    public void push(int ele){
        StackNode newNode = new StackNode(ele, null);
        newNode.next = top;
        top = newNode;
        CurSize++;
    }

    ///  pop operation
    public int pop(){
        StackNode temp = top;
        top = top.next;
        temp.next = null;
        return temp.val;
    }


    ///  peek operation
    public int peek(){ return  top.val; }


    ///  print all the elements
    public void PrintAll(){
        StackNode temp = top;
        while (temp != null){
            System.out.print(temp.val + " -->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {

    }
}
