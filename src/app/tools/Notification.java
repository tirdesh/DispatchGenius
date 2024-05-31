package app.tools;

import app.model.Receiver;

public class Notification {
    private Receiver receiver;
    private String message;
    private boolean isRead;

    public Notification(Receiver receiver, String message) {
        this.receiver = receiver;
        this.message = message;
        this.isRead = false;
    }

    public Receiver getRecipient() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
