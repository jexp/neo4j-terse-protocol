package org.neo4j.terse.protocol;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.ArrayList;
import java.util.Collection;

/**
* @author mh
* @since 16.02.11
*/
public class NodeEntry extends Entry {
    final Collection<Long> links = new ArrayList<Long>();

    public NodeEntry(Node node) {
        super(node.getId(),node);
        for (Relationship relationship : node.getRelationships()) {
            links.add(relationship.getId());
        }
    }

    public NodeEntry(long id) {
        super(id);
    }

    public NodeEntry() {
    }

    public NodeEntry rels(RelationshipEntry...entries) {
        for (int i = 0; i < entries.length; i++) {
            links.add(entries[i].id);
        }
        return this;
    }
    public NodeEntry rel(long id) {
        links.add(id);
        return this;
    }
    public NodeEntry rels(long... id) {
        for (int i = 0; i < id.length; i++) {
            links.add(id[i]);
        }
        return this;
    }

}
