public class Test {
//index of 1,1,2,3,5,8
    public static void main(String[] args) {

        System.out.println(findFibonacciNumber(7));

    }

    public static int findFibonacciNumber(int num) {
        if (num <= 2)
            return 1;
        else
            return (num-1)+(num-2);
    }
}
