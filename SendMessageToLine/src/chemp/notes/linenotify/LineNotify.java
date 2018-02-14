package chemp.notes.linenotify;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LineNotify {
	// URL API LINE
	private String strEndpoint = "https://notify-api.line.me/api/notify";

	public void  callEvent(String message) {
   		try {
   			
			message = URLEncoder.encode(message, "UTF-8");
			String strUrl = strEndpoint;
			
			URL url = new URL( strUrl );
			
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			// Token 
			connection.addRequestProperty("Authorization",  "Bearer " + "8O7MNmSKCJbYzKoB97N1TXHXQWeqL7Ap6eUPw697dfE");
			connection.setRequestMethod( "POST" );
			connection.addRequestProperty( "Content-Type", "application/x-www-form-urlencoded" );
			connection.setDoOutput( true );
			// pattern message + text........!
			String parameterString = "message=" + message;
			
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
