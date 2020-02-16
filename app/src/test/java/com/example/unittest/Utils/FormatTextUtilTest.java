package com.example.unittest.Utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatTextUtilTest {

    @Test
    public void getPhoneNumber_simple() {

        assertEquals(FormatTextUtil.getPhoneNumber("0123456789"),"0123456789");
    }

    @Test
    public void getPhoneNumber_withRegion() {
        assertEquals(FormatTextUtil.getPhoneNumber("+84123456789"),"0123456789");
    }

    @Test
    public void getPhoneNumber_noZero() {
        assertEquals(FormatTextUtil.getPhoneNumber("123456789"),"0123456789");
    }

    @Test
    public void getPhoneNumber_space() {
        assertEquals(FormatTextUtil.getPhoneNumber("123 456 789"),"0123456789");
    }

    @Test
    public void getPhoneNumber_null() {
        assertEquals(FormatTextUtil.getPhoneNumber(null),"");
    }

    @Test
    public void getPhoneNumber_lengthLong() {
        assertEquals(FormatTextUtil.getPhoneNumber("01234567890009999"),"");
    }

    @Test
    public void getPhoneNumber_lengthShort() {
        assertEquals(FormatTextUtil.getPhoneNumber("01234"),"");
    }
}