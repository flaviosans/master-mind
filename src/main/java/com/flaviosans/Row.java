package com.flaviosans;

import java.util.Arrays;

public class Row {
    final Color[] positions;
    protected int matchedPositions;
    protected int matchedColors;

    public static final Row none = new Row(Guesser.none);

    public Row(Color[] positions) {
        this.positions = Arrays.copyOf(positions, positions.length);
    }

    protected Row(Row cloneFrom) {
        this(cloneFrom.positions);
        setMatch(cloneFrom.matchedPositions, cloneFrom.matchedColors);
    }

    public void setMatch(int matchedPositions, int matchedColors) {
        if (matchedColors + matchedPositions > positions.length) {
            throw new IllegalArgumentException("Números não podem ser maiores que a posição");
        }
        this.matchedColors = matchedColors;
        this.matchedPositions = matchedPositions;
    }

    public boolean guessMatches(Color[] guess) {
        return nrMatchingColors(guess) == matchedColors &&
            nrMatchingPositions(guess) == matchedPositions;
    }

    public int nrMatchingColors(Color[] guess) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                if (i != j && guess[i] == positions[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int nrOfColumns() {
        return positions.length;
    }
}
