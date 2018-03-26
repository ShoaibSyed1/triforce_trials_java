package com.shoaib.triforcetrials.component;

import com.badlogic.ashley.core.ComponentMapper;

public class Mappers {
    public static ComponentMapper<EventComponent> eventComponent = ComponentMapper.getFor(EventComponent.class);
    public static ComponentMapper<ScriptComponent> scriptComponent = ComponentMapper.getFor(ScriptComponent.class);
    public static ComponentMapper<SpriteComponent> spriteComponent = ComponentMapper.getFor(SpriteComponent.class);
    public static ComponentMapper<TransformComponent> transformComponent = ComponentMapper.getFor(TransformComponent.class);
}
