public class Linked_List {
    private Node head;
    private Node tail;
    private int size;



    public Linked_List() {
        this.size = 0;
    }
    public void add(String word) {
        Node node = new Node(word);
        node.setNext(head);
        head = node;
        size++;
    }
    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.getWord() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("END");
    }
    public int search(String word){
        Node temp = head;
        int occurrence = 0;

        while(temp != null){
            if(temp.getWord().equals(word)) {
                temp.setOccurrence(occurrence++);
            }
            temp = temp.getNext();
        }
        return occurrence;
    }
    public void delete(String word){
        Node firstNode = head;

        while(head != null){

            if(head.getWord().equals(word)) { // checks first node for word
                head = head.getNext();
                firstNode = head;
                size--;
            } else if (head.getNext().getNext() == null) { //  conditions checks if we are second to last if true
                head.setNext(null);                        // deletes last elemet
                size--;
            } else if (head.getNext().getWord().equals(word)){
                head.setNext(head.getNext().getNext());
                size--;
            }
            head = head.getNext();
        }
        head = firstNode;

    }

}
