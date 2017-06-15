package com.example.demo;

public class VersionIncrementer {

    private Version masterVersion;
    private Version localVersion;

    public VersionIncrementer(Version masterVersion, Version localVersion) {

        this.masterVersion = masterVersion;
        this.localVersion = localVersion;
    }

    public Version increment() {

        Version newVersion = new Version(localVersion.getVersionString());

        if(majorVersionIncreased() || patchVersionIncreased()) {
            return newVersion;
        }

        newVersion.incrementMinorVersion();
        return newVersion;
    }

    private boolean patchVersionIncreased() {
        return localVersion.getPatchVersion() > masterVersion.getPatchVersion();
    }

    private boolean majorVersionIncreased() {
        return localVersion.getMajorVersion() > masterVersion.getMajorVersion();
    }
}
