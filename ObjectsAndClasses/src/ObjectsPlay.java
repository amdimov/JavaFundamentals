import java.util.Scanner;

public class ObjectsPlay {
    static class TestMemory{
        int a;
        int b;

        public int sumNumbers(){
            return a+b;
        }

        void doubleTheValue(){
            a*=2;
            b*=2;
        }
        int getA(){
            return a;
        }

        @Override
        public String toString() {
            return String.format("Valie of %d -- %d", getA(), this.b);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TestMemory test = new TestMemory();
        test.a = 5;
        test.b = 10;

        test.doubleTheValue();
        System.out.println(test.getA());
        System.out.println(test.b);
        System.out.println(test);

    }
}
