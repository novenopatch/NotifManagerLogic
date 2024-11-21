package org.notif.manager.factory;

import org.notif.manager.models.*;
import org.notif.manager.strategy.HtmlNotificationStrategy;
import org.notif.manager.strategy.JsonNotificationStrategy;
import org.notif.manager.strategy.PlainTextNotificationStrategy;

public class NotificationFactory {
    public static Notification createNotification(String message,NotificationType type) {
        return switch (type){
            case UKNOWN -> new UnknownNotification(message,new HtmlNotificationStrategy());
            case Urgent -> new UrgentNotification(message,new JsonNotificationStrategy());
            case INFO -> new InfoNotification(message,new PlainTextNotificationStrategy());
        };
    }
}
