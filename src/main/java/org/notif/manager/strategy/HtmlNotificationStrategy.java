package org.notif.manager.strategy;

public class HtmlNotificationStrategy implements NotificationStrategy {
    @Override
    public String formatMessage(String message) {
    return "<html><body><h1>" +message+"</h1></body></html>";
    }
}
