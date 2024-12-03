package com.example.task4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.control.TextField;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.stage.DirectoryChooser;
import java.io.File;

public class HelloController {

    public ConcreteAggregate conaggr = new ConcreteAggregate("img");
    public Iterator iter = conaggr.getIterator();

    public Timeline time = new Timeline();

    private boolean isPlaying = false;
    @FXML
    private Button startStopButton;

    @FXML
    private ImageView screen;

    public void initialize() {
        time.setCycleCount(Timeline.INDEFINITE);
        updateTimeline(1000);

        screen.setPreserveRatio(false);
    }

    // Обработчик события для показа кадров
    private class EvHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            screen.setImage((Image) iter.next());
        }
    }

    @FXML
    public void toggleAnimation() {
        if (isPlaying) {
            time.pause();
            startStopButton.setText("stop");
        } else {
            startStopButton.setText("start");
            time.play();
        }
        isPlaying = !isPlaying;
    }

    // Метод для обновления временной шкалы
    private void updateTimeline(int delayMillis) {
        time.stop();
        time.getKeyFrames().clear();
        time.getKeyFrames().add(new KeyFrame(Duration.millis(delayMillis), new EvHandler()));
        if (isPlaying) {
            time.play();
        }
    }

    @FXML
    public void next() {
        screen.setImage((Image) iter.next());
    }

    @FXML
    public void preview(){
        screen.setImage((Image) iter.preview());
    }

    @FXML
    public void selectFolder() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            String folderPath = selectedDirectory.getAbsolutePath();
            conaggr = new ConcreteAggregate(folderPath);
            iter = conaggr.getIterator();
        }
    }
}