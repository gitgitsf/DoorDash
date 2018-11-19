package com.sunmonkeyapps.doordash;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UiUtilTest {

    String phone = "+16501231234";
    // expected format value is "(650) 123 - 1234"
    String expected = "(650) 123 - 1234";


    @Test
    public void testFormatPhoneCorrect() {
        // expect correct format return
        assertEquals("Format phone dispalys format", expected, "(650) 123 - 1234");

    }

    @Test
    public void testFormatPhoneIncorrect() {
        // expect not correct format return
        assertNotEquals("Format phone incorrect format", expected, "(650) 1231234");

    }
}
