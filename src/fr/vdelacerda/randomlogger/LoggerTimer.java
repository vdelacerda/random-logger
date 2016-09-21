package fr.vdelacerda.randomlogger;

import java.util.Random;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;

import org.apache.log4j.Level;

@Singleton
public class LoggerTimer {
	private int index;
	private Random random;
	private Level level;
	
    public LoggerTimer() {
    	random = new Random();
    }
	
	@Schedule(minute="*/10", hour="*", persistent=true)
    private void scheduledTimeout(final Timer t) {
		index = random.nextInt(5); // valeur aleatoire entre 0 et 5
		
		switch (index) {
		case 1:
			level = Level.DEBUG;
			break;
		case 2:
			level = Level.ERROR;
			break;
		case 3:
			level = Level.FATAL;
			break;
		case 4:
			level = Level.TRACE;
			break;
		case 5:
			level = Level.WARN;
			break;
		default:
			level = Level.INFO;
		}
		
		LoggerService.log(level, "log du timer");
    }
	
	@Schedule(hour="*/1", persistent=true)
    private void scheduledSuperLog(final Timer t) {
		LoggerService.log(Level.ERROR, "SUPER log du timer");
    }
}