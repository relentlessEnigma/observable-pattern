package com.mycompany.condominium.utilities;

import java.util.Vector;

public abstract class Observable<T extends Observer > {

    Vector<T> subscribers = new Vector<>();

    public void subscribe(T sub) {
        subscribers.add(sub);
    }

    public void unsubscribe(T sub) {
        subscribers.remove(sub);
    }

    public void notifySubscribers(Object args) {
        subscribers.forEach(sub -> sub.update(args));
    }
}
