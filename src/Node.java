public class Node {

    private String word;
    private Node next;
    private int occurrence;


    public Node(String word) {
        this.word = word;
    }

    public Node(String word, Node next) {
        this.word = word;
        this.next = next;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }
}

