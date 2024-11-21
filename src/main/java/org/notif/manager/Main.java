package org.notif.manager;

import org.notif.manager.factory.NotificationFactory;
import org.notif.manager.models.Notification;
import org.notif.manager.models.NotificationType;
import org.notif.manager.observer.EmailNotificationObserver;
import org.notif.manager.observer.PushNotificationObserver;
import org.notif.manager.observer.SmsNotificationObserver;
import org.notif.manager.singleton.NotificationManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationManager manager = NotificationManager.INSTANCE;
        manager.addObserver(new EmailNotificationObserver());
        manager.addObserver(new SmsNotificationObserver());
        manager.addObserver(new PushNotificationObserver());


        Notification urgentNotif = NotificationFactory.createNotification("System error detected!", NotificationType.Urgent);
        Notification infoNotif = NotificationFactory.createNotification("System backup run successfully", NotificationType.INFO);

        Notification otherNotif = NotificationFactory.createNotification("Other info on system", NotificationType.UKNOWN);

        urgentNotif.sendAsync();
        infoNotif.sendAsync();
        otherNotif.sendAsync();

    }
}