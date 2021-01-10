import java.util.Scanner;

public class codeWarsNegativeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] test= new int[] {1,2,-3,4,5};
//        int[] test= new int[] {-1,2,-3,-4,-5};
        invert(test);
        for (int n :
                test) {
            System.out.print(n + " ");
        }
    }
    public static int[] invert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0){
                array[i] *= (-1);
            }else{
                array[i] = array[i]*(-1);
            }
        }
        return array;
    }
}
