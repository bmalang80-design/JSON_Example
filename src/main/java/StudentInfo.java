

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentInfo {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("first name", "Bakary");
        obj.put("last name", "Malang");
        obj.put("age", 22);
        obj.put("city", "Pittsburgh");
        obj.put("state", "Pennsylvania");
        try {
            FileWriter writer = new FileWriter("studen_info.json");
            writer.write(obj.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(obj);
        readJsonFile();
    }

    public static void readJsonFile() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader("studen_info.json"));
            JSONObject jsonObject = (JSONObject) object;
            String fullName = jsonObject.get("first name") + " " + jsonObject.get("last name");
            String age = jsonObject.get("age").toString();
            String address = jsonObject.get("city") + " " + jsonObject.get("state");

            System.out.println(fullName + "\n" + age + "\n" + address);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
