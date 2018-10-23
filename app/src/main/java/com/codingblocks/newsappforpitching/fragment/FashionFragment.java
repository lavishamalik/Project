package com.codingblocks.newsappforpitching.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.Loader;
import android.util.Log;

import com.codingblocks.newsappforpitching.BookmarksDatabase;
import com.codingblocks.newsappforpitching.News;
import com.codingblocks.newsappforpitching.NewsLoader;
import com.codingblocks.newsappforpitching.NewsPreferences;
import com.codingblocks.newsappforpitching.R;


import java.util.List;

@SuppressLint("ValidFragment")
public class FashionFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = FashionFragment.class.getName();

    public FashionFragment(BookmarksDatabase bookmarksDatabase) {
        super(bookmarksDatabase);
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String fashionUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.fashion));
        Log.e(LOG_TAG, fashionUrl);

        return new NewsLoader(getActivity(), fashionUrl);
    }
}
