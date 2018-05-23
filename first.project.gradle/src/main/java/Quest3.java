import java.io.IOException;

public class Quest3 {

    public static void main(String[] args) {
        System.out.println("5%1=" + 5%1 + "  5%2=" + 5%2);
        int b1 = 0xe;//14 или 1110
        int b2 = 0x9;//9 или 1001
        int i = 0;

        System.out.println(b1 + "|" + b2 + " = " + (b1|b2));
        System.out.println(b1 + "&" + b2 + " = " + (b1&b2));
        System.out.println(b1 + "^" + b2 + " = " + (b1^b2));
        System.out.println(     "~" + b2 + " = " + ~b2);
        System.out.println(b1 + ">>" + ++i + " = " + (b1>>i));
        System.out.println(b1 + "<<" + i + " = " + (b1<<i++));
        System.out.println(b1 + ">>>" + i +" = " + (b1>>>i));
    }

}
