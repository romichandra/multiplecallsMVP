package ardnahcimor.orp.truecallercalls.network;

import ardnahcimor.orp.truecallercalls.BuildConfig;
import ardnahcimor.orp.truecallercalls.model.model10th;
import ardnahcimor.orp.truecallercalls.model.modelEvery10th;
import ardnahcimor.orp.truecallercalls.model.modelWordCount;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by romichandra on 26-08-2017.
 */

public interface IService {

    @API(desricption = "model10th")
    @GET(BuildConfig.BASEURL)
    Observable<model10th> get10thCharacter();

    @API(desricption = "modelEvery10th")
    @GET(BuildConfig.BASEURL)
    Observable<modelEvery10th> getEvery10thCharacter();

    @API(desricption = "wordCount")
    @GET(BuildConfig.BASEURL)
    Observable<modelWordCount> getWordCount();

}
