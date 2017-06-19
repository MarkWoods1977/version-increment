package com.example.demo;

public class VersionIncrementer {

    private Version masterVersion;
    private Version localVersion;

    public VersionIncrementer(String masterVersionString, String localVersionString) {

        this.masterVersion = new Version(masterVersionString);
        this.localVersion = new Version(localVersionString);
    }

    public String increment() throws IncrementViolationException {

        if(masterVersion.isHigherThan(localVersion)) {
            throw new IncrementViolationException();
        }

        Version newVersion = new Version(localVersion.toString());

        if(majorVersionIncreased() || patchVersionIncreased()) {
            return newVersion.toString();
        }

        newVersion.incrementMinorVersion();
        return newVersion.toString();
    }

    private boolean patchVersionIncreased() {
        return localVersion.getPatchVersion() > masterVersion.getPatchVersion();
    }

    private boolean majorVersionIncreased() {
        return localVersion.getMajorVersion() > masterVersion.getMajorVersion();
    }
}
