package com.flaviosans;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ColorManager
{
    final protected int nrColors;
    final protected Map<Color, Color> successor = new HashMap<>();
    private Color first;

    public ColorManager(int nrColors)
    {
        this.nrColors = nrColors;
        createOrdering();
    }

    protected Color newColor()
    {
        return new Color();
    }

    private Color[] createColors()
    {
        Color[] colors = new Color[nrColors];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = newColor();
        }
        return colors;
    }

    private void createOrdering()
    {
        Color[] colors = createColors();
        first = colors[0];
        for (int i = 0; i < nrColors -1; i++) {
            successor.put(colors[i], colors[i + 1]);
        }
    }

    private boolean isNotUnique(Color[] guess)
    {
        final var alreadyPresent = new HashSet<Color>();
        for (final var color : guess) {
            if (alreadyPresent.contains(color)) {
                return true;
            }

            alreadyPresent.add(color);
        }
        return false;
    }
}

