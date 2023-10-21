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
            while(head != null) {
                if (head.getWord().equals(word)) {
                    head.setOccurrence(head.getOccurrence() + 1);
                }
                head = head.getNext();
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
                break;
            }
            temp = temp.getNext();
        }
        return occurrence;
    }
    public void delete(String word){
        Node firstNode = head;
        if(search(word) == 0) {
            System.out.println(word + " not found");
            return;
        }
        while(head != null){

            if(head.getWord().equals(word)) {
                if(search(word) > 1){
                    head.setOccurrence(head.getOccurrence()-1);
                    break;
                }
                head = head.getNext();
                firstNode = head; //saving new head into firstNode
                size--;
                break;

            } else if (head.getNext().getWord().equals(word)){
                if(search(word) > 1){
                    head.getNext().setOccurrence(head.getNext().getOccurrence()-1);
                    break;
                }
                head.setNext(head.getNext().getNext());
                size--;
                break;
            }
            head = head.getNext();
        }
        head = firstNode;

    }

}
