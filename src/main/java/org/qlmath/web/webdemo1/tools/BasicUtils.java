package org.qlmath.web.webdemo1.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

public class BasicUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(BasicUtils.class);

	public static String parseContentFromFile(Resource data) {
		StringBuilder stbd = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(data.getInputStream()))) {			
			String line = null;
			
			while ((line = br.readLine()) != null) {
				stbd.append(line);
			}
		} catch (IOException e) {
			LOG.error("Read json file error {}", e.getMessage());
		}
		
		return stbd.toString();
	}
}
