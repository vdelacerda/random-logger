package fr.vdelacerda.randomlogger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerService {
	private static Logger logger = Logger.getLogger(LoggerService.class);
	
	public static void log(Level level, String message) {
		logger.log(level, message);
	}
}
