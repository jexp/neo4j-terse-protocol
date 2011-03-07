package org.neo4j.terse;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.PropertyContainer;

/**
 * @author mh
 * @since 15.02.11
 */
public abstract class TerseServer implements TerseProtocol {
    GraphDatabaseService graphDatabaseService;

    public TerseServer(GraphDatabaseService graphDatabaseService) {
        this.graphDatabaseService = graphDatabaseService;
    }
}
