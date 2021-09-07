package com.tochukwu.payoneerhomework;

import org.bouncycastle.util.Integers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    static int testId;

    List<Integer> nums;

    @BeforeClass
    public static void setUpTests() {
        testId = 20;
    }

    @Test
    public void verifyTestId() {
        assertEquals(20, testId);
        nums = mock(List.class);
        nums.add(1);
        verify(nums).add(1);
        when(nums.get(0)).thenReturn(1);
        assertEquals(1, (long) nums.get(0));
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @AfterClass
    public static void tearDown() {
        testId = 0;
        System.out.println(testId);
    }
}