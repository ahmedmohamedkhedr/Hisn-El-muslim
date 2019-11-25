package com.example.hesnel_muslim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.AndroidViewModel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.hesnel_muslim.App.CHANNEL_1_ID;

public class ViewItemActivity extends AppCompatActivity {
    private String url;

    private NotificationManagerCompat notificationManagerCompat;
    private Notification notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView = findViewById(R.id.list_azkar);
        ListAzkarAdapter listAzkarAdapter = new ListAzkarAdapter(getApplicationContext(), Data.azkar);
        listView.setAdapter(listAzkarAdapter);
        url = "https://" + getIntent().getStringExtra("url").substring(7);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        Urls.wv = new WebView(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Data.azkar.clear();
        url = null;
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_audio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.listen) {
            Urls.wv = new WebView(this);
            showListeningNotificationDialog();
        }


        return super.onOptionsItemSelected(item);
    }

    private void showListeningNotificationDialog() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
            PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                    0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.microphone)
                    .setContentTitle("Listening ...")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_EVENT)
                    .setAutoCancel(true)
                    .setColor(Color.BLACK)
                    .addAction(R.mipmap.ic_launcher, "Stop listening", actionIntent).build();
            notificationManagerCompat.notify(1, notification);
            Urls.wv.loadUrl(url);
        }
        else {
            Toast.makeText(this, R.string.toast3, Toast.LENGTH_SHORT).show();
        }
    }


}
