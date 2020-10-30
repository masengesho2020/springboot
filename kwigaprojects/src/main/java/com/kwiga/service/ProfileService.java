package com.kwiga.service;

import java.io.File;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileService {

	public String uploadpicture(MultipartFile profile_pic) {
		Resource resourse=new ClassPathResource(profile_pic.getOriginalFilename());
		String userprofile="";
		try {
			if (profile_pic.isEmpty()) {
				throw new Exception("This file does not exist");
			}
			else {
				File file=new File(resourse.getFilename());
				if(file.exists()) {
					file=new File(resourse.getFilename().substring(0,
								  resourse.getFilename().lastIndexOf(","))+"_1."+
								  resourse.getFilename().substring(resourse.getFilename().lastIndexOf(".")+1,
								  resourse.getFilename().length()));
					file.createNewFile();
					userprofile=profile_pic.getOriginalFilename().substring(0,
							resourse.getFilename().lastIndexOf("."))+"_1."+profile_pic.getOriginalFilename().substring(resourse.getFilename().lastIndexOf(".")+1,
							resourse.getFilename().length());
				}
				else {
					file.createNewFile();
					userprofile=profile_pic.getOriginalFilename();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return userprofile;
	}

}
