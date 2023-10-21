public class Linked_List {
    private Node head;
    private int size;



    public Linked_List() {
        this.size = 0;
    }
    public void add(String word) {
        Node temp = head;

        if (search(word) == 0){
            Node node = new Node(word);
            node.setOccurrence(1);
            node.setNext(head);
            head = node;
            size++;
        }else {
            if(head.getWord().equals(word)) {
                head.setOccurrence(head.getOccurrence() +1);
                }
            head = temp;
        }

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
                occurrence = temp.getOccurrence();
            }
            temp = temp.getNext();
        }
        return occurrence;
    }
    public void delete(String word){

        if(search(word) == 0) {
            System.out.println(word + " not found");
            return;
        }
        Node firstNode = head;
        while(head != null){

            if(head.getWord().equals(word)) { // checks first node for word
                head.setOccurrence(head.getOccurrence()-1);
                head = head.getNext();
                firstNode = head;
                size--;
            } else if (head.getNext().getNext() == null && head.getNext().getWord().equals(word)) {  // condition if second to last and last Node.word is "word"
                head.setNext(null);   // deletes last element
                head.setOccurrence(head.getOccurrence()-1);
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
