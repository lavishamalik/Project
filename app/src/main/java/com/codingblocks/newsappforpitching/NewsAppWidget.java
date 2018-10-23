package com.codingblocks.newsappforpitching;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.RemoteViews;

//import static com.codingblocks.newsappforpitching.AppWidgetConfig.KEY_BUTTON_TEXT;
//import static com.codingblocks.newsappforpitching.AppWidgetConfig.SHARED_PREFS;

public class NewsAppWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int appWidgetId:appWidgetIds)
        {
            Intent intent=new Intent(context,MainActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);

        //    SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
         //   String buttonText = prefs.getString(KEY_BUTTON_TEXT + appWidgetId, "Press me");
            Intent serviceintent=new Intent(context,AppWidgetService.class);
            serviceintent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            serviceintent.setData(Uri.parse(serviceintent.toUri(Intent.URI_INTENT_SCHEME)));

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.widget_layout);
       //     views.setOnClickPendingIntent(R.id.btnwidget, pendingIntent);
        //    views.setCharSequence(R.id.btnwidget, "setText", buttonText);
            views.setRemoteAdapter(R.id.StackView,serviceintent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }


    }
}
