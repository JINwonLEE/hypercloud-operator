package k8s.example.client;

import java.io.IOException;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import fi.iki.elonen.NanoHTTPD.Response;

public class Util {	
    public static Date getDateFromSecond(long seconds) {
		return Date.from(LocalDateTime.now().plusSeconds(seconds).atZone(ZoneId.systemDefault()).toInstant());
	}
    
    public static class Crypto {
	    public static String encryptSHA256(String input) throws Exception{
			String ret = "";
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(input.getBytes("UTF-8"));
				StringBuffer hexString = new StringBuffer();
	
				for (int i = 0; i < hash.length; i++) {
					String hex = Integer.toHexString(0xff & hash[i]);
					if (hex.length() == 1) hexString.append('0');
					hexString.append(hex);
				}
				ret = hexString.toString();	
			} catch (Exception e) {
				throw e;
			}
			return ret;
		}
    }
    
    public static Response setCors( Response resp ) {
		resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Max-Age", "3628800");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "X-Requested-With");
        resp.addHeader("Access-Control-Allow-Headers", "Accept");
        resp.addHeader("Access-Control-Allow-Headers", "Authorization");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.addHeader("Access-Control-Allow-Headers", "Referer");
        resp.addHeader("Access-Control-Allow-Headers", "User-Agent");
		return resp;
    }
    
    public static JsonNode jsonDiff(String beforeJson, String afterJson) throws Exception{
    	try {
    		ObjectMapper jackson = new ObjectMapper(); 
    		JsonNode beforeNode = jackson.readTree(beforeJson); 
    		JsonNode afterNode = jackson.readTree(afterJson); 
    		return JsonDiff.asJson(beforeNode, afterNode);
    	}catch(Exception e) {
    		
    		throw e;
    	}
    }
}
