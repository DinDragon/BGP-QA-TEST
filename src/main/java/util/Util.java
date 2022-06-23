package util;

import com.google.gson.Gson;

public class Util {
    public void printObjectToJson(Object object) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(object).toString());
    }
}
