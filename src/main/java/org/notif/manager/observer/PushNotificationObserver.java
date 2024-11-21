package org.notif.manager.observer;

import org.notif.manager.models.NotificationType;

public class PushNotificationObserver implements NotificationObserver {
    @Override
    public void update(String message, NotificationType type) {
        System.out.println("Send Message Push:"+message);

    }
}
