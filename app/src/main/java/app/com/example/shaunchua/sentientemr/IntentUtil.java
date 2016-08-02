package app.com.example.shaunchua.sentientemr;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by shaunchua on 1/8/16.
 */
public class IntentUtil {
    private Activity activity;

    // constructor
    public IntentUtil(Activity activity) {
        this.activity = activity;
    }

    public void showAccessToken() {
        Intent i = new Intent(activity, AccessTokenActivity.class);
        activity.startActivity(i);
    }
}
