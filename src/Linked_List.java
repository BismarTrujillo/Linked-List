import java.util.Arrays;

public class Linked_List {
    private Node head;
    private int size;
    private int totalElements;


    public Linked_List() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void add(String word) {

        Node temp = head;

        if (searchInt(word) == 0) {
            Node node = new Node(word);
            node.setOccurrence(1);
            node.setNext(head);
            head = node;
            size++;
            totalElements++;

        } else {
            while (head != null) {
                if (head.getWord().equals(word)) {
                    head.setOccurrence(head.getOccurrence() + 1);
                    totalElements++;
                }
                head = head.getNext();
            }
            head = temp;
        }
    }

    public void list() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getWord() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("END");
    }

    public void search(String word) {
        Node temp = head;
        int occurrence = 0;

        while (temp != null) {
            if (temp.getWord().equals(word)) {
                occurrence = temp.getOccurrence();
                break;
            }
            temp = temp.getNext();
        }
        System.out.println(occurrence);
    }

    private int searchInt(String word) {
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

        if (searchInt(word) == 0) {
            System.out.println(word + " not found");
            return;
        }

        while (head != null) {
            if (forceDelete) {
                if (head.getWord().equals(word)) {
                    head = head.getNext();
                    firstNode = head;
                    size--;
                    totalElements--;
                    break;
                } else if (head.getNext().getWord().equals(word)) {
                    head.setNext(head.getNext().getNext());
                    size--;
                    totalElements--;
                    break;
                }
                head = head.getNext();
            } else {
                if (head.getWord().equals(word)) {
                    if (searchInt(word) > 1) {
                        head.setOccurrence(head.getOccurrence() - 1);
                        break;
                    }
                    head = head.getNext();
                    firstNode = head;
                    size--;
                    totalElements--;
                    break;

                } else if (head.getNext().getWord().equals(word)) {
                    if (searchInt(word) > 1) {
                        head.getNext().setOccurrence(head.getNext().getOccurrence() - 1);
                        break;
                    }
                    head.setNext(head.getNext().getNext());
                    size--;
                    totalElements--;
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
            System.out.println("Word: " + highestOccurrence.getWord() + " Occurrence: " + highestOccurrence.getOccurrence());
        }
    }

    private int getHighestOccurrenceInt() {
        Node temp = head;
        Node highestOccurrence = temp;

        if (temp == null) {
            System.out.println("Empty List");
            return 0;
        } else if (temp.getNext() == null) {
            System.out.println(temp.getWord() + " " + temp.getOccurrence());
            return 0;
        } else {
            while (temp != null) {
                if (temp.getOccurrence() > highestOccurrence.getOccurrence()) {
                    highestOccurrence = temp;
                }
                temp = temp.getNext();
            }
            return highestOccurrence.getOccurrence();
        }
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
            System.out.println("Word: " + lowestOccurrence.getWord() + " Occurrence: " + lowestOccurrence.getOccurrence());
        }
    }

    public void mostCommonWords() {
        Node temp;
        int j = 0;
        String[] commonWords = new String[5];

        int count = getHighestOccurrenceInt();

        for (int i = 0; i < size; i++) {
            count--;
            temp = head;
            while (temp != null) {
                if (temp.getOccurrence() != 0 && temp.getOccurrence() >= count && !isFull(commonWords) && !isAdded(commonWords, temp.getWord())) {
                    commonWords[j] = temp.getWord();
                    j++;
                }
                temp = temp.getNext();
            }
        }
        System.out.println(Arrays.toString(commonWords));
    }

    public void leastCommonWords() {
        Node temp;
        int j = 0;
        String[] commonWords = new String[5];

        int count = 0;

        for (int i = 0; i < size; i++) {
            count++;
            temp = head;
            while (temp != null) {
                if (temp.getOccurrence() <= count && temp.getOccurrence() != 0 && !isFull(commonWords) && !isAdded(commonWords, temp.getWord())) {
                    commonWords[j] = temp.getWord();
                    j++;
                }
                temp = temp.getNext();
            }
        }
        System.out.println(Arrays.toString(commonWords));
    }

    private boolean isFull(String[] arr) {
        for (String str : arr) {
            if (str == null) {
                return false;
            }
        }
        return true;
    }

    private boolean isAdded(String[] arr, String word) {
        for (String str : arr) {
            if (str != null && str.equals(word)) {
                return true;
            }
        }
        return false;
    }
}







