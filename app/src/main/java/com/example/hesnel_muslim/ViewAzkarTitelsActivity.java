package com.example.hesnel_muslim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewAzkarTitelsActivity extends AppCompatActivity {
    ListView listView;
    ListAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_azkar_titels);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.azkar_list);
        adapter = new ListAdapter(getApplicationContext(), Data.container);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                progressBar = findViewById(R.id.progressBar2);
                progressBar.setVisibility(View.VISIBLE);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://" + Data.container.get(position).getTxtUrl().substring(7), null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray;
                        try {
                            if (Data.language.equals("ar")) {
                                jsonArray = response.getJSONArray(Urls.arJsonArrayKeys[position]);
                            } else {
                                jsonArray = response.getJSONArray(Data.container.get(position).getTitle());
                            }

                            for (int i = 0; i < jsonArray.length(); i++) {
                                if (Data.language.equals("ar")) {
                                    Data.azkar.add(jsonArray.getJSONObject(i).getString("ARABIC_TEXT"));
                                } else {
                                    Data.azkar.add(jsonArray.getJSONObject(i).getString("TRANSLATED_TEXT"));
                                }
                            }
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(getApplicationContext(), ViewItemActivity.class);
                            intent.putExtra("url",Data.container.get(position).getAudioUrl());
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), R.string.toast2, Toast.LENGTH_LONG).show();


                    }
                });

                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Data.container.clear();
        Data.language = null;
        finish();
    }


}
