package com.example.demo;

public class VersionIncrementer {

    private Version masterVersion;
    private Version localVersion;

    public VersionIncrementer(String masterVersionString, String localVersionString) {

        this.masterVersion = new Version(masterVersionString);
        this.localVersion = new Version(localVersionString);
    }

    public String increment() throws IncrementViolationException {

        if(masterVersion.isHigherThan(localVersion) && isMajorOrPatchIncrement()) {
            throw new IncrementViolationException();
        }

        if(majorVersionIncreased() || patchVersionIncreased()) {
            return localVersion.toString();
        }

        Version newVersion = new Version(masterVersion.toString());
        newVersion.incrementMinorVersion();
        return newVersion.toString();
    }

    public boolean isMajorOrPatchIncrement() {

        if (localVersion.getMajorVersion() > masterVersion.getMajorVersion()) return true;

        if(localVersion.getPatchVersion() != 0) return true;

        return false;
    }

    private boolean patchVersionIncreased() {
        return localVersion.getPatchVersion() > masterVersion.getPatchVersion();
    }

    private boolean majorVersionIncreased() {
        return localVersion.getMajorVersion() > masterVersion.getMajorVersion();
    }
}
