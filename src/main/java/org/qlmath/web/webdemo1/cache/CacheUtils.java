package org.qlmath.web.webdemo1.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.qlmath.web.webdemo1.model.LogDTO;
import org.qlmath.web.webdemo1.model.LogDTO.LogItem;
import org.qlmath.web.webdemo1.model.UserDTO;
import org.qlmath.web.webdemo1.tools.BasicUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;

@Component
public class CacheUtils {
	
	@Value(value = "classpath:data/users.json")
	private Resource userdata;
	
	@Value(value = "classpath:data/logs.json")
	private Resource logdata;
	
	private Map<String, UserDTO> usersData = new HashMap<>();
	
	private List<LogItem> logsData = new ArrayList<>();

	@PostConstruct
	public void init() {
		buildUserCacheData();
		
		buildLogCacheData();
	}
	
	private void buildLogCacheData() {
		String jsonCont = BasicUtils.parseContentFromFile(logdata);
		
		if (!StringUtils.isEmpty(jsonCont)) {
			 List<LogDTO> logs = new ArrayList<LogDTO>(JSONArray.parseArray(jsonCont, LogDTO.class));
			 
			 for (LogDTO log : logs) {
				 logsData.addAll(log.getLogItems());
			 }
		 }
	}

	private void buildUserCacheData() {
		String jsonCont = BasicUtils.parseContentFromFile(userdata);
		
		 if (!StringUtils.isEmpty(jsonCont)) {
			 List<UserDTO> users = new ArrayList<UserDTO>(JSONArray.parseArray(jsonCont, UserDTO.class));
			 
			 for (UserDTO user : users) {
				 usersData.put(user.getUserId(), user);
			 }
		 }
	}

	public Map<String, UserDTO> getUsersData() {
		return usersData;
	}
	
	public List<LogItem> getLogsData() {
		return logsData;
	}
}
