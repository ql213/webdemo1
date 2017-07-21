package org.qlmath.web.webdemo1.model;

import java.util.List;

/**
 * Log DTO
 * e.g
 * "TimeStamp": "2015-04-21 11:17:23,548"
	"LogMarker": "admin"
	"CurrentThread": "qtp1395423247-193"
	"Logger": "c.a.acs.acs-aem-tools-bundle"
	"LogLevel": "INFO"
	"LogMessage": "Service [4859] ServiceEvent REGISTERED"
 */
public class LogDTO {
	
	private String server;
	
	private String logFileName;
	
	//@JSONField(serialize=false)  
	private List<LogItem> logItems;
	
	public static class  LogItem {
		private String timeStamp;
		
		private String logMarker;
		
		private String currentThread;
		
		private String logger;
		
		private String logLevel;
		
		private String logMessage;

		public String getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}

		public String getLogMarker() {
			return logMarker;
		}

		public void setLogMarker(String logMarker) {
			this.logMarker = logMarker;
		}

		public String getCurrentThread() {
			return currentThread;
		}

		public void setCurrentThread(String currentThread) {
			this.currentThread = currentThread;
		}

		public String getLogger() {
			return logger;
		}

		public void setLogger(String logger) {
			this.logger = logger;
		}

		public String getLogLevel() {
			return logLevel;
		}

		public void setLogLevel(String logLevel) {
			this.logLevel = logLevel;
		}

		public String getLogMessage() {
			return logMessage;
		}

		public void setLogMessage(String logMessage) {
			this.logMessage = logMessage;
		}
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getLogFileName() {
		return logFileName;
	}

	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}

	public List<LogItem> getLogItems() {
		return logItems;
	}

	public void setLogItems(List<LogItem> logItems) {
		this.logItems = logItems;
	}
}
