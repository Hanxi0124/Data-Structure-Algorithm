public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1000,1);
        System.out.println(arr);

        arr.addFisrt(200);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);

        arr.removeElement(200);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);


    }
}
