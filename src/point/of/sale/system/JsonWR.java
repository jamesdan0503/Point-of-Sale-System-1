/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.of.sale.system;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author tyk54
 */


public class JsonWR {

    JSONObject jsonObject = new JSONObject();
    JSONObject jsonObject_login = new JSONObject();
    static JSONObject jsonObject_logout = new JSONObject();
   
    
    public JSONObject json_obj(long appleNum,long bananaNum,long cherryNum){
        
		//JSON object and values
	try {
		jsonObject.put("apple", appleNum);
		jsonObject.put("banana", bananaNum);
		jsonObject.put("cherry",cherryNum);
                
	} catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        return jsonObject;
    }
    
    public void transactionWrite(JSONObject obj,String path,int transNum){
        try {
		FileWriter fileWriter = new FileWriter(path + transNum + ".json");
		fileWriter.write(jsonObject.toString());
		fileWriter.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
    
    public void inventoryWrite(JSONObject obj){
        try {
		FileWriter fileWriter = new FileWriter("/Users/hunk/Java WorkSpace/inventory/info.json");
		fileWriter.write(jsonObject.toString());
		fileWriter.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
    
   
    public JSONObject json_obj_login(String time, String name) {
        
        try{
            jsonObject_login.append("login time", time);
            jsonObject_login.append("name", name);
        } catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        
        return jsonObject_login;
    }
    
    public JSONObject json_obj_logout(String time, String name) {
        
        try{
            jsonObject_logout.append("logout time", time);
            jsonObject_logout.append("name", name);
        } catch (JSONException e1) {
		e1.printStackTrace();
	}
        
        return jsonObject_logout;
    }
    
    public void loginTimeWrite(JSONObject obj) {
        
        try {
		FileWriter fileWriter = new FileWriter("/Users/hunk/Java WorkSpace/login/record.json");
		fileWriter.write(jsonObject_login.toString());
		fileWriter.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
        
    }
    
     public void logoutTimeWrite(JSONObject obj) {
        
        try {
		FileWriter fileWriter = new FileWriter("/Users/hunk/Java WorkSpace/logout/record.json");
		fileWriter.write(jsonObject_logout.toString());
		fileWriter.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
        
    }
    
    
}
