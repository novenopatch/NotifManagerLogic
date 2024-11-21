package org.notif.manager.strategy;

public class PlainTextNotificationStrategy implements NotificationStrategy {
    @Override
    public String formatMessage(String message) {
    return message;
    }
}
