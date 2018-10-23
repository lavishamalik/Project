package com.codingblocks.newsappforpitching;

import android.accounts.NetworkErrorException;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

import static com.codingblocks.newsappforpitching.Constants.API_KEY;
import static com.codingblocks.newsappforpitching.Constants.API_KEY_PARAM;
import static com.codingblocks.newsappforpitching.Constants.QUERY_PARAM;

public class AppWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new AppWidgetItemFactory(getApplicationContext(),intent);
    }

    class AppWidgetItemFactory implements RemoteViewsFactory{

        private Context context;
        private int appWidgetId;
        ArrayList<News>arrayList;
            AppWidgetItemFactory(Context context, Intent intent) {
            this.context = context;
            this.appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        @Override
        public void onCreate() {
                initData();
        }

        private void initData() {

        }

        @Override
        public void onDataSetChanged() {
                initData();
        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public RemoteViews getViewAt(int i) {
                News news=arrayList.get(i);
            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.app_widget_row);
            views.setTextViewText(R.id.tvAppWidget,news.getTitle());
            views.setImageViewUri(R.id.tvAppWidget, Uri.parse(news.getmUrl()));
        return views;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
