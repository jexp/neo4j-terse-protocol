package org.neo4j.terse;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.terse.protocol.Entry;
import org.neo4j.terse.protocol.NodeEntry;
import org.neo4j.terse.protocol.RelationshipEntry;

/**
 * @author mh
 * @since 16.02.11
 */
public class NeoBatch {
    public void run() {}
    public void update(Entry...entries) {}
    public void delete(Entry...entries) {}
    public void delete(long...ids) {}
    public void index(Entry...entries) {}
    public NodeEntry node() { return new NodeEntry();}
    public NodeEntry node(long id) { return new NodeEntry(id);}
    public NodeEntry node(Node node) { return new NodeEntry(node);}
    public RelationshipEntry relationship(long start,long end, String type) { return new RelationshipEntry(start,end,type);}
    public RelationshipEntry relationship(NodeEntry start,NodeEntry end, String type) { return new RelationshipEntry(start,end,type);}
    public RelationshipEntry relationship(Relationship relationship) { return new RelationshipEntry(relationship);}
}
