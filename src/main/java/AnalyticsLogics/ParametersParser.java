package AnalyticsLogics;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;


public class ParametersParser {

    @Nullable
    public static Map<String, String> parseParametersString(String parametersString) {
        String[] pair = parametersString.split(",");
        Map<String, String> parameters = new HashMap<String, String>();
        for (String parameterPair : pair) {
            String[] splitPair = parameterPair.split("=");
            if (splitPair.length < 2) {
                System.out.println("Incorrect parameter line. Fix your facking autotest!!!");
                return null;
            }
            splitPair[0] = splitPair[0].trim();
            splitPair[1] = splitPair[1].trim();
            parameters.put(splitPair[0], splitPair[1]);
        }
        return parameters;
    }
}
