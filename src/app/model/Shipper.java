package app.model;

import app.tools.ShipmentPool;

public class Shipper extends Person {
    private int rating;
    private ShipmentPool shipmentPool;

    public Shipper(String name, String phone, String email, String password) {
        super(name, phone, email, password);
    }

    public void scanDelivery(Shipment shipment) {
        shipmentPool.getShipmentMap().put(shipment.getTrackingNumber(), shipment);
    }

    public void changeStatus(String trackingNumber, boolean signed) {
        if (shipmentPool.getShipmentMap().containsKey(trackingNumber)) {
            shipmentPool.getShipmentMap().get(trackingNumber).setSigned(signed);
        } else {
            System.out.println("Error: Shipment not found with tracking number " + trackingNumber);
        }
    }

    public void printInfo() {
        System.out.println("Shipper Name: " + getName());
        System.out.println("Shipper Phone: " + getPhone());
        System.out.println("Shipper Rating: " + rating);
    }

    public void uploadDestinationImage() {
        System.out.println("Destination image uploaded successfully.");
    }
}
