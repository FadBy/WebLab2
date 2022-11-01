package marat.web.lab2;

import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ResultRay {
    double x;
    double y;
    double r;
    boolean hitResult;
    LocalTime currentTime;
    double executionTime;

    public ResultRay(double x, double y, double r, boolean hitResult, LocalTime currentTime, double executionTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hitResult = hitResult;
        this.currentTime = currentTime;
        this.executionTime = executionTime;
    }

    public JsonObject convertToJSON() {
        JsonObject json = new JsonObject();
        json.addProperty("x", x);
        json.addProperty("y", y);
        json.addProperty("r", r);
        json.addProperty("hitResult", hitResult);
        System.out.println(currentTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        json.addProperty("currentTime", currentTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        json.addProperty("executionTime", executionTime);
        System.out.println(json.toString());
        return json;
    }

    public List<String> convertToList() {
        return new ArrayList<String>() {{add(String.valueOf(x)); add(String.valueOf(y)); add(String.valueOf(r)); add(String.valueOf(hitResult)); add(currentTime.toString()); add(String.valueOf(executionTime));}};
    }
}
