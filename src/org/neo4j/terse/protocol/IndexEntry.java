package org.neo4j.terse.protocol;

/**
* @author mh
* @since 16.02.11
*/
public class IndexEntry {
    final String index;
    final long id;
    final String property;
    final Object value;

    public IndexEntry(String index, Entry target, String property, Object value) {
        this.index=index;
        this.id = target.id;
        this.property = property;
        this.value = value;
    }
}
