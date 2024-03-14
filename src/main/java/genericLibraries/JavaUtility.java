package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class is used to perform java related operations
 * @author vojja mahender
 *
 */

public class JavaUtility {
	/**
	 * This method fetches current date and time
	 * @return
	 */
	public String getCurrentTime() {
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		return sdf.format(d);
	}
	
	/**
	 * This method is used to wait for specific amount of time
	 * @param time
	 */
	
	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to generate a random number
	 * @param limit 
	 * @return
	 */
	
	public int generateRandomNum(int limit) {
		Random r= new Random();
		return r.nextInt(limit);
	}
}
