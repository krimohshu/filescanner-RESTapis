package com.yogi.api.dto;

import java.math.BigDecimal;

/**
 * @author Krishan Shukla
 */
public class FileInfoDto {
	String fileName;
	String mimeType;
	String size;
	String extension;
	String path;

	public FileInfoDto() {
	}

	/**
	 *
	 * @param fileName
	 * @param mimeType
	 * @param size
	 * @param extension
	 * @param path
	 */
	public FileInfoDto(String fileName, String mimeType, String size,
			String extension, String path) {
		super();
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.size = size;
		this.extension = extension;
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
}