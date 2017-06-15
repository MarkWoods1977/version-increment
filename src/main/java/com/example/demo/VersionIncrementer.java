package com.example.demo;

public class VersionIncrementer {

    private Version masterVersion;
    private Version localVersion;

    public VersionIncrementer(String masterVersionString, String localVersionString) {

        this.masterVersion = new Version(masterVersionString);
        this.localVersion = new Version(localVersionString);
    }

    public String increment() {

        Version newVersion = new Version(localVersion.getVersionString());

        if(majorVersionIncreased() || patchVersionIncreased()) {
            return newVersion.getVersionString();
        }

        newVersion.incrementMinorVersion();
        return newVersion.getVersionString();
    }

    private boolean patchVersionIncreased() {
        return localVersion.getPatchVersion() > masterVersion.getPatchVersion();
    }

    private boolean majorVersionIncreased() {
        return localVersion.getMajorVersion() > masterVersion.getMajorVersion();
    }
}
