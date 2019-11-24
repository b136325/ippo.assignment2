## IPPO Assignment 2

> A Java project for the second assignment for the IPPO module at the University of Edinburgh.

---

### Contents

- Overview
- Entry point
- Models
- Views
- Styling
- Controllers

---

### Overview

---

### Entry point

`main/java/ippo.assignment2.Main` is the entry point, and it calls `main/java/ippo.assignment2.App`.
`main/java/ippo.assignment2.App` derives a data service (using the `app.service` property from app.properties`).
It also loads the main view, `MainViewer.fxml`, and its associated controller, using the FXML loader.

---

### Models

---

### Views

The views for the application have been constructed using nested FXML markup (REFERENCE).
`MainViewer.fxml` is the parent view, and it defines the structure of how the child views fit together.
The child views have been designed with regard to a function separation of concerns. That is, each view performs a separate task.

The child views are as follows:
- `HeaderViewer.fxml`, which defines the components within the applications's header.
- `ImageViewer.fxml`, which will be used to display the current view or image.
- `NavigationViewer.fxml`, which handles user navigation.
- `PlayerItemsView.fxml`, which displays the players items. It also provides a 'putDown' button.
- `RoomItemsView.fxml`, which displays the room items. It also provides a 'pickDown' button.

There is a one to one relationship between views and controllers, and the controllers associated with each view has been defined within the view's FXML using the `fx:controller` tag.
Consequently, 

- `HeaderViewer.fxml` is associated with `HeaderObservableController`
- `ImageViewer.fxml` is associated with `ImageObservableController`
- `NavigationViewer.fxml` is associated with `NavigationObservableController`
- `PlayerItemsViewer.fxml` is associated with `PlayerItemsObservableController`
- `RoomItemsViewer.fxml` is associated with `RoomItemsObservableController`

---

### Styling
- https://raw.githubusercontent.com/dicolar/jbootx/master/src/main/resources/bootstrap3.css

### Controllers
- Guice


