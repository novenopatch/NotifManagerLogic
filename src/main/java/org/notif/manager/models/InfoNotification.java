package org.notif.manager.models;

import org.notif.manager.singleton.NotificationManager;
import org.notif.manager.strategy.NotificationStrategy;

public class InfoNotification extends Notification {
    public InfoNotification(String message, NotificationStrategy strategy) {
        super(message,strategy);
    }
    @Override
    public void send() {
        String formatMessage = getStrategy().formatMessage("[info] "+ getMessage());
        NotificationManager.INSTANCE.notify(formatMessage,NotificationType.INFO);
    }
}
