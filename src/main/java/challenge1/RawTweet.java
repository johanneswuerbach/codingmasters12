package challenge1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RawTweet {
	
	private final String _data;
	private final String _filename;
	private final DateFormat _df;
	
	public RawTweet(String data, String filename) {
		_data = data;
		_filename = filename;
		_df = new SimpleDateFormat("yyyy-MM-dd HH");
		_df.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	
	public String getData() {
		return _data;
	}
	
	public Date getFNT() {
		String[] parts = _filename.split("/");
		String hour = parts[parts.length - 1];
		String date = parts[parts.length - 2];
		try {
			return _df.parse(date + " " + hour);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
