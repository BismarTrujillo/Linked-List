public class Node {

    private String word;
    private Node next;
    private int occurrence;


    public Node(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
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

