import java.util.Scanner;

public class Praktikum {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ваше имя");
        String name = myObj.nextLine();  // Read user input

        Account account = new Account(name);

        boolean checkName = account.checkNameToEmboss();
        System.out.println(checkName);
    }
} 