package com.shoaib.triforcetrials.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.shoaib.triforcetrials.component.Mappers;
import com.shoaib.triforcetrials.component.ScriptComponent;
import com.shoaib.triforcetrials.listeners.ScriptListener;

public class ScriptSystem extends EntitySystem {
    private ScriptListener scriptListener;

    public ScriptSystem() {
        this.scriptListener = new ScriptListener();
    }

    @Override
    public void addedToEngine(Engine engine) {
        engine.addEntityListener(Family.all(ScriptComponent.class).get(), this.scriptListener);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : this.scriptListener.entities) {
            ScriptComponent scriptComponent = Mappers.scriptComponent.get(entity);
            if (!scriptComponent.started) {
                scriptComponent.started = true;
                scriptComponent.script.start(entity);
            }

            scriptComponent.script.update();
        }
    }
}
