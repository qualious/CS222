package tree;

import org.json.simple.*;
import java.io.*;
import java.util.*;

public class JSONReader {

    // You may add new methods and fields to this class
    // as long as you do not change the signature of the 'parseTreeFrom' method.

    private JSONArray relations;
    private Tree tree = new Tree();
    private List<Node> parentList = new ArrayList<>();

    public Tree parseTreeFrom(String fileName) throws Exception {
        parseObjects(fileName);
        for (Object relation: relations){
            JSONObject thisObject = (JSONObject) relation;
            Node thisNode = new Node(thisObject.get("parent").toString());
            if(parentList.contains(thisNode))
                setParentAndChild(thisObject, thisNode);
            else
                setParentRootandChild(thisObject, thisNode);
        }
        return tree;
    }

    private void parseObjects(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        JSONObject jsonObject = (JSONObject) JSONValue.parse(fileReader);
        relations = (JSONArray) jsonObject.get("relations");
        tree = new Tree();
    }

    private void setParentAndChild(JSONObject thisObject, Node thisNode){
        Node child = new Node(thisObject.get("child").toString());
        child.setParent(thisNode);
        parentList.add(thisNode);
        if(tree.getRoot().equals(thisNode))
            tree.getRoot().addChild(child);
        else
            tree.getRoot().getChildNamed(thisNode.getName()).addChild(child);
    }

    private void setParentRootandChild(JSONObject thisObject, Node thisNode){
        try {
            if(!thisNode.getParent().getName().isEmpty())
                tree.getRoot().addChild(thisNode);
        }catch (NullPointerException e){
            tree.setRoot(thisNode);
        }
        setParentAndChild(thisObject,thisNode);
    }
}
