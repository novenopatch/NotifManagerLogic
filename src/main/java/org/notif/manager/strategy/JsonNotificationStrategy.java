package org.notif.manager.strategy;

public class JsonNotificationStrategy implements NotificationStrategy {
    @Override
    public String formatMessage(String message) {
        return String.format("{\"message\":\"%s\"}", message.replace("\"", "\\\""));

    }
}
