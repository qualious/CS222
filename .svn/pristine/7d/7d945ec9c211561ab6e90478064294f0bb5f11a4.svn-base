# InheritanceTree

**NOTES:**

* There are two tasks. They can be attacked indepedently
from each other. Even if you can't solve Task 1, you may able
to get full credit from Task 2. Unit tests are designed this way.
* You do NOT have to write test cases.
* Do NOT wait until the very last minute to commit your files. Commit often.
* Your correctness scores will be determined based on the test cases your code passes.

## Problem

An _inheritance tree_ is a tree where each node, except the root,
has a single parent, and any node may have children.
The node that does not have any parent is the root of the tree.
For instance, below is a possible inheritance tree of
classes in a library.
Here, the root of the tree is `Object`.

```
Object
├── Collection
│   ├── List
│   │   ├── ArrayList
│   │   ├── LinkedList
│   │   ├── DoublyLinkedList
│   │   └── CircularList
│   ├── Map
│   │   └── HashMap
│   └── Set
│       ├── HashSet
│       └── SortedSet
│           └── MagicalSet
└── String
```

You are given `Node` and `Tree` classes that will be used to represent
inheritance trees.

## Task I

You will be given a JSON file that contains parent-child relationships.
You may assume that JSON file represents a valid inheritance tree;
you do not have to deal with badly-formed data.
A sample file is given in the `data` folder.

Implement the `JSONReader` class to read the JSON file, and 
build a `Tree` object.

## Task II

Implement the `lowestCommonParent` method in the `Tree` class.
This class, given two `Node`s, should return the lowest node that is common
in the inheritance path of the two nodes.
You may assume that you will always be given `Node` objects that exist in the tree.

Examples: The lowest common parent of 

* `ArrayList` and `CircularList` is `List`
* `ArrayList` and `Map` is `Collection`
* `LinkedList` and `SortedSet` is `Collection`
* `String` and `HashMap` is `Object`
* `MagicalSet` and `Set` is `Set`
* `HashMap` and `Collection` is `Collection`

### Suggested Algorithm

For both `node1` and `node2`, find the inheritance chain that
starts at the root, and goes all the way down to the nodes.
Then, compare the two chains element-wise, and find the last
element where the corresponding nodes are equal. 
E.g.: For `LinkedList`, the chain is 
`Object -> Collection -> List -> LinkedList`.
For `Map`, it is 
`Object -> Collection -> Map`.
The last element for which the chains are equal is `Collection`.
  
## Grading

* Cleanness of Task I: 25%
* Correctness of Task I: 25%
* Cleanness of Task II: 25%
* Correctness of Task II: 25%

**NOTE:** Correctness scores will be determined automatically 
according to the test cases you pass.
Each test in `JSONReaderTest` is worth 2.5%.
Each test in `TreeTest` is worth 2.5%.
