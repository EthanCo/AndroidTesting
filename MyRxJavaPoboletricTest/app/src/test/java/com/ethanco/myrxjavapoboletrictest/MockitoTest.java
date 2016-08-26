package com.ethanco.myrxjavapoboletrictest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by EthanCo on 2016/8/25.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MockitoTest {
    private ArrayList list;

    @Before
    public void setUp() {

    }

    @Test
    public void MocksTest() {
        TestSubscriber<Bean> testSubscriber = new TestSubscriber<>();
        getMocks().subscribe(testSubscriber);
        assertThat(testSubscriber.getOnNextEvents().size(), is(3));
    }

    @Test
    public void ListMocksTest() {
        TestSubscriber<Bean> testSubscriber = new TestSubscriber<>();
        getListMocks().flatMap(Observable::from).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(list);
        assertThat(testSubscriber.getOnNextEvents().size(), is(3));
    }


    private Observable<Bean> getMocks() {
        return Observable.just(new Bean(), new Bean(), new Bean());
    }

    private Observable<List<Bean>> getListMocks() {
        list = new ArrayList<>();
        list.add(new Bean());
        list.add(new Bean());
        list.add(new Bean());
        return Observable.just(list);
    }

    class Bean {
    }
}
