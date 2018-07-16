package example.code.musically.network;

import example.code.musically.network.model.Tracks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * The interface Api service.
 */
public interface ApiService {
    /**
     * Gets rock tracks.
     *
     * @return the rock tracks
     */
    @GET("search?term=rock&amp;media=music&amp;entity=song&amp;limit=50/")
    Call<Tracks> getRockTracks();

    /**
     * Gets pop tracks.
     *
     * @return the pop tracks
     */
    @GET("search?term=pop&amp;media=music&amp;entity=song&amp;limit=50/")
    Call<Tracks> getPopTracks();

    /**
     * Gets classic tracks.
     *
     * @return the classic tracks
     */
    @GET("search?term=classick&amp;media=music&amp;entity=song&amp;limit=50/")
    Call<Tracks> getClassicTracks();
}