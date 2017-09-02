package ardnahcimor.orp.truecallercalls.dependencies;

import javax.inject.Singleton;

import ardnahcimor.orp.truecallercalls.view.RunActivity;
import ardnahcimor.orp.truecallercalls.network.NetworkModule;
import dagger.Component;

/**
 * Created by romichandra on 26-08-2017.
 */

@Singleton
@Component(modules={NetworkModule.class,})
public interface Dependencies {
    public void inject(RunActivity runActivity);
}
