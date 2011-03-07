package org.neo4j.terse.protocol;

import java.util.Collection;
import java.util.Iterator;

public class Serializer {
    public void props(StringBuilder _, Entry e) {
        for (Iterator<String> it = e.names().iterator(); it.hasNext();) {
            String name = it.next();
            _.append(val(name)).append(':').append(val(e.get(name)));

            if (it.hasNext()) _.append(',');
        }
    }

    public void addRelationship(StringBuilder _, RelationshipEntry r) {
        if (!r.data.isEmpty()) _.append(',');
        _.append(val("nodes")).append(':').append('[');
        _.append(r.start).append(',').append(r.end).append(',').append(val(r.type));
        _.append(']');
    }

    public CharSequence addEntry(StringBuilder _, Entry e) {
        start(_, e);
        if (e instanceof NodeEntry) {
            addNode(_, (NodeEntry) e);
        }
        if (e instanceof RelationshipEntry) {
            addRelationship(_, (RelationshipEntry) e);
        }
        return end(_);
    }

    public void addNode(StringBuilder _, NodeEntry n) {
        if (n.links.isEmpty()) return;
        if (!n.data.isEmpty()) _.append(',');
        _.append(val("rel")).append(':').append('[');
        addIds(_, n.links);
        _.append(']');
    }

    private CharSequence end(StringBuilder _) {
        _.append('}');
        return _;
    }

    private void start(StringBuilder _, Entry n) {
        if (_.length()!=0) _.append(',');
        _.append(n.id).append(':').append('{');
        _.append(val("data")).append(':').append('{');
        props(_, n);
        _.append('}');
    }

    private void addIds(StringBuilder _, Collection<Long> ids) {
        for (Iterator<Long> it = ids.iterator(); it.hasNext();) {
            _.append(it.next());
            if (it.hasNext()) _.append(',');
        }
    }

    public String val(Object o) {
        if (o == null) return "null";
        if (o instanceof Number) return o.toString();
        return "\"" + o.toString() + "\"";
    }

}