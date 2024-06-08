package org.example.moves;

public interface IMoveStrategy {
    String proceed(String position);
    default char increment(char c) {
        return (char) (c + 1);
    }
    default char decrement(char c) {
        return (char) (c - 1);
    }
}
