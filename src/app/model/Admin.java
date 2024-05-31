package app.model;

import java.util.HashMap;
import java.util.Map;

import app.tools.Database;

public class Admin extends Person {

    public Admin(String name, String phone, String email, String password) {
        super(name, phone, email, password);
    }

    public void lookupCarriersAndDeliveries() {
        HashMap<String, Shipper> shippers = Database.getShippers();
        for (Map.Entry<String, Shipper> entry : shippers.entrySet()) {
            Shipper shipper = entry.getValue();
            //System.out.println("Shipper: " + shipper.getName());
            //System.out.println("Deliveries:");
            lookupCarrierDeliveries(shipper);
            //System.out.println();
        }
    }

    public void lookupCarrierDeliveries(Shipper shipper) {
        HashMap<String, Shipment> shipments = Database.getShipments();
        for (Map.Entry<String, Shipment> entry : shipments.entrySet()) {
            Shipment shipment = entry.getValue();
            if (shipment.getShipper().equals(shipper)) {
                System.out.println("Tracking Number: " + shipment.getTrackingNumber());
                //System.out.println("Receiver: " + shipment.getRecipientName());
                //System.out.println("Status: " + shipment.getStatus());
                //System.out.println("Signed: " + shipment.isSigned());
            }
        }
    }
    
    public void listAllShipments() {
        System.out.println("All Shipments:");
        for (Map.Entry<String, Shipment> entry : Database.getShipments().entrySet()) {
            Shipment shipment = entry.getValue();
            //System.out.println(shipment);
        }
    }
}
