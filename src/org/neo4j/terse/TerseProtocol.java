package org.neo4j.terse;

import org.neo4j.terse.protocol.Entry;
import org.neo4j.terse.protocol.IndexEntry;

import java.util.Collection;
import java.util.Map;

/**
 * @author mh
 * @since 15.02.11
 */
public interface TerseProtocol {
    void store(Entry... things);

    Collection<Entry> load(long... ids);

    void delete(long... ids);

    void delete(Entry... things);

    void update(Entry... things);

    void info();

    void index(IndexEntry... entries);

    Map<String,Collection<Entry>> get(IndexEntry...entries);

    void traverse();


}
