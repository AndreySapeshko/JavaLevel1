import org.graalvm.compiler.replacements.StandardGraphBuilderPlugins;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class HomeWork1 {
    public static void main(String[] args) {
        byte a = 127;
        short b = 32000;
        int c = 1015;
        long d = 92233L;
        float e = 1.5f;
        double g = 7.48;
        char h = 'd';
        boolean j = true;
        System.out.println(a + " | " + b + " | " + c + " | " + d + " | " + e +
                " | " + g + " | " + h + " | " + j);

        System.out.println(calculation(5, 6, 4, 2));
        System.out.println(interval(4, 6));
        printName("Михаил");
        leapYear(300);
        leapYear(400);
        leapYear(800);
        leapYear(1004);
        leapYear(933);

    }
    static int calculation(int num1, int num2, int num3, int num4) {
        return (num1 * (num2 + (num3 / num4)));
    }
    static boolean interval(int num1, int num2) {
        return (10 <= (num1 + num2) && (num1 + num2) <= 20);
    }
    static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }
    static void leapYear(int year) {
        String result = "Не високосный";
        if (year % 4 == 0) {
            result = "Високосный";
        }
        if (year % 100 == 0){
            result = "Не високосный";
        }
        if (year % 400 == 0){
            result = "Високосный";
        }
        System.out.println(year + " год " + result);
    }

}
