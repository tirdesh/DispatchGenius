package app.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import app.model.*;

public class Database {

    private static HashMap<String, Shipper> shippers;
    private static HashMap<String, Receiver> receivers;
    private static HashMap<String, Shipment> shipments;
    private static HashMap<String, Admin> admins;
    private static Random random = new Random();
    private static HashMap<String, Appointment> appointments;
    private static HashMap<Shipper, List<Integer>> ratings;
    private static String currentuser;



    public Database() {
    	
        shippers = new HashMap<>();
        receivers = new HashMap<>();
        shipments = new HashMap<>();
        admins = new HashMap<>();
        appointments = new HashMap<>();
        ratings = new HashMap<>();

        Shipper shipper = new Shipper("shipper", "shipper", "shipper@neu.com", "shipper");
        shippers.put("shipper", shipper);

        Receiver receiver = new Receiver("receiver", "receiver", "receiver@neu.com", "receiver");
        receivers.put("receiver", receiver);

        Admin admin = new Admin("admin", "admin", "admin@neu.com", "admin");
        admins.put("admin", admin);

        addShipment("666", "del1", shipper); 
        addShipment("888", "del2", shipper); 
        
        generateRandomShipments(30);
        admin.listAllShipments();
        System.out.println("Done");
        admin.lookupCarrierDeliveries(shippers.get(shipper.getName()));
        
    }
    
    public static void generateRandomShipments(int numShipments) {
    	
        generateRandomShippers();
        generateRandomReceivers();
        
        String[] choices = {"Scan and scan to storage", "Ready to Shipment", "On the way", "Arrived"};
        
        HashMap<String, Shipper> shippers = getShippers();
        HashMap<String, Receiver> receivers = getReceivers();

        for (int i = 0; i < numShipments; i++) {
            // Generate random tracking number
            String trackingNumber = generateRandomTrackingNumber();

            // Randomly select shipper and receiver
            Shipper shipper = shippers.get(shippers.keySet().toArray()[random.nextInt(shippers.size())]);
            Receiver receiver = receivers.get(receivers.keySet().toArray()[random.nextInt(receivers.size())]);

            // Add shipment to database
            Shipment s = addShipment(trackingNumber, receiver.getName(), shipper);
            s.setStatus(choices[random.nextInt(choices.length)]);
            // System.out.println("Shipment added: Tracking Number = " + trackingNumber +", Receiver = " + receiver.getName() + ", Shipper = " + shipper.getName());
        }
    }

 // Method to generate random shippers
    private static void generateRandomShippers() {
        for (int i = 0; i < 5; i++) { // Generate 5 random shippers
            String name = "Shipper" + (i + 1);
            String phone = "shipperPhone" + (i + 1);
            String email = "shipper" + (i + 1) + "@example.com";
            String password = "password" + (i + 1);
            shippers.put(name, new Shipper(name, phone, email, password));
        }
    }

    // Method to generate random receivers
    private static void generateRandomReceivers() {
        for (int i = 0; i < 5; i++) { // Generate 5 random receivers
            String name = "Receiver" + (i + 1);
            String phone = "receiverPhone" + (i + 1);
            String email = "receiver" + (i + 1) + "@example.com";
            String password = "password" + (i + 1);
            receivers.put(name, new Receiver(name, phone, email, password));        
            }
    }
    
    // Method to generate a random tracking number
    private static String generateRandomTrackingNumber() {
        StringBuilder sb = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 8; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    

    public static HashMap<String, Shipper> getShippers() {
        return shippers;
    }

    public static HashMap<String, Receiver> getReceivers() {
        return receivers;
    }

    public static HashMap<String, Shipment> getShipments() {
        return shipments;
    }

    public static HashMap<String, Admin> getAdmins() {
        return admins;
    }

    public void addShipper(String name, String phone, String email, String password) {
        shippers.put(name, new Shipper(name, phone, email, password));
    }
    
    public static void addAppointment(Appointment appointment) {
        appointments.put(appointment.getId(), appointment);
    }

    public void addReceiver(String name, String phone, String email, String password) {
        receivers.put(name, new Receiver(name, phone, email, password));
    }

    public static Shipment addShipment(String trackingNumber, String receiverName, Shipper shipper) {
        Shipment s = new Shipment(trackingNumber, receiverName, shipper);
    	shipments.put(trackingNumber, s);
        return s;
    }

    public static Shipper findCarrier(String userName) {
        return shippers.get(userName);
    }

    public static String getCarrierPassword(Shipper shipper) {
        return shipper.getPassword();
    }

    public static boolean checkCarrierValid(String userName, String password) {
        Shipper shipper = findCarrier(userName);
        return shipper != null && shipper.getPassword().equals(password);
    }

    public static Receiver findRecipient(String userName) {
        return receivers.get(userName);
    }

    public static String getRecipientPassword(Receiver receiver) {
        return receiver.getPassword();
    }

    public static boolean checkRecipientValid(String userName, String password) {
        Receiver receiver = findRecipient(userName);
        return receiver != null && receiver.getPassword().equals(password);
    }
    
    public static boolean checkAdminValid(String userName, String password) {
        return userName != "admin" && "admin".equals(password);
    }

    public static Shipment findDelivery(String trackingNumber) {
        return shipments.get(trackingNumber);
    }

    public static boolean getDeliveryStatus(String trackingNumber) {
        Shipment shipment = findDelivery(trackingNumber);
        return shipment != null && shipment.isSigned();
    }
    public static void storeRating(Shipper shipper, int rating) {
        if (!ratings.containsKey(shipper)) {
            ratings.put(shipper, new ArrayList<>());
        }
        ratings.get(shipper).add(rating);
        System.out.println(ratings);
    }
    public static List<Integer> getShipperRatings(Shipper shipper) {
        if (ratings.containsKey(shipper)) {
            return ratings.get(shipper);
        }
        return new ArrayList<>();
    }
    public static double getShipperRatingAverage(Shipper shipper) {
        List<Integer> shipperRatings = getShipperRatings(shipper);
        if (shipperRatings.isEmpty()) {
            return 4.3; 
        }

        double totalRating = 4.3;
        for (int rating : shipperRatings) {
            totalRating += rating;
        }
        System.out.print("Ave-"+(double) totalRating / (shipperRatings.size()+1));
        return (double) totalRating / (shipperRatings.size()+1);
    }

	public static HashMap<String, Appointment> getAppointments() {
		return appointments;
	}

	public static void setAppointments(HashMap<String, Appointment> appointments) {
		Database.appointments = appointments;
	}

	public static String getCurrentuser() {
		return currentuser;
	}

	public static void setCurrentuser(String currentuser) {
		Database.currentuser = currentuser;
	}
}
