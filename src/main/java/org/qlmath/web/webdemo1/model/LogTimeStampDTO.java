package org.qlmath.web.webdemo1.model;

import java.util.ArrayList;
import java.util.List;

public class LogTimeStampDTO {
	
	private String logLevel;
	
	private List<TimeStampNum> timestampNumList = new ArrayList<>();
	
	public static class TimeStampNum {
		
		private String year;
		
		private String month;
		
		private String day;
		
		private Integer num;
		
		public TimeStampNum() {
			
		}
		
		public TimeStampNum(String time, Integer num) {
			int idx = time.indexOf("-");
			this.year = time.substring(0, idx);
			int idx2 = time.lastIndexOf("-");
			this.month = time.substring(idx + 1, idx2);
			this.day = time.substring(idx2 + 1);
			this.num = num;
		}

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public List<TimeStampNum> getTimestampNumList() {
		return timestampNumList;
	}
}
