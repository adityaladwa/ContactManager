package com.example.aditya.gojek.ui.main;

import com.example.aditya.gojek.data.DataManager;
import com.example.aditya.gojek.data.model.Contact;
import com.example.aditya.gojek.ui.main.util.RxSchedulersOverrideRule;
import com.example.aditya.gojek.ui.main.util.TestDataFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Aditya on 09-Feb-17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock DataManager mockDataManager;
    @Mock MainContract.View mockView;
    @Rule public final RxSchedulersOverrideRule mOverrideRule = new RxSchedulersOverrideRule();

    private MainPresenter mainPresenter;

    @Before public void init() {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mockDataManager);
        mainPresenter.attachView(mockView);
    }

    @After public void tearDown() throws Exception {
        mainPresenter.detachView();
    }


    @Test public void getContacts_shouldReturnResult() throws Exception {
        List<Contact> contactList = TestDataFactory.makeContactList(5);
        when(mockDataManager.getContact())
                .thenReturn(Single.just(contactList));

        mainPresenter.getContacts();

        verify(mockView).setUpView();
        verify(mockView).showContact(contactList);
        verify(mockView, never()).showError(any(Throwable.class));

    }


    @Test
    public void getContact_shouldThrowError() throws Exception {
        when(mockDataManager.getContact())
                .thenReturn(Single.error(new RuntimeException()));

        mainPresenter.getContacts();

        verify(mockView).setUpView();
        verify(mockView).showError(any(Throwable.class));
        verify(mockView, never()).showContact(ArgumentMatchers.anyList());
    }
}