package org.notif.manager.singleton;

import org.notif.manager.models.NotificationType;
import org.notif.manager.observer.NotificationObserver;
import org.notif.manager.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public enum NotificationManager {
    INSTANCE;

    private final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public void removeObserver(NotificationObserver observer) {
        synchronized (observers) {
            observers.remove(observer);
        }
    }

    public void notify(String message, NotificationType type) {
        synchronized (observers) {
            for (NotificationObserver observer : observers) {
                observer.update(message, type);
            }
            if(Constants.DEBUG){
                System.out.println("End run----------------------");
                System.out.println();

            }
        }
    }
}
