package example.code.musically.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * The type Tracks.
 */
public class Tracks {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    /**
     * Gets result count.
     *
     * @return the result count
     */
    public Integer getResultCount() {
        return resultCount;
    }

    /**
     * Sets result count.
     *
     * @param resultCount the result count
     */
    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

}
