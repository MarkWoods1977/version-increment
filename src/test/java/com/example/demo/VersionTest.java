package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class VersionTest {

    @Test
    public void parsesVersionString() throws Exception {

        String versionString = "1.1.0";
        Version version = new Version(versionString);
        assertEquals(version.getVersionString(), versionString);
    }

    @Test
    public void equals() throws Exception {

        Version version = new Version("1.1.0");
        Version equalVersion = new Version("1.1.0");
        assertEquals(version, equalVersion);
    }
}