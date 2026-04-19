package com.boot.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	public static final String UPLOAD_PATH = System.getProperty("user.home") + "/spring_boot_file_upload";

	public FileUpload() {
		File file = new File(UPLOAD_PATH);
		if (!file.exists())
			file.mkdir();
	}

	public boolean isFileUploaded(MultipartFile multipartFile) throws IOException {
		if (multipartFile.isEmpty())
			return false;
		else {
			Path path = Paths.get(UPLOAD_PATH, multipartFile.getOriginalFilename());
			Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			return true;
		}
	}

}
