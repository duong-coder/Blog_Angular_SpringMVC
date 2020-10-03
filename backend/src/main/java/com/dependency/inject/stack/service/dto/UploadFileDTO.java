package com.dependency.inject.stack.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * The type Upload file dto.
 */
@Data
@AllArgsConstructor
public class UploadFileDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

    private String urlImage;

}
