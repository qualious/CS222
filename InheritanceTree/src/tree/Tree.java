package tree;

import java.util.*;

// You may add new methods and fields to this class
// as long as you do not change the signature of the given methods.
public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree(){this.root = null;}

    public Node getRoot() {
        return root;
    }

    public Node setRoot(Node root) {return this.root = root;}

    public Node lowestCommonParent(Node node1, Node node2) {
        // TODO
        List<Node> chain1 = getInheritenceChain(node1);
        List<Node> chain2 = getInheritenceChain(node2);

        for (Node firstNode : chain1) {
            for (Node secondNode : chain2) {
                if (firstNode.equals(secondNode))
                    return firstNode;
            }
        }

        return null;
    }

    private List<Node> getInheritenceChain(Node node) {
        List<Node> chain = new ArrayList<>();
        Node temp = new Node("temp");
        while (!temp.equals(root)) {
            temp = node;
            chain.add(temp);
            temp = temp.getParent();
        }
        return chain;
    }
}
