import java.util.Scanner;

public class test01 {
    /*
     * 用三元运算符求三个整数的最大值
     * */
    public static void main(String[] args) {
        System.out.println("请输入 a b c 三个整数");
        Scanner sc = new Scanner(System.in);

        System.out.print("a=");
        int a = sc.nextInt();
        System.out.print("b=");
        int b = sc.nextInt();
        System.out.print("c=");
        int c = sc.nextInt();


        System.out.println("a b c 三个整数中的最大值是：" + (c > (a > b ? a : b) ? c : (a > b ? a : b)));


    }
}
