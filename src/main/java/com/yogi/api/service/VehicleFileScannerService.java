package com.yogi.api.service;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.yogi.api.dto.FileInfoDto;
import com.yogi.api.util.Util;

/**
 * Created by Krishan Shukla on 18/09/2017.
 */
@Service
@Transactional
public class VehicleFileScannerService {

	/**
	 * Scans the directory path and list the files
	 *
	 * @param directoryPath
	 * @param supportedFileTypes
	 * @param includeSubDirectories
	 * @param mimeTypes
	 * @return
	 */
	public List scanFilesAndFolders(String directoryPath,
			String supportedFileTypes, String includeSubDirectories,
			Set<String> mimeTypes) {
		List<FileInfoDto> result = new ArrayList<>();
		try {
			Paths path = null;

			// Java7
			/*
			 * Thread thread = new Thread(new Runnable(){
			 *
			 * @Override public void run() { while(true){ File directory=new
			 * File(directoryPath); File[] files= directory.listFiles();
			 * for(File file:files){ System.out.println(file.getName()); } } }
			 * });
			 */
			if ("no".equalsIgnoreCase(includeSubDirectories)) {
				scanFileSystem(directoryPath, result, false, mimeTypes,false);
			} else {
				// recursively
				scanFileSystem(directoryPath, result, true, mimeTypes,false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * scans the filesystem
	 *
	 * @param directoryPath
	 * @param result
	 * @param recursively
	 * @param mimeTypes
	 */
	public void scanFileSystem(String directoryPath, List<FileInfoDto> result,
			boolean recursively, Set<String> mimeTypes,boolean ignoreMimeTypes) {
		try {
			Stream<Path> paths = null;
			if (recursively)
				paths = Files.walk(Paths.get(directoryPath));
			else
				paths = Files.list(Paths.get(directoryPath));


			paths.forEach(file -> {
				try {
					String mimeType = Files.probeContentType(file);

					if (file.toFile().isFile() && (ignoreMimeTypes || (mimeTypes!=null && mimeTypes.contains(mimeType)))) {
						String fileName = file.getFileName().toFile().getName();
						String extension = fileName.contains(".")?fileName.substring(fileName.lastIndexOf(".")):"";


						FileInfoDto fileInfoDto = new FileInfoDto(fileName,
								mimeType,
								Util.getFileSizeInUnits(file.toFile().length()),
								extension,file.toFile().getAbsolutePath().replace("\\", "/"));
						result.add(fileInfoDto);

					}


				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}