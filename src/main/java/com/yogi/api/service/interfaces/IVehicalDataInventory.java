package com.yogi.api.service.interfaces;

import com.yogi.api.response.IOFileInformationResponseDTO;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Krishan Shukla on 18/09/2017.
 */
public interface IVehicalDataInventory {

    public Set<IOFileInformationResponseDTO> getFilesInDirectory(String dirLocation) throws IOException;

    }
