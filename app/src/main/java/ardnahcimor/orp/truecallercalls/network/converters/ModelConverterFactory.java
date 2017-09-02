package ardnahcimor.orp.truecallercalls.network.converters;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import ardnahcimor.orp.truecallercalls.model.model10th;
import ardnahcimor.orp.truecallercalls.model.modelEvery10th;
import ardnahcimor.orp.truecallercalls.model.modelWordCount;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import static ardnahcimor.orp.truecallercalls.network.converters.ConverterHelper.isModel10th;
import static ardnahcimor.orp.truecallercalls.network.converters.ConverterHelper.isModelEvery10th;
import static ardnahcimor.orp.truecallercalls.network.converters.ConverterHelper.isModelWordCount;

/**
 * Created by romichandra on 28-08-2017.
 */

public class ModelConverterFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (isModel10th(annotations) && type == model10th.class) return new model10thConverter();
        if (isModelEvery10th(annotations) && type == modelEvery10th.class) return new modelEvery10thConverter();
        if (isModelWordCount(annotations) && type == modelWordCount.class) return new modelWordCountConverter();

        return null;
    }
}
