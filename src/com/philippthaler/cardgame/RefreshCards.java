package com.philippthaler.cardgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RefreshCards extends Application {

    private CardPane sc;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        sc = new CardPane();
        pane.setCenter(sc);

        Button btnRefresh = new Button("Refresh");
        pane.setBottom(btnRefresh);
        BorderPane.setAlignment(btnRefresh, Pos.CENTER);


        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        btnRefresh.setOnAction(e -> refresh());

        btnRefresh.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.R) {
                refresh();
            }
        });
    }

    public void refresh() {
        sc.refresh();
    }

}