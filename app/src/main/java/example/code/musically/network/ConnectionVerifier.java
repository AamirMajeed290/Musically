package example.code.musically.network;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.security.Permission;

/**
 * The type Connection verifier.
 */
public class ConnectionVerifier {


    /**
     * The Context.
     */
    Context context;

    /**
     * Instantiates a new Connection verifier.
     *
     * @param context the context
     */
    public ConnectionVerifier(Context context) {
        this.context = context;
    }

    /**
     * Is online boolean.
     *
     * @return boolean
     */
    public boolean isOnline() {



            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
            if (cm != null) {


                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork != null) {
                    if (activeNetwork.isConnected()) {

                        return true;

                    }
                   
                }



            }
        return false;
    }
}
