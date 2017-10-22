package com.yogi.api.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yogi.api.common.BaseController;
import com.yogi.api.dto.BaseResponseDto;
import com.yogi.api.dto.FileInfoDto;
import com.yogi.api.response.IOFileInformationResponseDTO;
import com.yogi.api.service.VehicleFileScannerService;
import com.yogi.api.service.interfaces.IVehicalDataInventory;
import com.yogi.api.util.MIMException;
import com.yogi.api.util.Util;

/**
 * Created by Krishan Shukla on 18/09/2017.
 */

@RestController
@RequestMapping(value="/v1")
//@PropertySource(value = {"classpath:properties.${ENV_SYSTEM:qa}/props-for-api-tests.properties", "classpath:properties.${ENV_SYSTEM:qa}/props-for-ui-tests.properties"})
public class VehicalDataInventoryController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(VehicalDataInventoryController.class);
	RestTemplate restTemplate;
	@Value("${valied.mime.types}")
	String VALIED_MIME_TYPES;

	@Autowired
	Environment environment;
	/*@Autowired
	IVehicalDataInventory vehicalDataInventory;*/

	@Autowired
	VehicleFileScannerService vehicleFileScannerService;

	/**
	 * @author Krishan Shukla
	 * Created by Krishan Shukla on 20/10/2017.
	 * @api {post} /api/scanfiles/list scan the files in the given folder
	 * @apiGroup VehicalManagement
	 * @apiDescription Scan configured directory in file system which will
	 *                 return this information --> filename, file mime type,
	 *                 file size, file extension
	 *
	 * @apiParam (Body) {Object} Body
	 *
	 * @apiSuccess (200) {IOFileInformationRequestDTO} return infomation of file
	 * @apiSuccessExample Success-Response: HTTP/1.1 200 CREATED {}
	 * @apiError
	 * @apiErrorExample
	 *
	 */
	@RequestMapping(value = "/api/scanfiles/list", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)
	public BaseResponseDto<List> listAll(
			@RequestParam(required = false, defaultValue = "${directory.toscan}") String directoryPath) {
		BaseResponseDto<List> respone = new BaseResponseDto<List>();

		try {
			List<String> mimeTypes = new ArrayList<String>();
			List<FileInfoDto> result = new ArrayList<>();
			vehicleFileScannerService.scanFileSystem(directoryPath, result,
					true, null, true);
			respone.setResult(result);
			respone.setMessage("Successfully retried the file Details");
		} catch (Exception e) {
			respone.setStatus("error");
			respone.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return respone;
	}

	/**
	 * @api {post} /api/scanfilesByMimetypes scan the files in the given folder
	 * @apiGroup VehicalManagement
	 * @apiDescription Provide a way to retrieve certain supported mime type
	 *                 files: configure excel and csv are supported currently
	 *
	 * @apiParam (Body) {Object} Body
	 *
	 * @apiSuccess (200) {IOFileInformationRequestDTO} return infomation of file
	 * @apiSuccessExample Success-Response: HTTP/1.1 200 CREATED {}
	 * @apiError
	 * @apiErrorExample
	 *
	 */
	@RequestMapping(value = "/api/scanfilesByMimetypes", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)
/*	public BaseResponseDto<List> scanfilesInDirectory(
*/			public List<FileInfoDto> scanfilesInDirectory(

			@RequestParam(required = false, defaultValue = "${directory.toscan}") String directoryPath,
			@RequestParam(required = false, defaultValue = "${supported.mime.types}") String supportedFileTypes,
			@RequestParam(defaultValue = "yes", required = false) String includeSubDirectories) {
		BaseResponseDto<List> respone = new BaseResponseDto<List>();
		List<FileInfoDto>  files = null;
		try {
			Set<String> mimeTypes = new HashSet<String>();
			boolean ignoreMimeTypes = false;

			String[] tmp = Util.isNotEmpty(supportedFileTypes) ? supportedFileTypes
					.split(",") : null;
			if (tmp != null) {
				Set<String> inputMimeTypes = new HashSet<>(Arrays.asList(tmp));
				Set<String> valiedMimeTypes = new HashSet<>(
						Arrays.asList(VALIED_MIME_TYPES.split(",")));
				if (!valiedMimeTypes.containsAll(inputMimeTypes)) {
					System.out.println("Invalied mime type");
					throw new MIMException("Invalied mimetype");
				}

				mimeTypes.addAll(Arrays.asList(tmp));
			}
			
			
			
			files =vehicleFileScannerService.scanFilesAndFolders(
					directoryPath, supportedFileTypes, includeSubDirectories,
					mimeTypes);
			
			
					
			/*
			respone.setStatus("success");
			respone.setResult(vehicleFileScannerService.scanFilesAndFolders(
					directoryPath, supportedFileTypes, includeSubDirectories,
					mimeTypes));*/
			respone.setMessage("Successfully retried the file Details");
		} catch (Exception e) {
		/*	respone.setStatus("error");
			respone.setMessage(e.getMessage());*/
			e.printStackTrace();
		}

		return files;
		//return respone;
	}


	/*@RequestMapping(value = "/api/scanfiles", method = { RequestMethod.POST }, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Set<IOFileInformationResponseDTO> scanfiles(
			@RequestParam String directoryPath) throws IOException {
		LOGGER.info("Inside scanfile controller");
		Set<IOFileInformationResponseDTO> ioFileInfo = vehicalDataInventory
				.getFilesInDirectory(directoryPath);
		return ioFileInfo;
	}
*/
}
