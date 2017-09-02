package ardnahcimor.orp.truecallercalls.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import ardnahcimor.orp.truecallercalls.dependencies.DaggerDependencies;
import ardnahcimor.orp.truecallercalls.dependencies.Dependencies;
import ardnahcimor.orp.truecallercalls.network.NetworkModule;

/**
 * Created by romichandra on 26-08-2017.
 */

public class BaseActivity extends AppCompatActivity {
    public Dependencies mDependencies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        mDependencies = DaggerDependencies.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Dependencies getDependencies() {
        return mDependencies;
    }
}