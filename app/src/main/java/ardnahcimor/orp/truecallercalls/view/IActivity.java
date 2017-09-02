package ardnahcimor.orp.truecallercalls.view;

import ardnahcimor.orp.truecallercalls.model.model10th;
import ardnahcimor.orp.truecallercalls.model.modelEvery10th;
import ardnahcimor.orp.truecallercalls.model.modelWordCount;

/**
 * Created by romichandra on 26-08-2017.
 */

public interface IActivity {

    void showProgressBar1();

    void hideProgressBar1();

    void showProgressBar2();

    void hideProgressBar2();

    void showProgressBar3();

    void hideProgressBar3();

    void get10thCharSuccessfully(model10th model10th);

    void show10thCharNetworkError(String mError);

    void getEvery10thCharSuccessfully(modelEvery10th modelEvery10th);

    void showEvery10thCharNetworkError(String mError);

    void getWordCount(modelWordCount modelWordCount);

    void showWordCountNetworkError(String mError);

    void changePatternText(String pattern);

    void updateSearchResult(String result);

}
