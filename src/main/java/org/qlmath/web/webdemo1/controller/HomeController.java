package org.qlmath.web.webdemo1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.qlmath.web.webdemo1.cache.CacheUtils;
import org.qlmath.web.webdemo1.model.LogDTO.LogItem;
import org.qlmath.web.webdemo1.service.StatisDadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

@Controller
public class HomeController {

	@Autowired
	private CacheUtils cacheUtils;
	
	@Autowired
	private StatisDadaService statisDadaService;

	
	/**
	 * home page
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/main.html")
	public String home(ModelMap model, HttpSession httpSession) {
		Object user = httpSession.getAttribute("user"); 
		if (null == user) {
			return "redirect:/login.html";
		}
		
		model.put("navhome", "active");
		model.put("navdash", "no");
		model.put("loglevel", "ALL");
		model.put("logs", cacheUtils.getLogsData());
		
		return "main";
	}
	
	/**
	 * home page
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dashboard.html")
	public String dashboard(ModelMap model, HttpSession httpSession) {
		Object user = httpSession.getAttribute("user"); 
		if (null == user) {
			return "redirect:/login.html";
		}
		
		model.put("navhome", "no");
		model.put("navdash", "active");
		
	    List<LogItem> temp = cacheUtils.getLogsData();
	    
	    model.put("piedata",  JSON.toJSONString(statisDadaService.statLogLevelData(temp)));
	    
	    model.put("linedata",  JSON.toJSONString(statisDadaService.statLogTimeStampData(temp)));
		
		return "dashboard";
	}
	
	@RequestMapping(value = "/loglevel", method = RequestMethod.POST)
	public String loglevel(String loglevel, ModelMap model) {	
		if (null == loglevel || "ALL".equals(loglevel)) {
			return "redirect:/main.html";
		}
		
		model.put("navhome", "active");
		model.put("navdash", "no");
		model.put("loglevel", loglevel);
		model.put("logs", filterLogInfoByLevel(loglevel, cacheUtils.getLogsData()));

		return "main";
	}

	private List<LogItem> filterLogInfoByLevel(String loglevel, List<LogItem> logsData) {
		List<LogItem> res = new ArrayList<>();
		
		if (null !=logsData) {
			for (LogItem log : logsData) {
				if (loglevel.equals(log.getLogLevel())) {
					res.add(log);
				}
			}
		}
		
		return res;
	}
}
