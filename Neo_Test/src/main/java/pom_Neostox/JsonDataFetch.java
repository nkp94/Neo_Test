package pom_Neostox;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class JsonDataFetch {
	
	public String getJsonData(String value) {
		String getValue="";
		try {
			String filePath=".\\src\\main\\java\\data.json";
			String jsonContent = 	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		    JSONObject jo=new JSONObject(jsonContent);
		    getValue=jo.getString(value);
		    return getValue;
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return getValue;
	}

}
