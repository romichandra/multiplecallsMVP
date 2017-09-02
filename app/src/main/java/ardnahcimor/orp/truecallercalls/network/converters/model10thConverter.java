package ardnahcimor.orp.truecallercalls.network.converters;

import java.io.IOException;

import ardnahcimor.orp.truecallercalls.model.model10th;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by romichandra on 27-08-2017.
 */

public class model10thConverter implements Converter<ResponseBody, model10th> {

    @Override
    public model10th convert(ResponseBody responseBody) throws IOException {
        String response = responseBody.string();
        model10th model10th = new model10th();
        model10th.setText("'" + String.valueOf(response.charAt(9)) + "'");
        model10th.setHtmlContent(response);
        model10th.setIndex(9);
        return model10th;
    }
}