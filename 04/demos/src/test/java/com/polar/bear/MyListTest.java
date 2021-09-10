package com.polar.bear;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class MyListTest {

    @Test
    public void verifySimpleInvocation() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        verify(mockedList).size();
    }

    @Test
    public void verifyNumberOfInteractionsWithMock() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        verify(mockedList, times(1)).size();
    }

    @Test
    public void verifyNoInteractionWithTheWholeMockOccurred() {
        List<String> mockedList = mock(MyList.class);
        verifyZeroInteractions(mockedList);
    }

    @Test
    public void verifyNoInteractionWithSpecificMethodOccurred() {
        List<String> mockedList = mock(MyList.class);
        verify(mockedList, times(0)).size();
    }

    @Test
    public void verifyNoUnexpectedInteractions() {
        List <String> mockedList = mock(MyList.class);
        mockedList.size();
        mockedList.clear();
        verify(mockedList).size();
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void verifyOrderOfInteractions() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        mockedList.add("a parameter");
        mockedList.clear();

        InOrder inOrder = Mockito.inOrder(mockedList);
        inOrder.verify(mockedList).size();
        inOrder.verify(mockedList).add("a parameter");
        inOrder.verify(mockedList).clear();
    }

    @Test
    public void verifyInteractionNotOccured() {
        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        verify(mockedList, never()).clear();
    }

    @Test
    public void verifyAnInteractionHasOccurredAtLeastACertainNumberOfTimes() {
        List<String> mockedList = mock(MyList.class);
        mockedList.clear();
        mockedList.clear();
        mockedList.clear();

        verify(mockedList, atLeast(1)).clear();
        verify(mockedList, atMost(10)).clear();
    }

    @Test
    public void verifyInteractionWithExactArgument() {
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add("test");
    }

    @Test
    public void verifyInteractionWithFlexibleAnyArgument() {
        List<String> mockedList = mock(MyList.class);
        mockedList.add("test");
        verify(mockedList).add(anyString());
    }

    @Test
    public void verifyInteractionWithArgumentCapture() {
        List<String> mockedList = mock(MyList.class);
        ArrayList<String> someList = new ArrayList<String>();
        someList.add("someElement");
        mockedList.addAll(someList);
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockedList).addAll(argumentCaptor.capture());
        List<String> capturedArgument = argumentCaptor.<List<String>> getValue();
    }


}
