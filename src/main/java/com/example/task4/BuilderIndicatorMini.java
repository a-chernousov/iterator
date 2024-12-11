package com.example.task4;

public class BuilderIndicatorMini implements Builder {

    private Indicator indicator = new Indicator();

    @Override
    public void setView(int N, char norm, char select) {
        // Можно добавить реализацию, если нужно
    }

    @Override
    public void lineBounds(float start, float stop) {
        // Не используется в данном случае
    }

    @Override
    public void linePaint(float measure) {
        // Не используется в данном случае
    }

    @Override
    public void lineMark(String measure) {
        // Не используется в данном случае
    }

    @Override
    public void addTitle(String name) {
        // Не используется в данном случае
    }

    @Override
    public Indicator build() {
        return indicator;
    }
}