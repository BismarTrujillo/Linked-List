public class Main {
    public static void main(String[] args) {


        Linked_List list1 = new Linked_List();


        list1.add("first");
        list1.add("second");
        list1.add("third");
        list1.add("forth");
        list1.add("fifth");
        list1.add("sixth");
        list1.add("seventh");

        list1.display();

        System.out.println(list1.search("seventh"));
        list1.delete("first");
        list1.display();


    }
}