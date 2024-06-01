public class Main {
    public static void main(String[] args) {
        Tree<Integer> numbers = new Tree<>(1);
        for(int i = 0; i < 10; i++) {
            numbers.insert((int)(Math.random() * 100));
        }
        numbers.print();
    }
}
