
import java.util.Objects;

class linkedlist {

    static int state;
    linkedListNode nodeHead;
    public static void input(linkedlist list, String word){
        linkedListNode New_node = new linkedListNode(word);
        New_node.Next = null;

        if(list.nodeHead == null){
            list.nodeHead = New_node;
        }
        else{
            linkedListNode last = list.nodeHead;
            while(last.Next != null){
                last = last.Next;
            }
            last.Next = New_node;
        }
    }
    public static void checkPositiveWord(linkedlist list, String word){
        linkedListNode currentNode = list.nodeHead;
        while (currentNode != null) {
            if (Objects.equals(word, currentNode.text)) {
                state = 100;
                return;
            }
            currentNode = currentNode.Next;
        }
    }
    public static void checkNegativeWord(linkedlist list, String word){
        linkedListNode currentNode = list.nodeHead;
        while (currentNode != null) {
            if (Objects.equals(word, currentNode.text)) {
                state = 200;
                return;
            }
            currentNode =currentNode.Next;
        }
    }
    public static void checkNegationWord(linkedlist list, String word){
        linkedListNode currentNode = list.nodeHead;
        while (currentNode != null) {
            if (Objects.equals(word, currentNode.text)) {
                state = state +50;
                return;
            }
            currentNode =currentNode.Next;
        }
    }
}


