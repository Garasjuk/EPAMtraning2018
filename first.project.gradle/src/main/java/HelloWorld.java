import java.io.PrintStream;

public class HelloWorld {

    public static void main(String[] args) {
        print(System.out);
    }

    public static void print(PrintStream arg) {
        arg.println("Hellow, Grodno!");
    }

}
