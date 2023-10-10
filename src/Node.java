public class Node {

    private String word;
    private Node next;
    private Node head;
    private Node tail;
    private int size;

    public Node() {
        this.size = 0;
    }

    public Node(String word) {
        this.word = word;
     }

    public Node(String word, Node next) {
        this.word = word;
        this.next = next;
    }

}
