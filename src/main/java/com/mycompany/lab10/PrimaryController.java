/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.lab10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author 2557705
 */
public class PrimaryController implements Initializable {


    @FXML
    private MenuItem placeOrderMenuItem;
    @FXML
    private MenuItem clearOrderMenuItem;
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private MenuItem editEntreeMenuItem;
    @FXML
    private MenuItem editDrinkMenuItem;
    @FXML
    private MenuItem editRequestMenuItem;
    @FXML
    private MenuItem aboutMenuItem;
    @FXML
    private CheckBox waterCheckBox;
    @FXML
    private TextField specialRequestsField;
    @FXML
    private Label currentOrderLabel;
    @FXML
    private Button clearOrderButton;
    @FXML
    private Button placeoderButton;
    @FXML
    private ListView<String> entreeListView;
    @FXML
    private RadioButton coffeeRadio;
    @FXML
    private ToggleGroup drinkGroup;
    @FXML
    private RadioButton teaRadio;
    @FXML
    private RadioButton sodaRadio;
    @FXML
    private RadioButton juiceRadio;
    private Order order;
    private OrderView orderView = new OrderView();
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        order = new Order();

        entreeListView.getItems().addAll("Chicken Salad", "Turkey Sandwich", "Vegetable Wrap", "Grilled Cheese");

        coffeeRadio.setToggleGroup(drinkGroup);
        teaRadio.setToggleGroup(drinkGroup);
        sodaRadio.setToggleGroup(drinkGroup);
        juiceRadio.setToggleGroup(drinkGroup);

        entreeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateOrder());
        drinkGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> updateOrder());
        waterCheckBox.setOnAction(e -> updateOrder());
        specialRequestsField.textProperty().addListener((observable, oldValue, newValue) -> updateOrder());
        
        updateOrder();
    }
    
    

    private String getDrink() {
        if (drinkGroup.getSelectedToggle() == coffeeRadio) {
            return "Coffee";
        }
        else if (drinkGroup.getSelectedToggle() == teaRadio) {
            return "Tea";
        }
        else if (drinkGroup.getSelectedToggle() == sodaRadio) {
            return "Soda";
        }
        else if (drinkGroup.getSelectedToggle() == juiceRadio) {
            return "Juice";
        }
        return "";
    }

    private void updateOrder() {
        String entree = entreeListView.getSelectionModel().getSelectedItem();
        
        if (entree == null) {
            entree = "";
        }
        
        order.setSelectedEntree(entree);
        order.setSelectedDrink(getDrink());
        order.setWater(waterCheckBox.isSelected());
        order.setSpecialRequests(specialRequestsField.getText());

        String display = "Current Order:\n";
        display += "Entrée: " + entree + "\n";
        display += "Drink: " + getDrink() + "\n";
        display += "Water: " + (waterCheckBox.isSelected() ? "Yes" : "No") + "\n";
        display += "Total: $" + String.format("%.2f", order.getTotalPrice());

        currentOrderLabel.setText(display);
    }
    
}
