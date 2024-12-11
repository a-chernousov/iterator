package com.example.task4;

import javafx.scene.image.Image;

import java.io.File;

public class ImageIterator implements Iterator {
    private int current = 0;
    private String folderPath;
    private File[] imageFiles;

    public ImageIterator(String folderPath) {
        this.folderPath = folderPath;
        this.imageFiles = getImageFiles(folderPath);
    }

    private File[] getImageFiles(String folderPath) {
        File folder = new File(folderPath);
        return folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg"));
    }

    public File[] getImageFiles() {
        return imageFiles;
    }

    private Image getImage(int index) {
        try {
            if (index < imageFiles.length) {
                File file = imageFiles[index];
                return new Image(file.toURI().toString());
            } else {
                current = 0;
                return getImage(0);
            }
        } catch (Exception e) {
            current = 0;
            return getImage(0);
        }
    }

    @Override
    public boolean hasNext(int i) {
        return (current + i) < imageFiles.length;
    }

    @Override
    public Object next() {
        current++;
        return getImage(current);
    }

    @Override
    public Object preview() {
        if (current != 0) {
            current--;
        }
        return getImage(current);
    }
}