package ardnahcimor.orp.truecallercalls.network.converters;

import java.io.IOException;
import java.util.ArrayList;

import ardnahcimor.orp.truecallercalls.model.modelEvery10th;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by romichandra on 27-08-2017.
 */

public class modelEvery10thConverter implements Converter<ResponseBody, modelEvery10th> {


    @Override
    public modelEvery10th convert(ResponseBody responseBody) throws IOException {
        String response = responseBody.string();
        modelEvery10th modelEvery10th = new modelEvery10th();
        modelEvery10th.setHtmlContent(response);
        modelEvery10th.setListEvery10th(getEvery10thCharater(response));
        return modelEvery10th;
    }

    private ArrayList<String> getEvery10thCharater(String response){
        ArrayList<String> list = new ArrayList<>();
        int n = 0;
        while (n!=response.length()){
            n++;
            if (n%10==0)
            list.add(String.valueOf(response.charAt(n-1)));
        }
        return list;
    }
}