package org.notif.manager.observer;

import org.notif.manager.models.NotificationType;

public interface NotificationObserver {
    public void update(String message, NotificationType type);
}
