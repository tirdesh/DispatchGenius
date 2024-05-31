package app.tools;

import java.util.Collection;
import java.util.HashMap;

import app.model.Shipment;

public class ShipmentPool {
	private HashMap<String, Shipment> shipmentMap;

	public ShipmentPool() {
		this.shipmentMap = new HashMap<String, Shipment>();
	}

	public HashMap<String, Shipment> getShipmentMap() {
		return shipmentMap;
	}

	public void setShipmentMap(HashMap<String, Shipment> shipmentMap) {
		this.shipmentMap = shipmentMap;
	}	
	
	public Collection<Shipment> getDeliveries() {
		return shipmentMap.values();
	}
	
}
