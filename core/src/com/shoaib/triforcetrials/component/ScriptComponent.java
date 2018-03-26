package com.shoaib.triforcetrials.component;

import com.badlogic.ashley.core.Component;
import com.shoaib.triforcetrials.scripts.Script;

public class ScriptComponent implements Component {
    public String path;

    public Script script;

    public boolean started;

    public ScriptComponent(String path) {
        this.path = path;

        this.script = null;

        this.started = false;
    }
}
