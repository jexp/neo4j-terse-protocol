package org.neo4j.terse.protocol;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mh
 * @since 15.02.11
 */
public class SerializerTest {

    @Test
    public void testSerializeNodeWithData() {
        StringBuilder json = new StringBuilder();
        new Serializer().addEntry(json,new NodeEntry(1).with("a", "b").with("b", 1));
        assertEquals("1:{\"data\":{\"b\":1,\"a\":\"b\"}}",json.toString());
    }
    @Test
    public void testSerializeRelationshipWithData() {
        StringBuilder json = new StringBuilder();
        Entry rel = new RelationshipEntry(0, 1, "r").with("a", "b").with("b", 1);
        new Serializer().addEntry(json, rel);
        assertEquals(rel.id+":{\"data\":{\"b\":1,\"a\":\"b\"},\"nodes\":[0,1,\"r\"]}",json.toString());
    }

    @Test(timeout = 500)
    public void testSerializeSpeed() {
        final int COUNT = 10000;
        Serializer serializer = new Serializer();
        Entry node = new NodeEntry(1).rels(2, 3, 4).with("a", "b").with("b", 1);
        Entry rel = new RelationshipEntry(0, 1, "r").with("a", "b").with("b", 1);
        StringBuilder json = new StringBuilder(COUNT * 100);
        long time = System.currentTimeMillis();
        for (int i=0;i< COUNT;i++) {
            serializer.addEntry(json,node);
            serializer.addEntry(json,rel);
        }
        time = System.currentTimeMillis()-time;
        //System.out.println("time = " + time+ " "+json.length()/COUNT);
    }
}
