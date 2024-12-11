package com.example.task4;

public class Director {

    public Indicator construct(Builder builder) {
        builder.lineBounds(22.2f, 26.1f);
        builder.linePaint(22.4f);
        builder.lineMark(String.format("%.1f", 22.4f));
        builder.addTitle("Норма");
        return builder.build();
    }
}