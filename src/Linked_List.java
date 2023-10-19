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
    public void search(String word){
        Node temp = head;

        while(temp != null){
            if(!temp.getWord().equals(word)) {
            }else
                System.out.println(temp.getWord());
            temp = temp.getNext();
        }
        System.out.println(word + " not Found");
    }



}
