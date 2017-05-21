package tree;

import java.util.LinkedList;
import java.util.List;

/** DO NOT CHANGE THIS CLASS **/

public class Node {
    private String name;
    private Node parent;
    private List<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChild(Node child) {
        children.add(child);
        child.setParent(this);
    }

    public Node getChildNamed(String childName) {
        for (Node child : children) {
            if (childName.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        Node node = (Node) that;
        return name.equals(node.name);
    }

    @Override
    public String toString(){
        return name;
    }
}
