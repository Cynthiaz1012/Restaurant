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
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author 2557705
 */
public class SecondaryController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Label entreeLabel;
    @FXML
    private Label drinkLabel;
    @FXML
    private Label entreePriceLabel;
    @FXML
    private Label drinkPriceLabel;
    @FXML
    private Label waterLabel;
    @FXML
    private Label specialRequestsLabel;
    @FXML
    private Label totalLabel;
    @FXML
    private Button closebutton;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        closebutton.setOnAction(e -> {
            closebutton.getScene().getWindow().hide();
        });
    }

    public void setOrder(Order order) {
        entreeLabel.setText(order.getSelectedEntree());
        drinkLabel.setText(order.getSelectedDrink());
        entreePriceLabel.setText("$" + String.format("%.2f", order.getEntreePrice()));
        drinkPriceLabel.setText( "$" + String.format("%.2f", order.getDrinkPrice()));

        if (order.getWater()) {
            waterLabel.setText("Yes");
        } else {
            waterLabel.setText("No");
        }

        specialRequestsLabel.setText(order.getSpecialRequests());
        totalLabel.setText("$" + String.format("%.2f", order.getTotalPrice()));
    }   
}
