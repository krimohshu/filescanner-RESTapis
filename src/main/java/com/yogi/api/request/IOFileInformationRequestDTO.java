package com.yogi.api.request;

/**
 * Created by Krishan Shukla on 18/09/2017.
 */
public class IOFileInformationRequestDTO {

    private String dirLocation;
    private int depthAnalysis;
    private String excludeFileTypes;

    public String getDirLocation() {
        return dirLocation;
    }

    public void setDirLocation(String dirLocation) {
        this.dirLocation = dirLocation;
    }

    public int getDepthAnalysis() {
        return depthAnalysis;
    }

    public void setDepthAnalysis(int depthAnalysis) {
        this.depthAnalysis = depthAnalysis;
    }

    public String getExcludeFileTypes() {
        return excludeFileTypes;
    }

    public void setExcludeFileTypes(String excludeFileTypes) {
        this.excludeFileTypes = excludeFileTypes;
    }
}
