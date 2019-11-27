package ippo.assignment2.utils;

import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * A helper class for ActionEvents.
 *
 * @since 0.3.1
 */
public class ActionEventHelper {

    /**
     * Derive an Item index value from the Node ID associated with an Action Event.
     *
     * @param actionEvent The ActionEvent whose Node ID will be transformed into an Item index.
     * @return The Item index as an integer.
     *
     * @since 0.3.1
     */
    public static Integer deriveItemIndex(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String nodeId = node.getId();

        String itemIndexString = nodeId.replaceAll("[^\\d.]", "");
        Integer itemIndex = Integer.parseInt(itemIndexString);
        itemIndex = itemIndex -1;

        return itemIndex;
    }
}
