# Geography

**Due:** Commit until **10:00 AM** on the day of lab sessions.

## Setup

Checkout project `Geography` from SVN. To submit, commit your changes.

## Part I

You've been given class definitions to represent a country and its 
geographic and administrative units: 
`Country`, `Region`, `Province`, `Town`.
First, take a look at these class definitions and get familiar with them.

Turkey's data in the [JSON](http://en.wikipedia.org/wiki/JSON) format is provided to you
in a `.json` file in the `data` folder. 
In this part of this assignment, you will read the data from the JSON file,
and build up country, region, province, town objects.
This should be done in the `JSONReader` class.

To process the JSON input, 
we will use [this JSON API](https://code.google.com/p/json-simple/).
Its `.jar` file is provided to you in the `lib` folder, and
it has been linked to the project.
Watch [this video](https://vimeo.com/122146680)
for an introduction to using the JSON library.

As you read data from JSON, you need to create in-memory 
`Country`, `Region`, `Province`, `Town` objects.
**You should not need to modify these classes;
in part 1, you only need to touch `JSONReader` and `Querier` classes.**
You may also want to write test cases, of course.

As you read the data, make sure that you do not create
more than one `Region` object for particular region.
E.g. there should not be two separate `Region` objects for MARMARA.

## Part II

Implement a GUI for Part I according to the MVC structure.
Skeleton files for the controller, view, and a `Main` file has been provided for you.
Here, the "model" is the `Country` that the controller is given to its
constructor. If you wish, you may create a private `Querier` object as well.

The GUI should provide the following features.
You are free to arrange the necessary view components
(e.g. buttons, labels, drop-down menus, etc.) the way you prefer.

* A `JList` of `Region`s. When I select a `Region`,
  I should get a list of its provinces.
  Also use a `JList` to display the provinces.
* When I pick a province, I should get a list of its towns,
and other information such as its population, plate ID, etc.
* I should be able to pick multiple `Region`s from the 
  `JList` of regions. See `MULTIPLE_INTERVAL_SELECTION` 
  [here](https://docs.oracle.com/javase/tutorial/uiswing/components/list.html#selection).
* There should be buttons to sort the list of provinces in ascending/descending
  order according to their population and name.
  
## Part III

The JSON file contains information about roads between provinces.
A _road_ connects province A to province B, and has a length (in kilometers).
Roads are bidirectional.
That is, if there is a road from A to B, it also means that there is a road from
B to A.

* Update your `JSONReader` to also parse the `roads` information.
  The `Province` class contains a list of `outgoingRoads`
  and an `add(Road road)` method. Use these to populate `Province`
  objects with roads. This way, you will be creating a graph of 
  `Province` objects connected via `Road`s.
   
* Find the shortest route from a province to another province.
  Implement this in the `getRoute` method of the `RoutePlanner` class,
  which returns a list of `Road`s.
  To find the shortest path,
  you will need to employ [Dijkstra's algorithm](https://en.wikipedia.org/wiki/Dijkstra's_algorithm).
  The basic outline of the algorithm on Wikipedia
  does a good job of laying out the steps to perform it.                                                                
  Think about how you can handle marking nodes as visited.
  It is up to you to determine how to do this.

## Grading

* Cleanness of Part I: 15%
* Cleanness of Part II: 15%
* Cleanness of Part III: 15%
* Correctness of Part I: 20%
* Correctness of Part II: 15%
* Correctness of Part III: 20%

