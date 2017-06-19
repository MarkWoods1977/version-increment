package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class VersionTest {

    @Test
    public void parsesVersionString() throws Exception {

        String versionString = "1.1.0";
        Version version = new Version(versionString);
        assertEquals(version.toString(), versionString);
    }

    @Test
    public void equals() throws Exception {

        Version version = new Version("1.1.0");
        Version equalVersion = new Version("1.1.0");
        assertEquals(version, equalVersion);
    }

    @Test
    public void isHigherThanMajor() throws Exception {

        Version lowerVersion = new Version("1.1.0");
        Version higherVersion = new Version("2.1.0");
        boolean isHigher = higherVersion.isHigherThan(lowerVersion);
        assertTrue(isHigher);
    }

    @Test
    public void isHigherThanMinor() throws Exception {

        Version lowerVersion = new Version("1.9.0");
        Version higherVersion = new Version("2.1.0");
        boolean isHigher = higherVersion.isHigherThan(lowerVersion);
        assertTrue(isHigher);
    }

    @Test
    public void isHigherThanPatch() throws Exception {

        Version lowerVersion = new Version("1.9.3");
        Version higherVersion = new Version("2.1.0");
        boolean isHigher = higherVersion.isHigherThan(lowerVersion);
        assertTrue(isHigher);
    }

    @Test
    public void isLowerThan() throws Exception {

        Version lowerVersion = new Version("1.9.3");
        Version higherVersion = new Version("2.1.0");
        boolean isHigher = lowerVersion.isHigherThan(higherVersion);
        assertFalse(isHigher);
    }

    @Test
    public void isHigher() throws Exception {

        Version lowerVersion = new Version("1.2.1");
        Version higherVersion = new Version("1.3.0");
        boolean isHigher = higherVersion.isHigherThan(lowerVersion);
        assertTrue(isHigher);
    }

    @Test
    public void isEqual() throws Exception {

        Version lowerVersion = new Version("2.1.0");
        Version higherVersion = new Version("2.1.0");
        boolean isHigher = higherVersion.isHigherThan(lowerVersion);
        assertFalse(isHigher);
    }
}