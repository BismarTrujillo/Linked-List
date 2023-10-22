import java.util.Arrays;

public class Linked_List {
    private Node head;
    private int size;


    public Linked_List() {
        this.size = 0;
    }

    public void add(String word) {

        Node temp = head;

        if (search(word) == 0) {
            Node node = new Node(word);
            node.setOccurrence(1);
            node.setNext(head);
            head = node;
            size++;
        } else {
            while (head != null) {
                if (head.getWord().equals(word)) {
                    head.setOccurrence(head.getOccurrence() + 1);
                }
                head = head.getNext();
            }
            head = temp;
        }
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getWord() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("END");
    }

    public int search(String word) {
        Node temp = head;
        int occurrence = 0;

        while (temp != null) {
            if (temp.getWord().equals(word)) {
                occurrence = temp.getOccurrence();
                break;
            }
            temp = temp.getNext();
        }
        return occurrence;
    }

    public void delete(String word, Boolean forceDelete) {
        Node firstNode = head;

        if (search(word) == 0) {
            System.out.println(word + " not found");
            return;
        }

        while (head != null) {
            if (forceDelete) {
                if (head.getWord().equals(word)) {
                    head = head.getNext();
                    firstNode = head;
                    size--;
                    break;
                } else if (head.getNext().getWord().equals(word)) {
                    head.setNext(head.getNext().getNext());
                    size--;
                    break;
                }
                head = head.getNext();
            } else {
                if (head.getWord().equals(word)) {
                    if (search(word) > 1) {
                        head.setOccurrence(head.getOccurrence() - 1);
                        break;
                    }
                    head = head.getNext();
                    firstNode = head;
                    size--;
                    break;

                } else if (head.getNext().getWord().equals(word)) {
                    if (search(word) > 1) {
                        head.getNext().setOccurrence(head.getNext().getOccurrence() - 1);
                        break;
                    }
                    head.setNext(head.getNext().getNext());
                    size--;
                    break;
                }
                head = head.getNext();
            }
        }
        head = firstNode;
    }

    public void getHighestOccurrence() {
        Node temp = head;
        Node highestOccurrence = temp;

        if (temp == null) {
            System.out.println("Empty List");
        } else if (temp.getNext() == null) {
            System.out.println(temp.getWord() + " " + temp.getOccurrence());
        } else {
            while (temp != null) {
                if (temp.getOccurrence() > highestOccurrence.getOccurrence()) {
                    highestOccurrence = temp;
                }
                temp = temp.getNext();
            }
            System.out.println(highestOccurrence.getWord() + " " + highestOccurrence.getOccurrence());
        }
    }

    private boolean isFull(String[] arr) {
        for (String str : arr) {
            if (str == null) {
                return false;
            }
        }
        return true;
    }

    public void getLowestOccurrence() {
        Node temp = head;
        Node lowestOccurrence = temp;

        if (temp == null) {
            System.out.println("Empty List");
        } else if (temp.getNext() == null) {
            System.out.println(temp.getWord() + " " + temp.getOccurrence());
        } else {
            while (temp != null) {
                if (temp.getOccurrence() < lowestOccurrence.getOccurrence()) {
                    lowestOccurrence = temp;
                }
                temp = temp.getNext();
            }
            System.out.println(lowestOccurrence.getWord() + " " + lowestOccurrence.getOccurrence());
        }
    }

    public void mostCommonWords() {
        Node temp = head;
        int counter = 0;
        int j = 0;
        Node highestOccurrence;
        String[] commonWords = new String[5];

        if (temp == null) {
            System.out.println("Empty List");
        } else if (temp.getNext() == null) {
            System.out.println(temp.getWord() + " " + temp.getOccurrence());
        } else {
            for (int i = 0; i < 5; i++) {
                counter++;
                temp = head;
                if (!isFull(commonWords)) {
                    while (temp != null) {

                        if (temp.getOccurrence() >= counter) {
                            highestOccurrence = temp;
                            commonWords[j] = highestOccurrence.getWord();
                            temp.setOccurrence(0);
                            j++;
                        }
                        temp = temp.getNext();
                    }

                }
            }
            System.out.println(Arrays.toString(commonWords));
        }
    }

    public void leastCommonWords() {
        Node temp = head;
        int counter = 0;
        int j = 0;
        Node lowestOccurrence;
        String[] commonWords = new String[5];

        if (temp == null) {
            System.out.println("Empty List");
        } else if (temp.getNext() == null) {
            System.out.println(temp.getWord() + " " + temp.getOccurrence());
        } else {
            for (int i = 0; i < 5; i++) {
                counter++;
                temp = head;
                if (!isFull(commonWords)) {
                    while (temp != null) {

                        if (temp.getOccurrence() <= counter && temp.getOccurrence() != 0) {
                            lowestOccurrence = temp;
                            commonWords[j] = lowestOccurrence.getWord();
                            temp.setOccurrence(0);
                            j++;
                        }
                        temp = temp.getNext();
                    }
                }

            }
        }
        System.out.println(Arrays.toString(commonWords));
    }


}





