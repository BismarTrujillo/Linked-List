public class Main {
    public static void main(String[] args) {


        Linked_List list1 = new Linked_List();


//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        list1.add("4");
//        list1.add("5");
//        list1.add("6");
        list1.add("7");
        list1.add("7");
        list1.add("8");
        list1.add("9");
        list1.add("9");
        list1.add("9");
        list1.add("10");
        list1.add("10");
        list1.add("10");
        list1.add("11");
        list1.add("11");


        list1.display();

        System.out.println(list1.search("9"));
        list1.delete("10", true);

        System.out.println(list1.search("9"));

        list1.display();


    }
}
