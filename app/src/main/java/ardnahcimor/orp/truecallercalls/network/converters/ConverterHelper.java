package ardnahcimor.orp.truecallercalls.network.converters;

import java.lang.annotation.Annotation;
import java.util.TreeMap;

import ardnahcimor.orp.truecallercalls.network.API;

/**
 * Created by romichandra on 28-08-2017.
 */

public class ConverterHelper {

    public static String PATTERN = "\\s++";

    static final boolean isModel10th(Annotation[] annotations){
        for (Annotation annotation : annotations){
            if (API.class == annotation.annotationType()) {
                if (((API) annotation).desricption().equals("model10th")) {
                    return true;
                }

                break;
            }
        }
        return false;
    }

    static final boolean isModelEvery10th(Annotation[] annotations){
        for (Annotation annotation : annotations){
            if (API.class == annotation.annotationType()) {
                if (((API) annotation).desricption().equals("modelEvery10th")) {
                    return true;
                }

                break;
            }
        }
        return false;
    }

    static final boolean isModelWordCount(Annotation[] annotations){
        for (Annotation annotation : annotations){
            if (API.class == annotation.annotationType()) {
                if (((API) annotation).desricption().equals("wordCount")) {
                    return true;
                }

                break;
            }
        }
        return false;
    }

    public static final TreeMap<String, Integer> mapWordCount(String response){
        TreeMap<String, Integer> map = new TreeMap<>();
        String [] parts = response.trim().split(ConverterHelper.PATTERN);
        for (String p : parts){
            if (!p.equals("")) {
                p = p.toLowerCase();
                if (map.containsKey(p)) {
                    map.put(p, map.get(p) + 1);
                } else {
                    map.put(p, 1);
                }
            }
        }
        return map;
    }
}
