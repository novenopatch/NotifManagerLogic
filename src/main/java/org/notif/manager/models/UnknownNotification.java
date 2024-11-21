package org.notif.manager.models;

import org.notif.manager.singleton.NotificationManager;
import org.notif.manager.strategy.NotificationStrategy;

public class UnknownNotification extends Notification {
    public UnknownNotification(String message, NotificationStrategy strategy) {
        super(message,strategy);
    }
    @Override
    public void send() {
        String formatMessage = getStrategy().formatMessage("[Unknown] "+ getMessage());
        NotificationManager.INSTANCE.notify(formatMessage,NotificationType.UKNOWN);
    }
}
