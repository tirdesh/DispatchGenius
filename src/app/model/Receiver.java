package app.model;

import app.tools.Preference;
import app.tools.ShipmentPool;

public class Receiver extends Person {
    private String address;
    private Preference preference;
    private ShipmentPool shipmentPool;

    public Receiver(String name, String phone, String email, String password) {
        super(name, phone, email, password);
    }

    public String getAddress() {
        return address;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public boolean queryDeliveryStatus(String trackingNumber) {
        if (shipmentPool.getShipmentMap().containsKey(trackingNumber)) {
            return shipmentPool.getShipmentMap().get(trackingNumber).isSigned();
        } else {
            System.out.println("Error: Shipment not found with tracking number " + trackingNumber);
            return false;
        }
    }
}
