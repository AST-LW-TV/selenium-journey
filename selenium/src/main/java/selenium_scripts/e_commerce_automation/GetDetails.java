package selenium_scripts.e_commerce_automation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class GetDetails {

    private static JSONArray jsonArray;
    private JSONObject jsonInnerObject;


    /**
     * static initializer, runs once when the class is initialized
     */
    static {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader file = new FileReader("./src/main/java/selenium_scripts/e_commerce_automation/details.json");
            Object objectArray = jsonParser.parse(file);
            jsonArray = (JSONArray) objectArray;
        } catch (IOException | ParseException error) {
            error.printStackTrace();
        }
    }

    public GetDetails(int indexPosition) {
        JSONObject jsonObject = (JSONObject) jsonArray.get(indexPosition);
        this.jsonInnerObject = (JSONObject) jsonObject.get(Integer.toString(indexPosition));
    }

    /**
     * returns the value of the key, passed as argument
     *
     * @param keyValue (String type)
     * @return value of the matched key (String type)
     */
    public String getKey(String keyValue) {
        String value = (String) this.jsonInnerObject.get(keyValue);
        return value;
    }

    public Set getKeySet(){
        return this.jsonInnerObject.keySet();
    }

}
