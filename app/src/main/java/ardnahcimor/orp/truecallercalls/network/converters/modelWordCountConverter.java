package ardnahcimor.orp.truecallercalls.network.converters;

import java.io.IOException;
import java.util.TreeMap;

import ardnahcimor.orp.truecallercalls.model.modelWordCount;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by romichandra on 27-08-2017.
 */

public class modelWordCountConverter implements Converter<ResponseBody, modelWordCount> {

    @Override
    public modelWordCount convert(ResponseBody responseBody) throws IOException {
        String response = responseBody.string();
        modelWordCount modelWordCount = new modelWordCount();
        modelWordCount.setHtmlContent(response);
        modelWordCount.setWordCount(getWordCount(response));
        return modelWordCount;
    }

    private TreeMap<String, Integer> getWordCount(String response){
       return ConverterHelper.mapWordCount(response);
    }
}
