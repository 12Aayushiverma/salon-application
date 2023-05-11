package com.letsconnecot.utils;

import com.letsconnecot.model.response.CommonResponse;

public class HelperClass {

    public static CommonResponse getNullRequestResoponse() {
        CommonResponse  commonResponse = new  CommonResponse();
        commonResponse.setMessage(Message.NULL_REQUEST);
        commonResponse.setStatusCode(Constant.NULL_REQUEST);

        return  commonResponse;

    }

    public static CommonResponse getCommonExceptionResoponse() {
        CommonResponse  commonResponse = new  CommonResponse();
        commonResponse.setMessage(Message.SOMETHING_WENT_WRONG);
        commonResponse.setStatusCode(Constant.ERROR_CD);

        return  commonResponse;

    }
}
