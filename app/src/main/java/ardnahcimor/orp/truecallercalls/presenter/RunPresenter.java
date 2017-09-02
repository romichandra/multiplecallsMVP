package ardnahcimor.orp.truecallercalls.presenter;

import ardnahcimor.orp.truecallercalls.model.model10th;
import ardnahcimor.orp.truecallercalls.model.modelEvery10th;
import ardnahcimor.orp.truecallercalls.model.modelWordCount;
import ardnahcimor.orp.truecallercalls.network.Service;
import ardnahcimor.orp.truecallercalls.network.converters.ConverterHelper;
import ardnahcimor.orp.truecallercalls.view.IActivity;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by romichandra on 26-08-2017.
 */

public class RunPresenter {

    public final Service mService;

    public final IActivity iActivity;

    private CompositeSubscription subscriptions;

    private modelWordCount mWordCount;

    public RunPresenter(Service iService, IActivity iActivity) {
        this.mService = iService;
        this.iActivity = iActivity;
        this.subscriptions = new CompositeSubscription();
    }

    public void makeCalls(){
        CallWordCount();
        CallEvery10thCharacter();
        Call10thCharacter();
    }

    public void UpdatePattern(boolean isWhiteSpace){
        if (isWhiteSpace) {
            ConverterHelper.PATTERN = "\\s++";
            if (iActivity!=null)
                iActivity.changePatternText("whitespace seperation");
        }
        else {
            ConverterHelper.PATTERN = "\\W+?";
            if (iActivity!=null)
                iActivity.changePatternText("word seperation");
        }
        if (mWordCount!=null){
            mWordCount.setWordCount(ConverterHelper.mapWordCount(mWordCount.getHtmlContent()));
            if (iActivity == null) return;
            iActivity.getWordCount(mWordCount);
        }
    }

    public void SearchWord(String word){
        if (mWordCount!=null){
            if (mWordCount.getWordCount().containsKey(word)){
                if (iActivity!=null) iActivity.updateSearchResult(word + " : " + String.valueOf(mWordCount.getWordCount().get(word)));
            }
            else{
                if (iActivity!=null) iActivity.updateSearchResult(word + " : 0");
            }
        }
    }

    public void Call10thCharacter(){
        if (iActivity != null)
            iActivity.showProgressBar1();

        Subscription subscription = mService.get10thCharacter(new Service.Get10thCharCallback() {
            @Override
            public void onSuccess(model10th model10th) {
                if (iActivity == null) return;
                iActivity.hideProgressBar1();
                iActivity.get10thCharSuccessfully(model10th);
            }

            @Override
            public void onError(Throwable t) {
                if (iActivity == null) return;
                t.printStackTrace();
                iActivity.hideProgressBar1();
                iActivity.show10thCharNetworkError(t.getMessage());
            }

        });

        subscriptions.add(subscription);
    }

    public void CallEvery10thCharacter(){
        if (iActivity != null)
            iActivity.showProgressBar2();

        Subscription subscription = mService.getEvery10thCharacter(new Service.GetEvery10thCharCallback() {
            @Override
            public void onSuccess(modelEvery10th modelEvery10th) {
                if (iActivity == null) return;
                iActivity.hideProgressBar2();
                iActivity.getEvery10thCharSuccessfully(modelEvery10th);
            }

            @Override
            public void onError(Throwable t) {
                if (iActivity == null) return;
                t.printStackTrace();
                iActivity.hideProgressBar2();
                iActivity.showEvery10thCharNetworkError(t.getMessage());
            }

        });

        subscriptions.add(subscription);
    }

    public void CallWordCount(){
        if (iActivity != null)
            iActivity.showProgressBar3();

        Subscription subscription = mService.getWordCount(new Service.GetWordCountCallback() {
            @Override
            public void onSuccess(modelWordCount modelWordCount) {
                if (iActivity == null) return;
                iActivity.hideProgressBar3();
                iActivity.getWordCount(modelWordCount);
                mWordCount = modelWordCount;
            }

            @Override
            public void onError(Throwable t) {
                if (iActivity == null) return;
                iActivity.hideProgressBar3();
                iActivity.showWordCountNetworkError(t.getMessage());
                mWordCount = null;
            }

        });

        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }

}
