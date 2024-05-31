package app.model;


public class Appointment {
	private final String id;
	private String contains;
	private String address;
	private String scheduled;
	private String destination;
	
	public Appointment(String contains, String address, String scheduled, String destination)
	{
		this.id = generateUniqueId();
		this.setContains(contains);
		this.setAddress(address);
		this.setScheduled(scheduled);
		this.setDestination(destination);
		
		}
	
//	 public String contains() {
//	        return contains;
//	    }
//	 public String scheduled() {
//	        return scheduled;
//	    }
//	 public String destination() {
//	        return destination;
//	    }
//	 public String address() {
//	        return address;
//	    }
//	 public void setAddress(String address) {
//	        this.address = address;
//	    }
//	 public void setcontains(String contains) {
//	        this.setContains(contains);
//	    }
//	 public void setdestination(String destination) {
//	        this.destination = destination;
//	    }
//	 public void setscheduled(String scheduled) {
//	        this.scheduled = scheduled;
//	    }
	 private String generateUniqueId() {
	        return "appointment-" + System.currentTimeMillis();
	    }
//
//	    public String getId() {
//	        return id;
//	    }

		public String getContains() {
			return contains;
		}

		public void setContains(String contains) {
			this.contains = contains;
		}

		public String getId() {
			return id;
		}

		

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public String getScheduled() {
			return scheduled;
		}

		public void setScheduled(String scheduled) {
			this.scheduled = scheduled;
		}

		

}
