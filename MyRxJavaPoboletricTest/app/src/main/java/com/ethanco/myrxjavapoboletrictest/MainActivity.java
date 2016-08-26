package com.ethanco.myrxjavapoboletrictest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ethanco.myrxjavapoboletrictest.model.my.CmdRequest;
import com.ethanco.myrxjavapoboletrictest.model.my.TimeResponse;
import com.ethanco.myrxjavapoboletrictest.net.APIServiceMy;
import com.ethanco.myrxjavapoboletrictest.net.RetrofitFactory;
import com.ethanco.myrxjavapoboletrictest.utils.EncryUtil;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Response;

import static junit.framework.Assert.assertNotNull;

public class MainActivity extends AppCompatActivity {

    private APIServiceMy apiServiceMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiServiceMy = RetrofitFactory.getInstance().createRetrofit("http://121.40.227.8:8088/").create(APIServiceMy.class);
        new Thread() {
            @Override
            public void run() {
                getTime();
            }
        }.start();
    }

    public void getTime() {
        try {
            Response<TimeResponse> resposne = apiServiceMy.getServerTime(generateServiceTimeCmd()).execute();
            String time = resposne.body().getData().getTime();
            System.out.println("time:" + time);
            assertNotNull(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成 登录 CmdRequest
     *
     * @param time     服务器时间
     * @param userName 用户名
     * @param pwd      密码
     * @return
     */
    public CmdRequest generateLoginCmd(String time, String userName, String pwd) {
        CmdRequest cmd = new CmdRequest();
        cmd.setCmd("VerifyUser");
        String sign = userName + "user|" + EncryUtil.MD5(pwd, "UTF-8").toUpperCase() + "PWD#" + time + "Time";//签名
        HashMap<String, String> map = new HashMap<>();
        map.put("MobileNo", userName);
        map.put("Time", time);
        map.put("Password", EncryUtil.MD5(pwd, "UTF-8").toUpperCase());
        map.put("Sign", EncryUtil.MD5(sign, "UTF-8").toUpperCase());
        cmd.setData(map);
        return cmd;
    }

    /**
     * 生成 获取服务器时间 CmdRequest
     *
     * @return
     */
    public CmdRequest generateServiceTimeCmd() {
        CmdRequest cmd = new CmdRequest();
        cmd.setCmd("GetServerTime");
        return cmd;
    }
}
