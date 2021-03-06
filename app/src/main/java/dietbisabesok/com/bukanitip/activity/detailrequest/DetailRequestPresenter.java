package dietbisabesok.com.bukanitip.activity.detailrequest;

import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.addnewoffering.AddNewOfferingActivity;
import dietbisabesok.com.bukanitip.activity.addnewoffering.service.AddOfferingService;
import dietbisabesok.com.bukanitip.activity.addnewrequest.AddNewRequestActivity;
import dietbisabesok.com.bukanitip.activity.detailrequest.service.DetailRequestResponse;
import dietbisabesok.com.bukanitip.activity.detailrequest.service.DetailRequestService;
import dietbisabesok.com.bukanitip.activity.listoffering.ListOfferingActivity;
import dietbisabesok.com.bukanitip.data.ListOfferingData;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.helper.CurrencyHelper;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.session.LoginSession;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreen;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class DetailRequestPresenter extends ViewPresenter<DetailRequestView> {
    @Inject
    DetailRequestService mDetailRequestService;

    @Inject
    ActivityScreenSwitcher mActivityScreenSwitcher;

    @Inject
    LoginSession mLoginSession;

    @Inject
    Gson gson;

    private DetailRequestActivity mActivity;
    private RequestData mRequestData;
    private String status = null;
    private List<ListOfferingData> mListOfferingData;

    public DetailRequestPresenter(DetailRequestActivity activity, RequestData requestData){
        mActivity = activity;
        mRequestData = requestData;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        fetchDetailService(mRequestData);
        Glide.with(mActivity.getApplicationContext())
                .load(mRequestData.img_url)
                .placeholder(R.drawable.borobudur)
                .into(getView().mRequestImageView);
        getView().mRequestName.setText(mRequestData.title);
        getView().mRequestBudget.setText(CurrencyHelper.CurrencyHelper(Long.valueOf(mRequestData.budget)));
        getView().mRequestDescription.setText(mRequestData.description);
        if(mRequestData.status_titipan == 1){
            status = "Waiting Offering";
        }else if(mRequestData.status_titipan == 2){

        }else if(mRequestData.status_titipan == 3){
            status = "Payment Confirmed";
        }else if(mRequestData.status_titipan == 4){
            status = "Package Sent from Diaspora";
        }else{
            status = "Package Confirmed Arrived";
        }
        getView().mRequestStatus.setText(status);
        onFinishActivity();
        getView().mBtnAddOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivityScreenSwitcher.open(new AddNewOfferingActivity.Screen(mRequestData));
            }
        });

        getView().mBtnListOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListOfferingData != null){
                    mActivityScreenSwitcher.open(new ListOfferingActivity.Screen(mListOfferingData));
                }
            }
        });
    }

    private void fetchDetailService(RequestData requestData){
        HashMap<String, String> mParam  = new HashMap<>();
        mParam.put("email", mLoginSession.getEmail());
        mParam.put("token", mLoginSession.getLoginToken());
        mParam.put("user_id", mLoginSession.getUserID());
        mParam.put("id_iklan", String.valueOf(requestData.id));
        mDetailRequestService.init(mParam);
        mDetailRequestService.fetchDetailRequest(new DetailRequestService.GetResponseCallback() {
            @Override
            public void onSuccess(DetailRequestResponse dataList) {
                    mListOfferingData = dataList.mListOfferingDataList;
            }

            @Override
            public void onError(NetworkError networkError) {
                Log.d(getClass().getName(), networkError.getMessage());
            }
        });
    }

    private void onFinishActivity(){
        getView().mRequestBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }
}
