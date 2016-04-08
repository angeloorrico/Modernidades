package br.mtm.modernidades;

import android.graphics.drawable.Drawable;

/**
 * Created by Angelo on 29/03/2016.
 */
public class ItemMenuModel implements Comparable{

    public String titulo;
    public int resourceId;

    public ItemMenuModel(String titulo, int resourceId) {
        this.titulo = titulo;
        this.resourceId = resourceId;
    }

    @Override
    public int compareTo(Object another) {
        Double rand = Math.random();
        if (rand < 0.5)
            return -1;
        else return 1;

    }
}
