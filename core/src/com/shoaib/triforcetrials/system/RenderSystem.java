package com.shoaib.triforcetrials.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.shoaib.triforcetrials.component.Mappers;
import com.shoaib.triforcetrials.component.SpriteComponent;
import com.shoaib.triforcetrials.component.TransformComponent;
import com.shoaib.triforcetrials.listeners.RenderListener;

public class RenderSystem extends EntitySystem {
    private RenderListener renderListener;

    private SpriteBatch spriteBatch;

    public RenderSystem() {
        this.renderListener = new RenderListener();

        this.spriteBatch = new SpriteBatch();
    }

    @Override
    public void addedToEngine(Engine engine) {
        engine.addEntityListener(Family.all(SpriteComponent.class, TransformComponent.class).get(), this.renderListener);
    }

    @Override
    public void update(float deltaTime) {
        spriteBatch.begin();

        // TODO: Sort based on layer
        // TODO: Camera

        for (Entity entity : renderListener.entities) {
            SpriteComponent spriteComponent = Mappers.spriteComponent.get(entity);
            TransformComponent transformComponent = Mappers.transformComponent.get(entity);

            if (spriteComponent.visible) {
                spriteBatch.draw(spriteComponent.texture,
                        transformComponent.position.x + spriteComponent.offset.x,
                        transformComponent.position.y + spriteComponent.offset.y,
                        spriteComponent.bounds.width * transformComponent.scale.x,
                        spriteComponent.bounds.height * transformComponent.scale.y,
                        (int) spriteComponent.bounds.x, (int) spriteComponent.bounds.y,
                        (int) spriteComponent.bounds.width, (int) spriteComponent.bounds.height, false, false);
            }
        }

        spriteBatch.end();
    }
}
