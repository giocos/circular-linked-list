public class ApplicationDemo {
    static final int CAPACITY = 10;

    /*  ,-> 2 -> 5 -> 8 -> 10 -,
     *  ,                      ,
     *  - - - - - - - - - - - -
     */

    public static void main(String[] args) {
        final CircularLinkedList<Integer> integers = new CircularLinkedList<>(CAPACITY);
        integers.add(2);
        integers.add(5);
        integers.add(8);
        integers.add(10);

        integers.forEach(System.out::println);

        System.out.println("Last node points to element: "
                + integers.get(3).getNext().getElement());
    }
}
