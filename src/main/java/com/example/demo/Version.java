package com.example.demo;

import java.util.Formatter;

public class Version {

    private int majorVersion;
    private int minorVersion;
    private int patchVersion;



    public Version(String versionString) {

        String[] versionSplit = versionString.split("\\.");

        majorVersion = Integer.parseInt(versionSplit[0]);
        minorVersion = Integer.parseInt(versionSplit[1]);
        patchVersion = Integer.parseInt(versionSplit[2]);
    }


    public String getVersionString() {

        StringBuilder stringBuilder = new StringBuilder();
        Formatter fmt = new Formatter(stringBuilder);
        return fmt.format("%d.%d.%d", majorVersion, minorVersion, patchVersion).toString();
    }

    public void incrementMinorVersion() {
        minorVersion ++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (majorVersion != version.majorVersion) return false;
        if (minorVersion != version.minorVersion) return false;
        return patchVersion == version.patchVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getPatchVersion() {
        return patchVersion;
    }
}