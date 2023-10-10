public class Node {

    private String word;
    private Node next;
    private int size;


//    public Node() {
//        this.size = 0;
//    }

    public Node(String word) {
        this.word = word;
        this.size++;
    }

    public Node(String word, Node next) {
        this.word = word;
        this.next = next;
    }

}
