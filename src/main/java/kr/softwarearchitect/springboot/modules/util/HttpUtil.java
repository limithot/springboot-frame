package kr.softwarearchitect.springboot.modules.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil
{
    private String strUrl = "";
    private String body = "";
    
    private HttpUtil() 
    {

        
    }
    
    private void putUrl(String url)
    {
        this.strUrl = url;
        
    }
    
    public HttpUtil setBody(String input)
    {
        this.body = input;
        return this;
    }
    
    public String req() throws IOException
    {
        URL url = new URL(this.strUrl);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(conn.getOutputStream()));
        bw.write(this.body);
        bw.close();
        
        
        String buffer = "";
        String tmp = "";
        BufferedReader br = null;
        if( 300 <= conn.getResponseCode() || 200 > conn.getResponseCode()) {
            br = new BufferedReader( new InputStreamReader( conn.getErrorStream()));
            buffer = "";
            while( null != ( tmp = br.readLine())) {
                buffer += tmp;
            }   
            br.close();
        }else {
            br = new BufferedReader( new InputStreamReader( conn.getInputStream()));
            
            while( null != ( tmp = br.readLine())) {
                buffer += tmp;
            }
            br.close();
            
        }
        

        return buffer;
    }
    
    public static HttpUtil setUrl(String strUrl)
    {
        HttpUtil util = new HttpUtil();
        util.putUrl(strUrl);
        return util;
    }
    
    
    
    
    
    
    

}
