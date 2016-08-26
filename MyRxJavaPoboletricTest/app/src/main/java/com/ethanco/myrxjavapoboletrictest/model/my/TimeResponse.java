package com.ethanco.myrxjavapoboletrictest.model.my;

/**
 * @Description Time Response
 * Created by EthanCo on 2016/6/12.
 */
public class TimeResponse extends BaseBeanResponse<TimeResponse.Entity> {

    public static class Entity extends BaseDataBean {
        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }

        private String Time;
    }
}
