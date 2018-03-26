package com.shoaib.triforcetrials.scripts;

import com.badlogic.ashley.core.Entity;

public abstract class Script {
    public Script() {}

    public abstract void start(Entity entity);

    public abstract void update();

    public abstract void stop();
}
