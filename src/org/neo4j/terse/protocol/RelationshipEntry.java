package org.neo4j.terse.protocol;

import org.neo4j.graphdb.Relationship;

/**
* @author mh
* @since 16.02.11
*/
public class RelationshipEntry extends Entry {
    final long start, end;
    final String type;

    public RelationshipEntry(Relationship relationship) {
        super(relationship.getId(), relationship);
        this.start = relationship.getStartNode().getId();
        this.end = relationship.getEndNode().getId();
        this.type = relationship.getType().name();
    }

    public RelationshipEntry(NodeEntry start, NodeEntry end, String type) {
        this.start = start.id;
        this.end = end.id;
        this.type = type;
    }
    public RelationshipEntry(long start, long end, String type) {
        this.start = start;
        this.end = end;
        this.type = type;
    }
}
