/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab10;

/**
 *
 * @author 2557705
 */
public class Order {
    private String selectedEntree;
    private String selectedDrink;
    private String specialRequests;
    private boolean water;
    
    public Order(){
        selectedEntree = "";
        selectedDrink = "";
        specialRequests = "";
        water = false;
    }
      
    public void setSelectedEntree(String entree) {
        selectedEntree = entree;
    }

    public void setSelectedDrink(String drink) {
        selectedDrink = drink;
    }

    public void setSpecialRequests(String requests) {
        specialRequests = requests;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public String getSelectedEntree() {
        return selectedEntree;
    }

    public String getSelectedDrink() {
        return selectedDrink;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public boolean getWater() {
        return water;
    }

    public double getEntreePrice() {
        double price = 0.0;

        if (selectedEntree.equals("Chicken Salad")) {
            price = 6.50;
        }
        else if (selectedEntree.equals("Turkey Sandwich")) {
            price = 6.75;
        }
        else if (selectedEntree.equals("Vegetable Wrap")) {
            price = 6.00;
        }
        else if (selectedEntree.equals("Grilled Cheese")) {
            price = 5.00;
        }

        return price;
    }

    public double getDrinkPrice() {
        double price = 0.0;

        if (selectedDrink.equals("Coffee")) {
            price = 1.50;
        }
        else if (selectedDrink.equals("Tea")) {
            price = 1.50;
        }
        else if (selectedDrink.equals("Soda")) {
            price = 2.00;
        }
        else if (selectedDrink.equals("Juice")) {
            price = 1.75;
        }

        return price;
    }

    public double getTotalPrice() {
        return getEntreePrice() + getDrinkPrice();
    }    
}
