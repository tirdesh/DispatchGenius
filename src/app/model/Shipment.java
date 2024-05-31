package app.model;

public class Shipment {
    private String trackingNumber;
    private String receiverName;
    private boolean isSigned;
    private String status;
    private Shipper shipper;

    public Shipment(String trackingNumber, String receiverName, Shipper shipper) {
        this.trackingNumber = trackingNumber;
        this.receiverName = receiverName;
        this.shipper = shipper;
        this.isSigned = false;
        this.status = "No tracing";
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getRecipientName() {
        return receiverName;
    }

    public void setRecipientName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    @Override
    public String toString() {
        return "Shipment Info:\nTracking Number: " + trackingNumber + "\nRecipient: " + receiverName + "\nSigned: " + isSigned + "\nCarrier: " + shipper.getName();
    }
}
