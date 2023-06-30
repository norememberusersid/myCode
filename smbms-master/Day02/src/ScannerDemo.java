import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        System.out.println("age:");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        System.out.println(age);

        System.out.println("输入字符串");
        String a = sc.next();
        System.out.println(a);

    }
}
