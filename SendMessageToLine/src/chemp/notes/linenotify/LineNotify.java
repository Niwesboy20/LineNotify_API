package chemp.notes.linenotify;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LineNotify {
	// URL API LINE
	private String strEndpoint = "https://notify-api.line.me/api/notify";

	public void  callEvent(String text) {
   		try {
   			
   			text = URLEncoder.encode(text, "UTF-8");
			String strUrl = strEndpoint;
			
			URL url = new URL( strUrl );
			
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			// Token 
			String tokenLine = "";
			
			connection.addRequestProperty("Authorization",  "Bearer " + tokenLine);
			connection.setRequestMethod( "POST" );
			connection.addRequestProperty( "Content-Type", "application/x-www-form-urlencoded" );
			connection.setDoOutput( true );
			// pattern message + text........!
			String parameterString = "message=" + text;
			
			PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
			printWriter.print(parameterString);
			printWriter.close();
			
			connection.connect();
			connection.getResponseCode();
		    connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
