public class Base2Power {
    public static double solution(int n) {
        Boolean isNegative = false;
        if (n < 0) {
            n = -n;
            isNegative = true;
        } 
        int temp = 1 << n;
        if (isNegative)
            return 1/(double)temp;
        else
            return temp;
    }
    public static void main(String[] args) {
        for (int i = -10; i < 11; ++i)
            System.out.println(solution(i));
    }
}


