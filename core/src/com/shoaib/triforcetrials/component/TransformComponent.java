package com.shoaib.triforcetrials.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent implements Component {
    public Vector2 position;
    public Vector2 scale;
    public int layer;
    public boolean fixed;

    public TransformComponent(Vector2 position, Vector2 scale, int layer, boolean fixed) {
        this.position = position;
        this.scale = scale;
        this.layer = layer;
        this.fixed = fixed;
    }

    public TransformComponent(Vector2 position, int layer, boolean fixed) {
        this(position, new Vector2(1f, 1f), layer, fixed);
    }

    public TransformComponent(Vector2 position, int layer) {
        this(position, layer, false);
    }

    public TransformComponent(Vector2 position) {
        this(position, 0);
    }

    public TransformComponent() { this(new Vector2(0f, 0f)); }
}
