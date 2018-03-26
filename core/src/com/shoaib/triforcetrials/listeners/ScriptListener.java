package com.shoaib.triforcetrials.listeners;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.utils.Array;
import com.shoaib.triforcetrials.TriforceTrials;
import com.shoaib.triforcetrials.component.Mappers;
import com.shoaib.triforcetrials.component.ScriptComponent;
import com.shoaib.triforcetrials.scripts.Script;

import java.util.logging.Level;

public class ScriptListener implements EntityListener {
    private static final String SCRIPT_PATH = "com.shoaib.triforcetrials.scripts.";

    public Array<Entity> entities;

    public ScriptListener() {
        this.entities = new Array<>();
    }

    @Override
    public void entityAdded(Entity entity) {
        this.entities.add(entity);

        ScriptComponent scriptComponent = Mappers.scriptComponent.get(entity);

        Class clazz;
        try {
            clazz = Class.forName(SCRIPT_PATH + scriptComponent.path);
        } catch(ClassNotFoundException ex) {
            TriforceTrials.logger.log(Level.SEVERE, "Error during script loading: Script '\" + scriptComponent.path + \"' not found:");
            TriforceTrials.logger.log(Level.SEVERE, ex.toString());
            return;
        }

        try {
            scriptComponent.script = (Script) clazz.newInstance();
        } catch(Exception ex) {
            TriforceTrials.logger.log(Level.SEVERE, "Error during script loading: Class '\" + scriptComponent.path + \"' not instance of Script:");
            TriforceTrials.logger.log(Level.SEVERE, ex.toString());
            return;
        }
    }

    @Override
    public void entityRemoved(Entity entity) {
        this.entities.removeValue(entity, true);

        if (Mappers.scriptComponent.has(entity)) {
            ScriptComponent scriptComponent = Mappers.scriptComponent.get(entity);
            if (scriptComponent.script != null) scriptComponent.script.stop();
        }
    }
}
