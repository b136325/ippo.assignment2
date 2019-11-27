## IPPO Assignment 2

> A Java project for the second assignment for the IPPO module at the University of Edinburgh.

---

### Contents

- Overview
- Changes from the initial design
- Navigation
- Entry point
- Models
   - Direction
   - Item
   - Player
   - Room
   - Wall
 - Collections
- Views
  - Styling
- Controllers
- Controllers and data
- Properties
- Resources
- JSON

---

### Overview

---

### Navigation

---

### Changes from the initial design

---

### Entry point

`main/java/ippo.assignment2.Main` is the entry point, and it calls `main/java/ippo.assignment2.App`.
`main/java/ippo.assignment2.App` derives a data service (using the `app.service` property from app.properties`).
It also loads the main view, `MainViewer.fxml`, and its associated controller, using the FXML loader.

---

### Models

The application makes use of five models. They are as follows:

##### Direction

Aan Enum class of directions.


##### Item

A models representing both 'player' and 'room' items.

##### Player

A player model, which contains references to the current room, along with the 'player' items.
The player model also supports navigation methods, such as 'turn' and 'moveForward', along with 
item related methods, such as 'pickUp' and 'putDown'. 
In addition the player model implements the Observable interface.
          
##### Room

A room model, which contains walls.

##### Wall

A wall model which may contain an image, and or a reference to another room.

The code for the models can be found within `main/java/ippo/assignment2/models` and the associated JUnit tests can be found at `test/java/ippo/assignment2/models`.

---

#### Collections

- Items: a collection of Item models, which makes use of a `HashSet` data structure. Per collection, Items are unique. 
- Walls: a collection of Wall models keyed by a Direction, and which makes use of `HashMap` data structure.

The items associated with both players and rooms are stored in Items collections.
The Wall objects within a Room are stored using a Walls collections. 

The code for the collections can be found within `main/java/ippo/assignment2/collections` and the associated JUnit tests can be found at `test/java/ippo/assignment2/collections`.

---

### Views

The views for the application have been constructed using nested FXML markup.
`MainViewer.fxml` is the parent view, and it defines the structure of how the child views are organised.
The child views have been designed with regard to a function separation of concerns. That is, each view performs a separate front-end task.

The child views are as follows:
- `HeaderViewer.fxml`, which defines the components within the applications's header.
- `ImageViewer.fxml`, which will be used to display the current view or image.
- `NavigationViewer.fxml`, which handles user navigation.
- `PlayerItemsView.fxml`, which displays the players items. It also provides a 'putDown' button.
- `RoomItemsView.fxml`, which displays the room items. It also provides a 'pickDown' button.

There is a one to one relationship between views and controllers, and the controller associated with each view has been specified using the `fx:controller` tag.

The code for the views can be found within `main/reaources/fxml`. 

---

#### Styling

The styling of the views uses the Twitter Bootstrap CSS theme. This is a widely used theme, familiar to both developers and users. 

The code for the theme can be found at `main/reaources/css/bootrap2.css`. 

---

### Controllers

With the exception of `MainController`, all of the child controllers inherit from `AbstractObserverController`, which means that they implement the Observer interface.
The child controllers will thus be updated when the Observable model, player, changes.
Each of the child controllers has an `updateView` method and it is that method that perform the update following a change to the player model.

The child controllers are as follows:
- `HeaderController`
- `ImageController`
- `NavigationController`
- `PlayerItemsController`
- `RoomItemsController`

The code for the controllers can be found within `main/java/ippo/assignment2/controllers`.

In addition, integration tests have been written for the controllers and the views using both JUnit and TestFX.
The integration tests can be found within `test/java/ippo/assignment2/controllers`.

### Controllers and data

As mentioned above, `main/java/ippo.assignment2.App` makes uses of a data service (identified using the `app.service` property from `app.properties`).
The property name is passed to the `ServicesFactory` to create the appropriate factory, which by default is the `Players` service.
Once `main/java/ippo.assignment2.App` has accessed the service it passes a player model to `MainController` via the `setPlayer` controller method.
In turn, `MainController` passes the player to the child controllers. It also registers the child controllers to be updated when the player model changes.

The code for `ServicesFactory` can be found at `main/java/ippo/assignment2/factories/ServiceFactory`, and the associated JUnit tests can be found at `test/java/ippo/assignment2/factories/ServiceFactory`.
Also, the code for the `Players` service can be found at `main/java/ippo/assignment2/services/Player`, and the associated JUnit tests can be found at `test/java/ippo/assignment2/services/Player`.

---

### Properties

Configuration properties (such as those defined within `main/reaources/properties`) are made available within the application via PropertiesSingleton class.
The code for the controllers can be found at `main/java/ippo/assignment2/properties/PropertiesSingleton`, and the associated JUnit tests can be found at `test/java/ippo/assignment2/properties/PropertiesSingleton`.

---

### Resources

With the exception of the views, which are loaded using the `FXMLLoader`, all other resources are loaded using methods found within the `ResourceFileLoader`.
The code for the controllers can be found at `main/java/ippo/assignment2/loaders/ResourceFileLoader`, and the associated JUnit tests can be found at `test/java/ippo/assignment2/loaders/ResourceFileLoader`.

---

### JSON

When the application makes use of data build from JSON, such data can be found within `resources/JSON`.
The JSON is parsed using the `JsonFileParser`, and the output of the parser are passed to the `JsonModelBuilder`,
which uses the parsed JSON to build models.

The code for `JsonFileParser` can be found at `main/java/ippo/assignment2/parsers/JsonFileParser`, and the associated JUnit tests can be found at `test/java/ippo/assignment2/parsers/JsonFileParser`.
The code for `JsonModelBuilder` can be found at `main/java/ippo/assignment2/builders/JsonModelBuilder`, and the associated JUnit tests can be found at `test/java/ippo/assignment2/builders/JsonModelBuilder`.