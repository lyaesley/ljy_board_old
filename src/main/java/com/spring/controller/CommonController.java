package com.spring.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.common.CommandMap;
import com.spring.service.CommonService;

@Controller
public class CommonController {
	Logger log = Logger.getLogger(CommonController.class.getName());
	
	@Autowired
	CommonService commonService;
	
	@RequestMapping(value="/common/downloadFile")
	public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("map parameter   :      "+ commandMap);
		}
		Map<String,Object> map = commonService.selectFileInfo(commandMap.getMap());
		String storedFileName = (String)map.get("stored_file_name");
		String originalFileName = (String)map.get("original_file_name");
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("d:\\dev\\file\\"+storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
}
