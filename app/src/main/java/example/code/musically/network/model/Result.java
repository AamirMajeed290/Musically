package example.code.musically.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * The type Result.
 */
public class Result extends RealmObject {

    @SerializedName("artistId")
    @Expose
    private Integer artistId;
    @SerializedName("collectionId")
    @Expose
    private Integer collectionId;
    @SerializedName("trackId")
    @Expose
    private Integer trackId;
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("collectionName")
    @Expose
    private String collectionName;
    @SerializedName("trackName")
    @Expose
    private String trackName;
    @SerializedName("previewUrl")
    @Expose
    private String previewUrl;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("trackPrice")
    @Expose
    private Double trackPrice;

    /**
     * Gets artist id.
     *
     * @return the artist id
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * Sets artist id.
     *
     * @param artistId the artist id
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    /**
     * Gets collection id.
     *
     * @return the collection id
     */
    public Integer getCollectionId() {
        return collectionId;
    }

    /**
     * Sets collection id.
     *
     * @param collectionId the collection id
     */
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * Gets track id.
     *
     * @return the track id
     */
    public Integer getTrackId() {
        return trackId;
    }

    /**
     * Sets track id.
     *
     * @param trackId the track id
     */
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    /**
     * Gets artist name.
     *
     * @return the artist name
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Sets artist name.
     *
     * @param artistName the artist name
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * Gets collection name.
     *
     * @return the collection name
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Sets collection name.
     *
     * @param collectionName the collection name
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * Gets track name.
     *
     * @return the track name
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * Sets track name.
     *
     * @param trackName the track name
     */
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    /**
     * Gets preview url.
     *
     * @return the preview url
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * Sets preview url.
     *
     * @param previewUrl the preview url
     */
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    /**
     * Gets artwork url 60.
     *
     * @return the artwork url 60
     */
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    /**
     * Sets artwork url 60.
     *
     * @param artworkUrl60 the artwork url 60
     */
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    /**
     * Gets track price.
     *
     * @return the track price
     */
    public Double getTrackPrice() {
        return trackPrice;
    }

    /**
     * Sets track price.
     *
     * @param trackPrice the track price
     */
    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

}