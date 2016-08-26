package com.ethanco.myrxjavapoboletrictest.model.my;

/**
 * @Description DataBean基类，用于错误时多出的Message
 * Created by EthanCo on 2016/7/6.
 */
public class BaseDataBean {

    protected String Message;
//    protected String message;

    public String getMessage() {
//        return TextUtils.isEmpty(Message) ? message : Message;
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
//        this.message = message;
    }
}
