import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Glava1_4 {

    private static String pass1 = "12345";
    private static Boolean bool = false ;

    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);
        try {
            while (!bool) {
                System.out.println("Put your password and press Enter: ");
                bool = equalsPassword(bis.readLine());
                System.out.println(bool);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Boolean equalsPassword(String str){
        if (pass1.equals(str))
            return true;
        return false;
    }
}
