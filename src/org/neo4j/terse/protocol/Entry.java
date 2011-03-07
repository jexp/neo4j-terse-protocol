package org.neo4j.terse.protocol;

import org.neo4j.graphdb.PropertyContainer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
* @author mh
* @since 16.02.11
*/
public class Entry {
    static long marker = -1;
    final long id;
    final Map<String, Object> data=new HashMap<String, Object>();

    public Entry(long id) {
        this.id = id;
    }

    public Entry() {
        this(marker--);
    }

    public Entry(long id, PropertyContainer pc) {
        this.id = id;
        for (String key : pc.getPropertyKeys()) {
            data.put(key, pc.getProperty(key));
        }
    }

    public Entry with(String name, Object value) {
        this.data.put(name, value);
        return this;
    }

    public void addData(PropertyContainer pc) {
        for (String key : pc.getPropertyKeys()) {
            data.put(key, pc.getProperty(key));
        }
    }
    public Collection<String> names() {
        return data.keySet();
    }
    public Object get(String name) {
        return data.get(name);
    }
}
