package com.example.demo;

public class VersionIncrementer {

    private Version masterVersion;
    private Version localVersion;

    public VersionIncrementer(Version masterVersion, Version localVersion) {

        this.masterVersion = masterVersion;
        this.localVersion = localVersion;
    }

    public Version increment() {

        if(masterVersion.equals(localVersion)){
            Version newVersion = new Version(localVersion.getVersionString());
            newVersion.incrementMinorVersion();
            return newVersion;
        }

        if(localVersion.getMajorVersion() > masterVersion.getMajorVersion()) {
            Version newVersion = new Version(localVersion.getVersionString());
            return newVersion;
        }

        if(localVersion.getPatchVersion() > masterVersion.getPatchVersion()) {
            Version newVersion = new Version(localVersion.getVersionString());
            return newVersion;
        }

        return null;
    }
}
