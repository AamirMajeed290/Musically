package example.code.musically;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ConnectException;
import java.util.List;

import example.code.musically.network.ApiClient;
import example.code.musically.network.ApiService;
import example.code.musically.network.ConnectionVerifier;
import example.code.musically.network.model.Result;
import example.code.musically.network.model.Tracks;
import example.code.musically.views.TracksAdapter;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Realm.
     */
    Realm realm;
    /**
     * The Tracks call.
     */
    Call<Tracks> tracksCall;
    /**
     * The Api service.
     */
    ApiService apiService;
    /**
     * The Tracks.
     */
    Tracks tracks;
    /**
     * The M toolbar.
     */
    Toolbar mToolbar;
    /**
     * The Swipe layout.
     */
    SwipeRefreshLayout swipeLayout;
    /**
     * The Connection verifier.
     */
    ConnectionVerifier connectionVerifier;
    /**
     * The Navigation.
     */
    BottomNavigationView navigation;
    /**
     * The Navigation button.
     */
    Button navigationButton;
    /**
     * The Realm configuration.
     */
    RealmConfiguration realmConfiguration;


    /**
     * The Recycler view.
     */
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        swipeLayout = findViewById(R.id.swipe_container);
        navigationButton = findViewById(R.id.navigation_button);
        connectionVerifier = new ConnectionVerifier(this);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        apiService = ApiClient.getClient(this).create(ApiService.class);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Realm.init(this);
        realm=Realm.getDefaultInstance();





        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code here
                Toast.makeText(getApplicationContext(), "Please Wait while Loading data", Toast.LENGTH_LONG).show();
                // To keep animation for 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Stop animation (This will be after 3 seconds)
                        swipeLayout.setRefreshing(false);
                    }
                }, 4000); // Delay in millis
            }
        });

        //check connectivity to load APIs
        if (connectionVerifier.isOnline()) {





            tracksCall = apiService.getRockTracks();
            getTrackList(tracksCall);


//load from Realm if no connection found
        } else {


            realm.beginTransaction();
            RealmResults<Result> tracks = realm.where(Result.class).findAll();
            TracksAdapter starWarAdapter = new TracksAdapter(tracks);
            recyclerView.setAdapter(starWarAdapter);
            realm.commitTransaction();
            navigation.setVisibility(View.GONE);
            navigationButton.setVisibility(View.VISIBLE);
            swipeLayout.setEnabled(false);

            recyclerView.setTop(navigationButton.getBottom());


            Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();

        }


    }

    /**
     *
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {


                case R.id.rock:



                    tracksCall = apiService.getRockTracks();
                    getTrackList(tracksCall);


                    return true;
                case R.id.classic:

                    tracksCall = apiService.getClassicTracks();
                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(getTrackList(tracksCall).getResults());
                    realm.commitTransaction();


                        return true;

                case R.id.pop:

                    tracksCall = apiService.getPopTracks();
                    getTrackList(tracksCall);

                    return true;
            }
            return false;
        }
    };


    /**
     * Gets track list.
     *
     * @param tracksCall the tracks call
     * @return track list
     */
    public Tracks getTrackList(Call<Tracks> tracksCall) {

        tracksCall.enqueue(new Callback<Tracks>() {
            @Override
            public void onResponse(Call<Tracks> call, Response<Tracks> response) {

                tracks = response.body();


                TracksAdapter starWarAdapter = new TracksAdapter(tracks.getResults());
                recyclerView.setAdapter(starWarAdapter);

            }

            @Override
            public void onFailure(Call<Tracks> call, Throwable t) {
                Log.d("FailedResponce", "message execute failure");

            }
        });


        return tracks;
    }



}