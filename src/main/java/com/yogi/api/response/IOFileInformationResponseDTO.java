package com.yogi.api.response;

/**
 * Created by Krishan Shukla on 18/09/2017.
 */
public class IOFileInformationResponseDTO {

    private String fileName;
    private String fileMIMEType;
    private Double fileSize;
    private String fileExtension;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMIMEType() {
        return fileMIMEType;
    }

    public void setFileMIMEType(String fileMIMEType) {
        this.fileMIMEType = fileMIMEType;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
