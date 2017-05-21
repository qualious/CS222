import org.junit.*;
import tree.*;

import static org.junit.Assert.*;

public class TreeTest {
    private static Tree tree;
    private static Node object = new Node("Object");
    private static Node collection = new Node("Collection");
    private static Node list = new Node("List");
    private static Node arrayList = new Node("ArrayList");
    private static Node linkedList = new Node("LinkedList");
    private static Node doublyLinkedList = new Node("DoublyLinkedList");
    private static Node circularList = new Node("CircularList");
    private static Node map = new Node("Map");
    private static Node hashMap = new Node("HashMap");
    private static Node set = new Node("Set");
    private static Node hashSet = new Node("HashSet");
    private static Node sortedSet = new Node("SortedSet");
    private static Node magicalSet = new Node("MagicalSet");
    private static Node string = new Node("String");

    @BeforeClass
    public static void buildTree() throws Exception {
        object.addChild(collection);
        object.addChild(string);

        collection.addChild(list);
        collection.addChild(map);
        collection.addChild(set);

        list.addChild(arrayList);
        list.addChild(linkedList);
        list.addChild(doublyLinkedList);
        list.addChild(circularList);

        map.addChild(hashMap);

        set.addChild(hashSet);
        set.addChild(sortedSet);

        sortedSet.addChild(magicalSet);

        tree = new Tree(object);
    }

    @Test
    public void testLCPObjectObject() throws Exception {
        Node lcp = tree.lowestCommonParent(object, object);
        assertSame(object, lcp);
    }

    @Test
    public void testLCPObjectString() throws Exception {
        Node lcp = tree.lowestCommonParent(object, string);
        assertSame(object, lcp);
    }

    @Test
    public void testLCPSortedSetSortedSet() throws Exception {
        Node lcp = tree.lowestCommonParent(sortedSet, sortedSet);
        assertSame(sortedSet, lcp);
    }

    @Test
    public void testLCPCollectionString() throws Exception {
        Node lcp = tree.lowestCommonParent(collection, string);
        assertSame(object, lcp);
    }

    @Test
    public void testLCPArrayListCircularList() throws Exception {
        Node lcp = tree.lowestCommonParent(arrayList, circularList);
        assertSame(list, lcp);
    }

    @Test
    public void testLCPArrayListMap() throws Exception {
        Node lcp = tree.lowestCommonParent(arrayList, map);
        assertSame(collection, lcp);
    }

    @Test
    public void testLCPLinkedListSortedSet() throws Exception {
        Node lcp = tree.lowestCommonParent(linkedList, sortedSet);
        assertSame(collection, lcp);
    }

    @Test
    public void testLCPStringHashMap() throws Exception {
        Node lcp = tree.lowestCommonParent(string, hashMap);
        assertSame(object, lcp);
    }

    @Test
    public void testLCPMagicalSetSet() throws Exception {
        Node lcp = tree.lowestCommonParent(magicalSet, set);
        assertSame(set, lcp);
    }

    @Test
    public void testLCPHashMapCollection() throws Exception {
        Node lcp = tree.lowestCommonParent(hashMap, collection);
        assertSame(collection, lcp);
    }
}
