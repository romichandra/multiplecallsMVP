package ardnahcimor.orp.truecallercalls.network;

import android.support.annotation.NonNull;

import ardnahcimor.orp.truecallercalls.model.model10th;
import ardnahcimor.orp.truecallercalls.model.modelEvery10th;
import ardnahcimor.orp.truecallercalls.model.modelWordCount;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by romichandra on 26-08-2017.
 */

public class Service {

    private IService iService;

    public Service(IService iService) {
        this.iService = iService;
    }

    public Subscription get10thCharacter(final Get10thCharCallback callback){
         return iService.get10thCharacter()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<model10th>() {

                    @Override
                    public void onNext(@NonNull model10th model10th) {

                        callback.onSuccess(model10th);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onCompleted() {

                    }

                });
    }

    public Subscription getEvery10thCharacter(final GetEvery10thCharCallback callback){
        return iService.getEvery10thCharacter()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<modelEvery10th>() {

                    @Override
                    public void onNext(@NonNull modelEvery10th modelEvery10th) {

                        callback.onSuccess(modelEvery10th);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onCompleted() {

                    }

                });
    }

    public Subscription getWordCount(final GetWordCountCallback callback){
        return iService.getWordCount()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<modelWordCount>() {

                    @Override
                    public void onNext(@NonNull modelWordCount modelWordCount) {

                        callback.onSuccess(modelWordCount);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onCompleted() {

                    }

                });
    }

    public interface GetWordCountCallback {
        void onSuccess(modelWordCount modelWordCount);
        void onError(Throwable error);
    }

    public interface GetEvery10thCharCallback {
        void onSuccess(modelEvery10th modelEvery10th);
        void onError(Throwable error);
    }

    public interface Get10thCharCallback {
        void onSuccess(model10th model10th);
        void onError(Throwable error);
    }
}
