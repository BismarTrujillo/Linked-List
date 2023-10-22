public class Main {
    public static void main(String[] args) {


        Linked_List list1 = new Linked_List();


        list1.add("q");
        list1.add("q");
        list1.add("q");
        list1.add("q3");
        list1.add("w");
        list1.add("e");
        list1.add("r");
        list1.add("c");
        list1.add("v");
        list1.add("ee");
        list1.add("ee");
        list1.add("ee");
        list1.add("tt");

        list1.delete("q",true);

        list1.getHighestOccurrence();
        list1.getLowestOccurrence();

        list1.mostCommonWords();
        list1.leastCommonWords();

        list1.search("v");
        list1.search("ee");
        list1.search("tt");

        System.out.println("Words in container: " + list1.getTotalElements());
        System.out.println("Different Words in container: " + list1.getSize());

        list1.list();
    }
}
