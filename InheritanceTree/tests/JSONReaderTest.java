import org.junit.Test;
import tree.*;
import java.io.*;
import java.util.List;

import static org.junit.Assert.*;

public class JSONReaderTest {
    @Test
    public void testTwoFiles() throws Exception {
        JSONReader reader = new JSONReader();
        Tree ignored = reader.parseTreeFrom("data/tree1.json");
        Tree tree2 = reader.parseTreeFrom("data/tree2.json");
        Tree tree1 = reader.parseTreeFrom("data/tree1.json");
        Node root1 = tree1.getRoot();
        Node root2 = tree2.getRoot();
        assertNotEquals(root1, root2);
    }

    @Test
    public void testTree1Root() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree1.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals("A", root.getName());
    }

    @Test
    public void testTree1Children() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree1.json");
        Node root = tree.getRoot();
        assertNotNull(root);

        assertEquals(3, root.getChildren().size());
        assertNotNull(root.getChildNamed("B"));
        assertNotNull(root.getChildNamed("C"));
        assertNotNull(root.getChildNamed("D"));
    }

    @Test
    public void testTree1GrandChildren() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree1.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        Node D = root.getChildNamed("D");
        assertNotNull(D);
        assertEquals(1, D.getChildren().size());
        assertNotNull(D.getChildNamed("E"));
    }

    @Test
    public void testTree2Root() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree2.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals("Object", root.getName());
        assertEquals(2, root.getChildren().size());
        assertNotNull(root.getChildNamed("Collection"));
        assertNotNull(root.getChildNamed("String"));
    }

    @Test
    public void testTree2Collection() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree2.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        Node collection = root.getChildNamed("Collection");
        assertNotNull(collection);
        assertEquals(3, collection.getChildren().size());
        assertNotNull(collection.getChildNamed("List"));
        assertNotNull(collection.getChildNamed("Map"));
        assertNotNull(collection.getChildNamed("Set"));
    }

    @Test
    public void testTree2List() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree2.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        Node collection = root.getChildNamed("Collection");
        assertNotNull(collection);
        Node list = collection.getChildNamed("List");
        assertNotNull(list);
        assertEquals(4, list.getChildren().size());
        assertNotNull(list.getChildNamed("ArrayList"));
        assertNotNull(list.getChildNamed("LinkedList"));
        assertNotNull(list.getChildNamed("DoublyLinkedList"));
        assertNotNull(list.getChildNamed("CircularList"));
    }

    @Test
    public void testTree2Map() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree2.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        Node collection = root.getChildNamed("Collection");
        assertNotNull(collection);
        Node map = collection.getChildNamed("Map");
        assertNotNull(map);
        assertEquals(1, map.getChildren().size());
        assertNotNull(map.getChildNamed("HashMap"));
    }

    @Test
    public void testTree2Set() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree2.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        Node collection = root.getChildNamed("Collection");
        assertNotNull(collection);
        Node set = collection.getChildNamed("Set");
        assertNotNull(set);
        assertEquals(2, set.getChildren().size());
        assertNotNull(set.getChildNamed("HashSet"));
        assertNotNull(set.getChildNamed("SortedSet"));
    }

    @Test
    public void testTree2SortedSet() throws Exception {
        JSONReader reader = new JSONReader();
        Tree tree = reader.parseTreeFrom("data/tree2.json");
        Node root = tree.getRoot();
        assertNotNull(root);
        Node collection = root.getChildNamed("Collection");
        assertNotNull(collection);
        Node set = collection.getChildNamed("Set");
        assertNotNull(set);
        Node sortedSet = set.getChildNamed("SortedSet");
        assertNotNull(sortedSet);
        assertEquals(1, sortedSet.getChildren().size());
        assertNotNull(sortedSet.getChildNamed("MagicalSet"));
    }
}
