package app.com.example.shaunchua.sentientemr;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by shaunchua on 1/8/16.
 */
public class PrefUtil {

    private Activity activity;

    // constructor
    public PrefUtil(Activity activity) {
        this.activity = activity;
    }

    public void saveAccessToken(String token) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token", token);
        editor.apply();
    }

    public String getToken() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
        return sp.getString("token", null);
    }

    public void clearToken() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }
}
