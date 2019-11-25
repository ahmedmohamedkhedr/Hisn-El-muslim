package com.example.hesnel_muslim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button buttonAr, buttonEn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonAr = findViewById(R.id.button_ar);
        buttonEn = findViewById(R.id.button_en);
        buttonAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                JsonObjectRequest jsonObjectRequest = getJsonObjectRequest(Urls.LANGUAGE_URL_AR, "العربية");
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
                Data.language = "ar";
            }
        });

        buttonEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                JsonObjectRequest jsonObjectRequest = getJsonObjectRequest(Urls.LANGUAGE_URL_EN, "English");
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
                Data.language = "en";
            }
        });

    }

    public JsonObjectRequest getJsonObjectRequest(String url, final String key) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray dataArray = response.getJSONArray(key);
                    for (int i = 0; i < dataArray.length(); i++) {
                        Data data = new Data();
                        String title = dataArray.getJSONObject(i).getString("TITLE");
                        String audioUrl = dataArray.getJSONObject(i).getString("AUDIO_URL");
                        String txtUrl = dataArray.getJSONObject(i).getString("TEXT");
                        data.setTitle(title);
                        data.setAudioUrl(audioUrl);
                        data.setTxtUrl(txtUrl);
                        Data.container.add(data);

                    }
                    progressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(getApplicationContext(), ViewAzkarTitelsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, R.string.toast1, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, R.string.toast2, Toast.LENGTH_LONG).show();

            }
        });
        return jsonObjectRequest;

    }

}

