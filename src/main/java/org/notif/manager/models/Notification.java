package org.notif.manager.models;

import org.notif.manager.strategy.NotificationStrategy;
import org.notif.manager.utils.Constants;

import java.util.concurrent.CompletableFuture;

public abstract class Notification {
    private String message;
    private NotificationStrategy strategy;

    public Notification(String message, NotificationStrategy strategy) {
        this.message = message;
        this.strategy = strategy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message, NotificationStrategy strategy) {
        this.message = message;
        this.strategy = strategy;
    }
    public abstract void send();

    public NotificationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }
    public CompletableFuture<Void> sendAsync() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            if(Constants.DEBUG) {
                System.out.println("Call send()...");
            }
            send();
        }).thenRun(() ->{
            if(Constants.DEBUG){
                System.out.println("End async action.");
            }
        });

        try {
            future.join();
        } catch (Exception e) {
            if(Constants.DEBUG) {
                System.err.println("async run error : " + e.getMessage());

            }
        }

        return future;
    }


}
