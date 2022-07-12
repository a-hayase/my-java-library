package com.sample.myjavalibrary.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArrayListTest {
    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void constructorCreatesArrayListWithNoElements(List<Integer> list) {
        assertEquals(0, list.size());
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void addAppendsElementToArrayList(List<Integer> list) {
        list.add(1);
        assertEquals(1, list.size());
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void addAlwaysReturnsTrue(List<Integer> list) {
        boolean actual = list.add(1);
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void addIsCapableOfAppendingMoreThanTenObjects(List<Integer> list) {
        for (int i = 1; i <= 11; i++) {
            list.add(i);
        }
        assertEquals(11, list.size());
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void getReturnsTheElementAtTheSpecifiedPosition(List<Integer> list) {
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        int actual = list.get(1);
        assertEquals(2, actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void getThrowsIndexOutOfBoundsExceptionIfNonExistIndexIsSpecified(List<Integer> list) {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void getTakesValueInBounds(List<Integer> list) {
        // Boundary Values Test
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        int actual = list.get(list.size() - 1);
        assertEquals(3, actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void getDoesNotTakeValueOutOfBounds(List<Integer> list) {
        // Boundary Values Test
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void getThrowsIndexOutOfBoundsExceptionIfIndexIsSmallerThanZero(List<Integer> list) {
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void getThrowsIndexOutOfBoundsExceptionIfIndexIsLargerThanSize(List<Integer> list) {
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void indexOfReturnsTheIndexIfObjectIsSpecified(List<Integer> list) {
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        int actual = list.indexOf((Object)2);
        assertEquals(1, actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void removeReturnsTrueWhenTheListContainsTheSpecifiedElement(List<Integer> list) {
        for (int i = 1; i <=3; i++) {
            list.add(i);
        }
        boolean actual = list.remove((Object)2);
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void removeReturnsTrueWhenTheListContainsTheSpecifiedNullElement(List<Integer> list) {
        for (int i = 1; i <=3; i++) {
            list.add(i);
        }
        list.add(null);
        boolean actual = list.remove(null);
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void removeReturnsFalseWhenTheListDoesNotContainTheSpecifiedElement(List<Integer> list) {
        for (int i = 1; i <= 3; i++) {
            list.add(i);
        }
        boolean actual = list.remove((Object) 5);
        assertFalse(actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void theSpecifiedElementIsRemovedWhenRemoveMethodIsUsed(List<Integer> list){
        for (int i = 1; i <= 2; i++) {
            list.add(i);
        }
        list.remove((Object)2);
        assertEquals(1, list.size());
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void containsReturnsTrueIfTheSpecifiedObjectIsInTheList(List<Integer> list) {
        for (int i = 1; i <=3; i++) {
            list.add(i);
        }
        boolean actual = list.contains(2);
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("emptyArrayListProvider")
    void containsReturnsFalseIfTheSpecifiedObjectIsNotInTheList(List<Integer> list) {
        for (int i = 1; i <=3; i++) {
            list.add(i);
        }
        boolean actual = list.contains(5);
        assertFalse(actual);
    }

    static Stream<Arguments> emptyArrayListProvider() {
        return Stream.of(
                arguments(new ArrayList<Integer>()),
                arguments(new java.util.ArrayList<Integer>())
        );
    }
}
