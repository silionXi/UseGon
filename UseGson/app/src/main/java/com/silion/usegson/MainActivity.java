package com.silion.usegson;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.single: {
                    AssetManager assetManager = MainActivity.this.getAssets();
                    try {
                        SingleObject object = new Gson().fromJson(new InputStreamReader(assetManager.open("singleObject")), SingleObject.class);
                        android.util.Log.v("slong.liang", object.toString());

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.setDateFormat("yyyy-mm-dd HH:mm:ss");
                        SingleObjectData objectData = gsonBuilder.create().fromJson(new InputStreamReader(assetManager.open("singleObject")), SingleObjectData.class);
                        android.util.Log.v("slong.liang", objectData.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case R.id.nested: {
                    AssetManager assetManager = MainActivity.this.getAssets();
                    Reader json = null;
                    try {
                        InputStream is = assetManager.open("nestedObject");
                        json = new InputStreamReader(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    NestedObject object = new Gson().fromJson(json, NestedObject.class);
                    android.util.Log.v("slong.liang", object.toString());
                    break;
                }
                case R.id.array: {
                    AssetManager assetManager = MainActivity.this.getAssets();

                    Reader json1 = null;
                    try {
                        json1 = new InputStreamReader(assetManager.open("arrayObject"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //解析成数组
                    Gson gson = new Gson();
                    SingleObject[] objects = gson.fromJson(json1, SingleObject[].class);
                    List<SingleObject> objectList1 = Arrays.asList(objects);
                    android.util.Log.v("slong.liang", "-------Array method 1--------");
                    for(SingleObject object : objectList1) {
                        android.util.Log.v("slong.liang", object.toString());
                    }

                    Reader json2 = null;
                    try {
                        json2 = new InputStreamReader(assetManager.open("arrayObject"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //解析成List
                    Type listType = new TypeToken<ArrayList<SingleObject>>(){}.getType();
                    List<SingleObject> objectList2 = gson.fromJson(json2, listType);
                    android.util.Log.v("slong.liang", "-------Array method 2--------");
                    for(SingleObject object : objectList2) {
                        android.util.Log.v("slong.liang", object.toString());
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button singleButton = (Button) findViewById(R.id.single);
        singleButton.setOnClickListener(mClickListener);
        Button nestedButton = (Button) findViewById(R.id.nested);
        nestedButton.setOnClickListener(mClickListener);
        Button arrayButton = (Button) findViewById(R.id.array);
        arrayButton.setOnClickListener(mClickListener);
    }
}