/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab10;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 2557705
 */
public class OrderView {
    public void showSummaryWindow(Order order) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();
        SecondaryController controller = loader.getController();
        controller.setOrder(order);
        Stage secondStage = new Stage();
        secondStage.setTitle("Order Summary");
        Scene secondScene = new Scene(root);
        secondStage.setScene(secondScene);
        secondStage.show();
    }
}
