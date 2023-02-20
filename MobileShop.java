package johns_Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MobilePhone {
    String os;
    int ram;
    int memory;
    int price;
    int rating;

    public MobilePhone(String os, int ram, int memory, int price, int rating) {
        this.os = os;
        this.ram = ram;
        this.memory = memory;
        this.price = price;
        this.rating = rating;
    }
}

public class MobileShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Mobile Phones : ");
        int n = sc.nextInt(); // number of mobile phones
        ArrayList<MobilePhone> phones = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	System.out.println("Enter the Operating System : ");
            String os = sc.next();
            System.out.println("Enter the Ram Size : ");
            int ram = sc.nextInt();
            System.out.println("Enter the Memory size : ");
            int memory = sc.nextInt();
            System.out.println("Enter the Price : ");
            int price = sc.nextInt();
            System.out.println("Enter the Rating : ");
            int rating = sc.nextInt();
            phones.add(new MobilePhone(os, ram, memory, price, rating));
        }
        System.out.println("Enter the number of Customers : ");
        int q = sc.nextInt(); // number of customers
        for (int i = 0; i < q; i++) {
        	System.out.println("Enter the Customer OS : ");
            String os = sc.next();
            System.out.println("Enter the Customer Ram size :");
            int ram = sc.nextInt();
            System.out.println("Enter the Customer Memory Size : ");
            int memory = sc.nextInt();
            System.out.println("Enter the Customer Budget : ");
            int budget = sc.nextInt();

            // find the phones that match the customer's requirements
            ArrayList<MobilePhone> validPhones = new ArrayList<>();
            for (MobilePhone phone : phones) {
                if (phone.os.equals(os) && phone.ram == ram && phone.memory == memory && phone.price <= budget) {
                    validPhones.add(phone);
                }
            }

            // sort the valid phones by rating
            Collections.sort(validPhones, (a, b) -> b.rating - a.rating);

            if (validPhones.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(validPhones.get(0).rating);
            }
        }
    }
}
