package org.qlmath.web.webdemo1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.qlmath.web.webdemo1.model.LogDTO.LogItem;
import org.qlmath.web.webdemo1.model.LogLevelDTO;
import org.qlmath.web.webdemo1.model.LogTimeStampDTO;
import org.qlmath.web.webdemo1.model.LogTimeStampDTO.TimeStampNum;
import org.springframework.stereotype.Service;

@Service
public class StatisDadaService {
	
	public List<LogTimeStampDTO> statLogTimeStampData(List<LogItem> logsData) {
		List<LogTimeStampDTO> res = new ArrayList<>();
		
		if (null != logsData) {
			Map<String, Integer> mp = new TreeMap<>();

			for (LogItem log : logsData) {
				String time =  log.getTimeStamp();
				time = time.substring(0, time.indexOf(" "));
				
				String key = log.getLogLevel() + ":" + time;
				Integer val = mp.get(key);

				if (null == val) {
					val = 1;
				} else {
					val++;
				}

				mp.put(key, val);
			}

			LogTimeStampDTO item = null;
			String preLevel = null;
			Iterator<Entry<String, Integer>> itr = mp.entrySet().iterator();
			while (itr.hasNext()) {
				Entry<String, Integer> ent = itr.next();

				String loglevelTime = ent.getKey();
				Integer num  = ent.getValue();
				
				int index = loglevelTime.indexOf(":");
				String curLevel = loglevelTime.substring(0, index);
				String time = loglevelTime.substring(index +  1);
				
				if (!curLevel.equals(preLevel)) {
					item = new LogTimeStampDTO();
					item.setLogLevel(curLevel);
					
					preLevel = curLevel;
					
					res.add(item);
				}
				
				item.getTimestampNumList().add(new TimeStampNum(time, num));
				
			}
		}

		return res;
	}

	public List<LogLevelDTO> statLogLevelData(List<LogItem> logsData) {
		List<LogLevelDTO> res = new ArrayList<>();

		if (null != logsData) {
			Map<String, Integer> mp = new HashMap<>(32);

			for (LogItem log : logsData) {
				Integer val = mp.get(log.getLogLevel());

				if (null == val) {
					val = 1;
				} else {
					val++;
				}

				mp.put(log.getLogLevel(), val);
			}

			LogLevelDTO item = null;
			Iterator<Entry<String, Integer>> itr = mp.entrySet().iterator();
			while (itr.hasNext()) {
				Entry<String, Integer> ent = itr.next();

				item = new LogLevelDTO();
				item.setLogLevel(ent.getKey());
				item.setNum(ent.getValue());

				res.add(item);
			}
		}

		return res;
	}

}
