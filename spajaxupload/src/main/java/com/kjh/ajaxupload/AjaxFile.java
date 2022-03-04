package com.kjh.ajaxupload;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//client�� �Ķ��Ÿ�� �����ϴ� ������Ŭ����
public class AjaxFile {
	private List<MultipartFile> images;

	public AjaxFile() {
		super();
	}

	public AjaxFile(List<MultipartFile> images) {
		super();
		this.images = images;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

}
