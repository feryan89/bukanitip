package dietbisabesok.com.bukanitip.fragment.myrequest.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class MyRequestServiceResponse extends CommonResponse {
    @SerializedName("list_iklan")
    public List<RequestData> requestDataList;
}
