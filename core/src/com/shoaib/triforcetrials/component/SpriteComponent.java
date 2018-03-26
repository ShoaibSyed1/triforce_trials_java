package com.shoaib.triforcetrials.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SpriteComponent implements Component {
    public Texture texture;
    public Rectangle bounds;
    public Vector2 offset;
    public boolean visible;

    public Animation animation;

    public SpriteComponent(Texture texture, Rectangle bounds, Vector2 offset, boolean visible) {
        this.texture = texture;
        this.bounds = bounds;
        this.offset = offset;
        this.visible = visible;

        this.animation = null;
    }

    public SpriteComponent(Texture texture, Rectangle bounds, Vector2 offset) {
        this(texture, bounds, offset, true);
    }

    public SpriteComponent(Texture texture, Rectangle bounds) {
        this(texture, bounds, Vector2.Zero);
    }

    public SpriteComponent(Texture texture) {
        this(texture, new Rectangle(0, 0, texture.getWidth(), texture.getHeight()));
    }

    public SpriteComponent withAnimation(Animation animation) {
        this.animation = animation;
        animation.initialize(this);

        return this;
    }

    public class Animation {
        public int frameWidth;
        public int frameHeight;
        public float delay;

        public int start;
        public int end;

        public int framesX;
        public int framesY;
        public int maxFrames;

        public float delayCounter;
        public int currentFrame;

        public Animation(int frameWidth, int frameHeight, float delay, int start, int end) {
            this.frameWidth = frameWidth;
            this.frameHeight = frameHeight;
            this.delay = delay;

            this.start = start;
            this.end = end;
        }

        void initialize(SpriteComponent spriteComponent) {
            this.framesX = spriteComponent.texture.getWidth() / this.frameWidth;
            this.framesY = spriteComponent.texture.getHeight() / this.frameHeight;

            this.maxFrames = framesX * framesY;

            this.delayCounter = 0;
            this.currentFrame = start;
        }
    }
}
