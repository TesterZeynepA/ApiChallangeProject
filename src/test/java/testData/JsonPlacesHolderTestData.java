package testData;

import java.util.HashMap;

public class JsonPlacesHolderTestData {

    public static HashMap<String,Object> expectedData;

    public HashMap<String,Object>setUpDataTodos(){

        expectedData = new HashMap<>();

        expectedData.put("userId", 10);
        expectedData.put("id", 198);
        expectedData.put("title", "quis eius est sint explicabo");
        expectedData.put("completed", true);

        return expectedData;

    }



}
