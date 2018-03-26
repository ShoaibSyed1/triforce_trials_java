package com.shoaib.triforcetrials.listeners;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.utils.Array;
import com.shoaib.triforcetrials.component.Mappers;
import com.shoaib.triforcetrials.component.TransformComponent;

import java.util.Comparator;

public class RenderListener implements EntityListener {
    public Array<Entity> entities;

    public RenderListener() {
        this.entities = new Array<>();
    }

    @Override
    public void entityAdded(Entity entity) {
        this.entities.add(entity);

        entities.sort(Comparator.comparingInt(e -> Mappers.transformComponent.get(e).layer));
    }

    @Override
    public void entityRemoved(Entity entity) {
        this.entities.removeValue(entity, true);
    }
}
