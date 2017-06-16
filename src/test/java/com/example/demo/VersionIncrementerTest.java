package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class VersionIncrementerTest {

    @Test
    public void incrementMinor() throws Exception {

        String masterVersionString = "1.1.0";
        String localVersionString = "1.1.0";

        VersionIncrementer versionIncrementer = new VersionIncrementer(masterVersionString, localVersionString);

        String incrementedVersion = versionIncrementer.increment();

        assertEquals("1.2.0",incrementedVersion);
    }

    @Test
    public void incrementMajor() throws Exception {

        String masterVersionString = "1.1.0";
        String localVersionString = "2.0.0";

        VersionIncrementer versionIncrementer = new VersionIncrementer(masterVersionString, localVersionString);

        String incrementedVersion = versionIncrementer.increment();

        assertEquals("2.0.0",incrementedVersion);
    }

    @Test
    public void incrementMinorAfterMajor() throws Exception {

        String masterVersionString = "2.0.0";
        String localVersionString = "2.0.0";

        VersionIncrementer versionIncrementer = new VersionIncrementer(masterVersionString, localVersionString);

        String incrementedVersion = versionIncrementer.increment();

        assertEquals("2.1.0",incrementedVersion);
    }

    @Test
    public void incrementPatch() throws Exception {

        String masterVersionString = "2.0.0";
        String localVersionString = "2.0.1";

        VersionIncrementer versionIncrementer = new VersionIncrementer(masterVersionString, localVersionString);

        String incrementedVersion = versionIncrementer.increment();

        assertEquals("2.0.1",incrementedVersion);
    }
}