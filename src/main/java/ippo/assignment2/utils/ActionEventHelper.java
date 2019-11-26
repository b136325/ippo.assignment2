package ippo.assignment2.utils;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ActionEventHelper {

    /**
     *
     * @param actionEvent
     * @return
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
