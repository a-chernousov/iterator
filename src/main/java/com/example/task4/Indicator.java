package com.example.task4;

import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Indicator {

    private Pane panel = new Pane();
    private Rectangle backgroundBar; // Фон для индикатора
    private Rectangle progressBar;   // Прогресс-бар
    private Text progressText;       // Текст для отображения текущего состояния

    public Indicator() {
        // Добавляем тень для панели
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.GRAY);
        shadow.setOffsetX(3);
        shadow.setOffsetY(3);
        panel.setEffect(shadow);

        // Увеличиваем размер панели
        panel.setPrefSize(400, 50);
        panel.setPadding(new Insets(10));

        // Создаем фон для индикатора
        backgroundBar = new Rectangle(0, 0, panel.getPrefWidth(), 20);
        backgroundBar.setFill(Color.LIGHTGRAY); // Серый фон

        // Создаем прямоугольник для отображения прогресса
        progressBar = new Rectangle(0, 0, 0, 20);
        progressBar.setFill(Color.BLUE);

        // Создаем текстовое поле для отображения текущего состояния
        progressText = new Text("0/0");
        progressText.setX(10);
        progressText.setY(40);

        // Добавляем элементы на панель
        panel.getChildren().addAll(backgroundBar, progressBar, progressText);
    }

    public void update(int currentIndex, int totalCount) {
        // Обновляем прогресс бар
        double progress = (double) currentIndex / totalCount;
        progressBar.setWidth(panel.getWidth() * progress);

        // Обновляем текст
        progressText.setText(currentIndex + "/" + totalCount);
    }

    public void show(Pane pane) {
        pane.getChildren().add(panel);
    }

    public Pane getPanel() {
        return panel;
    }
}