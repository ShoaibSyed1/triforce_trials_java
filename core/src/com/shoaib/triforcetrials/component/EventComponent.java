package com.shoaib.triforcetrials.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;
import com.shoaib.triforcetrials.event.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventComponent implements Component {
    public List<Class<Event>> listen;

    public List<Event> received;
    public List<Event> send;

    public EventComponent(Class<Event>... listen) {
        this.listen = new ArrayList(Arrays.asList(listen));

        this.received = new ArrayList<>();
        this.send = new ArrayList<>();
    }

    public void send(Event... events) {
        for (Event event : events) {
            this.send.add(event);
        }
    }

    public List<Event> get() {
        List<Event> ret = this.received;
        return this.received;
    }
}
