package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ObservableTest {

    @AfterEach
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Observable.getInstance().deleteInstance();
    }

    @Test
    void getInstance() {
        Assertions.assertNotNull(Observable.getInstance());
    }

    @Test
    void addSubscriber() {
        //given
        Object y = new Object();
        //when
        Observable.getInstance().addSubscriber(y);
        //then
        Assertions.assertEquals(y, Observable.getInstance().getListOfSubscribers().get(0));
    }

    @Test
    void removeSubscriber() {

        //given
        Object y = new Object();
        Observable.getInstance().addSubscriber(y);

        //when
        Observable.getInstance().removeSubscriber(y);

        //then
        Assertions.assertEquals(0, Observable.getInstance().getListOfSubscribers().size());
    }

    @Test
    void getListOfSubscribers() {
        //given
        Object y = new Object();
        ArrayList<Object> z = new ArrayList<>();
        z.add(y);
        z.add(y);
        Observable.getInstance().addSubscriber(y);
        Observable.getInstance().addSubscriber(y);

        //then
        Assertions.assertEquals(z, Observable.getInstance().getListOfSubscribers());
    }
}