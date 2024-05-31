package app.tools;

public class Preference {
    private String shipmentMethod;
    private String notificationFrequency;
    
    public Preference(String shipmentMethod, String notificationFrequency) {
        this.shipmentMethod = shipmentMethod;
        this.notificationFrequency = notificationFrequency;
    }
    
    public String getDeliveryMethod() {
        return shipmentMethod;
    }

    public void setDeliveryMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public String getNotificationFrequency() {
        return notificationFrequency;
    }

    public void setNotificationFrequency(String notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }
}
