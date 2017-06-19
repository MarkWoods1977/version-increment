package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class VersionIncrementerTest {

    @Test
    public void incrementMinor() throws Exception {

        String masterVersionString = "1.1.0";
        String localVersionString = "1.1.0";

        String incrementedVersion = increment(masterVersionString, localVersionString);

        assertEquals("1.2.0",incrementedVersion);
    }

    private String increment(String masterVersionString, String localVersionString) throws IncrementViolationException {
        VersionIncrementer versionIncrementer = new VersionIncrementer(masterVersionString, localVersionString);
        return versionIncrementer.increment();
    }

    @Test
    public void incrementMajor() throws Exception {

        String masterVersionString = "1.1.0";
        String localVersionString = "2.0.0";

        String incrementedVersion = increment(masterVersionString, localVersionString);

        assertEquals("2.0.0",incrementedVersion);
    }

    @Test
    public void incrementMinorAfterMajor() throws Exception {

        String masterVersionString = "2.0.0";
        String localVersionString = "2.0.0";

        String incrementedVersion = increment(masterVersionString, localVersionString);

        assertEquals("2.1.0",incrementedVersion);
    }

    @Test
    public void incrementPatch() throws Exception {

        String masterVersionString = "2.0.0";
        String localVersionString = "2.0.1";

        String incrementedVersion = increment(masterVersionString, localVersionString);

        assertEquals("2.0.1",incrementedVersion);
    }

    @Test(expected = IncrementViolationException.class)
    public void incrementPatchFails() throws Exception {

        String masterVersionString = "1.3.0";
        String localVersionString = "1.2.1";

        increment(masterVersionString, localVersionString);
    }
}