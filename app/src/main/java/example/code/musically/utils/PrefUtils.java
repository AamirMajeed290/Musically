package example.code.musically.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * The type Pref utils.
 */
public class PrefUtils {

    /**
     * Instantiates a new Pref utils.
     */
    public PrefUtils() {
    }
    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
    }

    /**
     * Store api key.
     *
     * @param context the context
     * @param apiKey  the api key
     */
    public static void storeApiKey(Context context, String apiKey) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("API_KEY", apiKey);
        editor.commit();
    }

    /**
     * Gets api key.
     *
     * @param context the context
     * @return the api key
     */
    public static String getApiKey(Context context) {
        return getSharedPreferences(context).getString("API_KEY", null);
    }
}
