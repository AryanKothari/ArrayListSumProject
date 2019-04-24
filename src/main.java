import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class main {
    public static ArrayList<foodMenu> menu = new ArrayList<foodMenu>();
    public static ArrayList<orderedItems> dish = new ArrayList<orderedItems>();
    public static boolean stillOrdering = true;
    public static boolean invalidInput = true;
    public static int input;
    public static int numb;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        menu.add(new foodMenu("Burger", 15, true));
        menu.add(new foodMenu("Pizzaa", 18, true));
        menu.add(new foodMenu("Friess", 19, true));
        menu.add(new foodMenu("Coffee", 3, false));
        menu.add(new foodMenu("Juicee", 4, false));


        System.out.println("Welcome to the AKCafé! What would you like to order? Click 6 to exit.");
        System.out.println("   " + "Dish" + "         " + "Price");
        System.out.println("   " + "-------" + "      " + "------");

        outputMenu();

        while (stillOrdering == true) {
            input = askforInput() - 1;
            if (input >= 0 && input <= 4) {
                dish.add(new orderedItems(menu.get(input).getName(), menu.get(input).getPrice(), menu.get(input).getisFood()));
                System.out.println("Thank you! " + menu.get(input).getName() + " has been added to the bill! Type 6 for your bill or place another order.");
                outputMenu();
            } else if (input == 5) {
                stillOrdering = false;
            }
        }

        if (stillOrdering == false) {
            outputBill();
            System.out.println("Thank you for eating at AKCafé! Have a good day!");
        }
    }


    static public void outputMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + 1 + ". " + menu.get(i).getName() + "       " + "$" + menu.get(i).getPrice());
        }
    }

    static public int askforInput() {
        if (scan.hasNextInt()) {
            int number = scan.nextInt();

            if (number == 1) {
                numb = 1;
            } else if (number == 2) {
                numb = 2;
            } else if (number == 3) {
                numb = 3;
            } else if (number == 4) {
                numb = 4;
            } else if (number == 5) {
                numb = 5;
            } else if (number == 6) {
                numb = 6;
            } else {
                System.out.println("Invalid Input: Please Try Again");
                numb = 100;
            }

        } else {
            System.out.println("Invalid Input: Please Try Again");
            scan.next();
            numb = 100;
        }

        return numb;

    }

    static public void outputBill() throws IOException {
            int totalPrice = 0;
            float totalPricewTax = 0;
            System.out.println("Your Bill:");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/"+"test"+".txt"));
            for (int i = 0; i < dish.size(); i++) {
                System.out.println(i + 1 + ". " + dish.get(i).getName() + "       " + "$" + dish.get(i).getPrice());
                writer.write(i + 1 + ". " + dish.get(i).getName() + "       " + "$" + dish.get(i).getPrice()+ "\n");
                totalPrice += dish.get(i).getPrice();
                totalPricewTax += dish.get(i).getTaxedPrice();
            }



            System.out.println("Total Price BEFORE Tax: $" + totalPrice);
            System.out.println("Total Price AFTER Tax: $" + totalPricewTax);
            writer.write("Total: $" + totalPrice + "\n");
            writer.write("Total Price AFTER Tax: $" + totalPricewTax + "\n");
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("path not found");
        } catch (IOException e) {
            System.out.println("io exception");
        }
    }
}
