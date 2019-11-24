## IPPO Assignment 2

> A Java project for the second assignment for the IPPO module at the University of Edinburgh.

---

### Contents

- Overview
- Models
- Views
- Controllers

---

### Overview

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

### Controllers



