package dietbisabesok.com.bukanitip.di.component;

import android.app.Application;

import com.google.gson.Gson;

import java.io.File;

import dagger.Component;
import dietbisabesok.com.bukanitip.activity.addnewrequest.service.AddNewRequestService;
import dietbisabesok.com.bukanitip.activity.addnewoffering.service.AddOfferingService;
import dietbisabesok.com.bukanitip.activity.detailrequest.service.DetailRequestService;
import dietbisabesok.com.bukanitip.fragment.profile.service.FetchDetailUserService;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllCountryListService;
import dietbisabesok.com.bukanitip.activity.login.service.LoginService;
import dietbisabesok.com.bukanitip.activity.login.service.UpdateUserService;
import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.di.module.AppModule;
import dietbisabesok.com.bukanitip.di.module.AppUIModule;
import dietbisabesok.com.bukanitip.di.module.NetworkModule;
import dietbisabesok.com.bukanitip.di.module.UserModule;
import dietbisabesok.com.bukanitip.di.scope.ApplicationScope;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllRequestListService;
import dietbisabesok.com.bukanitip.fragment.myrequest.service.MyRequestService;
import dietbisabesok.com.bukanitip.model.CountryDataModel;
import dietbisabesok.com.bukanitip.model.RequestDataModel;
import dietbisabesok.com.bukanitip.network.NetworkService;
import dietbisabesok.com.bukanitip.session.LoginSession;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */

@ApplicationScope
@Component(
        modules = {AppModule.class, AppUIModule.class, NetworkModule.class, UserModule.class}
)
public interface AppComponent extends IAppComponent {
    final static class Initializer {
        public static AppComponent init(BukaNitipApp app){
            File cacheFile = new File(app.getCacheDir(), "api_cache");
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .networkModule(new NetworkModule(cacheFile))
                    .build();
        }
    }

    Application getApplication();
    Gson gson();
    LoginSession loginSession();
    NetworkService networkService();

    /*API Services*/
    LoginService loginService();
    UpdateUserService updateUserService();
    FetchAllCountryListService fetchAllCountryListService();
    AddNewRequestService addNewRequestService();
    MyRequestService myRequestService();
    FetchAllRequestListService fetchAllRequestListService();
    FetchDetailUserService fetchDetailUserService();
    AddOfferingService addOfferingService();
    DetailRequestService detailRequestService();

    /*Model DB*/
    CountryDataModel countryDataModel();
    void inject(CountryDataModel countryDataModel);
    RequestDataModel requestDataModel();
    void inject(RequestDataModel requestDataModel);
}
