import java.io.Serializable;

public class GameSettings implements Serializable {
    private int graphicLevel;
    private String moveLeftKey;
    private String moveRightKey;
    private String moveBackwardKey;
    private String moveForwardKey;
    private String jumpKey;
    private String actionKey;
    private String inventoryKey;

    public GameSettings(int graphicLevel, String moveLeftKey, String moveRightKey,
                        String moveBackwardKey, String moveForwardKey,
                        String jumpKey, String actionKey, String inventoryKey) {
        this.graphicLevel = graphicLevel;
        this.moveLeftKey = moveLeftKey;
        this.moveRightKey = moveRightKey;
        this.moveBackwardKey = moveBackwardKey;
        this.moveForwardKey = moveForwardKey;
        this.jumpKey = jumpKey;
        this.actionKey = actionKey;
        this.inventoryKey = inventoryKey;
    }

    public int getGraphicLevel() {
        return graphicLevel;
    }

    public void setGraphicLevel(int graphicLevel) {
        this.graphicLevel = graphicLevel;
    }

    public String getMoveLeftKey() {
        return moveLeftKey;
    }

    public void setMoveLeftKey(String moveLeftKey) {
        this.moveLeftKey = moveLeftKey;
    }

    public String getMoveRightKey() {
        return moveRightKey;
    }

    public void setMoveRightKey(String moveRightKey) {
        this.moveRightKey = moveRightKey;
    }

    public String getMoveBackwardKey() {
        return moveBackwardKey;
    }

    public void setMoveBackwardKey(String moveBackwardKey) {
        this.moveBackwardKey = moveBackwardKey;
    }

    public String getMoveForwardKey() {
        return moveForwardKey;
    }

    public void setMoveForwardKey(String moveForwardKey) {
        this.moveForwardKey = moveForwardKey;
    }

    public String getJumpKey() {
        return jumpKey;
    }

    public void setJumpKey(String jumpKey) {
        this.jumpKey = jumpKey;
    }

    public String getActionKey() {
        return actionKey;
    }

    public void setActionKey(String actionKey) {
        this.actionKey = actionKey;
    }

    public String getInventoryKey() {
        return inventoryKey;
    }

    public void setInventoryKey(String inventoryKey) {
        this.inventoryKey = inventoryKey;
    }
}
