package com.shoaib.triforcetrials;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.shoaib.triforcetrials.component.ScriptComponent;
import com.shoaib.triforcetrials.system.ScriptSystem;

public class Scene {
    private Engine engine;

    public Scene() {
        this.engine = new Engine();
    }

    public void start() {
        this.engine.addSystem(new ScriptSystem());
        this.engine.addEntity(new Entity().add(new ScriptComponent("test.lua")));
    }

    public void update() {
        this.engine.update(Gdx.graphics.getDeltaTime());
    }
}
