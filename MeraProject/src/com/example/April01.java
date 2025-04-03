package com.example;


class Pizza {
    private String size;
    private double basePrice;
    private double toppingsPrice = 0;
    private String toppings = "";

    public Pizza(String size) {
        this.size = size;
        switch (size.toLowerCase()) {
            case "large":
                this.basePrice = 10.0;
                break;
            case "medium":
                this.basePrice = 8.0;
                break;
            case "small":
                this.basePrice = 6.0;
                break;
            default:
                this.basePrice = 0;
        }
    }

    public void addTopping(String topping, double price) {
        if (toppings.length() > 0) {
            toppings += ", ";
        }
        toppings += topping;
        toppingsPrice += price;
    }

    public double calculateTotalPrice() {
        return basePrice + toppingsPrice;
    }

    public void displayOrderDetails() {
        System.out.println("Pizza Size: " + size);
        System.out.println("Toppings: " + (toppings.isEmpty() ? "None" : toppings));
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}

public class April01 {
    public static void main(String[] args) {
        Pizza order1 = new Pizza("large");
        order1.addTopping("Pepperoni", 2.0);
        order1.addTopping("Mushrooms", 1.5);
        
        System.out.println("Order 1 Details:");
        order1.displayOrderDetails();
        System.out.println();

        Pizza order2 = new Pizza("medium");
        order2.addTopping("Olives", 1.0);
        
        System.out.println("Order 2 Details:");
        order2.displayOrderDetails();
    }
}