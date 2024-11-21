package org.notif.manager.models;

import org.notif.manager.singleton.NotificationManager;
import org.notif.manager.strategy.NotificationStrategy;

public class UrgentNotification extends Notification {
    public UrgentNotification(String message, NotificationStrategy strategy) {
        super(message, strategy);
    }

    @Override
    public void send() {
        String formatMessage = getStrategy().formatMessage("[Urgent] "+ getMessage());
        NotificationManager.INSTANCE.notify(formatMessage,NotificationType.Urgent);
    }
}
