package com.myapps.intents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * Created by mhewedy on 7/4/13.
 */
public class IntentHelper {

    public static MainActivityIntents prepareInents(Activity context) {
        MainActivityIntents mainActivityIntents = new MainActivityIntents();
        mainActivityIntents.mCallIntent = prepareCallIntent(context);
        mainActivityIntents.mOpenUrlIntent = prepareOpenUrlIntent(context);
        mainActivityIntents.mSendEmailIntent = prepareSendEmailIntent(context);
        mainActivityIntents.mGetMapIntnet = prepareGetMapIntent(context);
        drawIntentButtons(mainActivityIntents, context);

        return mainActivityIntents;
    }

    private static void drawIntentButtons(MainActivityIntents mMainActivityIntents, Activity context) {

        if (mMainActivityIntents.mCallIntent == null) {
            context.findViewById(R.id.call_button).setEnabled(false);
        }

        if (mMainActivityIntents.mOpenUrlIntent == null) {
            context.findViewById(R.id.call_open_url).setEnabled(false);
        }

        if (mMainActivityIntents.mSendEmailIntent == null) {
            context.findViewById(R.id.send_mail).setEnabled(false);
        }

        if (mMainActivityIntents.mGetMapIntnet == null) {
            context.findViewById(R.id.map_button).setEnabled(false);
        }
    }

    private static Intent prepareGetMapIntent(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:123,456"));
        return isIntentSafe(intent, context) ? intent : null;
    }

    private static Intent prepareSendEmailIntent(Context context) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"daziplqa@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello Intents");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello Intents in body");
        return isIntentSafe(intent, context) ? intent : null;
    }

    private static Intent prepareOpenUrlIntent(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
        return isIntentSafe(intent, context) ? intent : null;
    }

    private static Intent prepareCallIntent(Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01061072006"));
        return isIntentSafe(intent, context) ? intent : null;
    }

    private static boolean isIntentSafe(Intent intent, Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, 0);
        return resolveInfos.size() > 0;
    }

    public static class MainActivityIntents {
        public Intent mCallIntent;
        public Intent mOpenUrlIntent;
        public Intent mSendEmailIntent;
        public Intent mGetMapIntnet;
    }
}
