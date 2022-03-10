package com.helpchildren.appupdate;

import android.os.Bundle;
import android.util.Log;

import com.sesxh.appupdata.bean.UpdateInfo;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String aa="{\"versionName\":\"1.0.1\",\"description\":\"更新描述\",\"apkurl\":\"http://192.168.129.243:9001/app/app.apk\",\"isForce\":\"1\"}";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(aa);
            String versionName = jsonObject.optString("versionName","1.0.0");
            String description = jsonObject.optString("description","");
            String apkurl = jsonObject.optString("apkurl","");
            String isForce = jsonObject.optString("isForce","1");
            UpdateInfo updateInfo = new UpdateInfo(versionName, description, apkurl, isForce);
            Log.e("lfntest","updateInfo:"+updateInfo.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}