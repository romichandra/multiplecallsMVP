package ardnahcimor.orp.truecallercalls.network;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import ardnahcimor.orp.truecallercalls.BuildConfig;
import ardnahcimor.orp.truecallercalls.network.converters.ModelConverterFactory;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by romichandra on 26-08-2017.
 */

@Module
public class NetworkModule {

    File cacheFile;

    public NetworkModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @Provides
    @Singleton
    Retrofit provideCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .removeHeader("Pragma")
                                .header("Cache-Control", String.format("max-age=%d", BuildConfig.CACHETIME))
                                .build();

                        okhttp3.Response response = chain.proceed(request);
                        response.cacheResponse();
                        return response;
                    }
                })
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(new ModelConverterFactory())
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public IService providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(IService.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Service providesService(
            IService networkService) {
        return new Service(networkService);
    }
}
