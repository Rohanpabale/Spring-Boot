package com.boot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.util.FileUpload;

@RestController
@RequestMapping("/file")
public class FileUploadController {
	@Autowired
	private FileUpload fileUpload;

	@PostMapping("upload")
	public String fileUploadHandler(@RequestParam("myFile") MultipartFile multipartFile) throws IOException {
		boolean result = this.fileUpload.isFileUploaded(multipartFile);
		if (result)
			return "file upload";
		else
			return "File not uploaded";
	}

	@PostMapping("uploadAll")
	public void multipleFile(@RequestParam("myFile") MultipartFile[] multipartFiles) throws IOException {
		for (MultipartFile file : multipartFiles) {
			this.fileUpload.isFileUploaded(file);
		}
	}
}
