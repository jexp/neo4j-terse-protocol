package org.neo4j.terse;

import org.junit.Test;
import org.neo4j.terse.protocol.RelationshipEntry;

/**
 * @author mh
 * @since 16.02.11
 */
public class NeoBatchTest {
    @Test
    public void testBatchAddNodes() {
        new NeoBatch() {{
            node();
            update(relationship(0, 1, "r").with("a", "b").with("b", 1),
                   node(1).rels(2, 3, 4).with("a", "b").with("b", 1)
            );
            delete(1,2,3);
            delete(new RelationshipEntry(0, 1, "r").with("a", "b").with("b", 1));
            index(node().with("field","value"),relationship(1, 2, "x").with("field","value"));
        }}.run();
    }
}
