package hu.balpo.rategp.network.api;

import hu.balpo.rategp.model.Event;
import hu.balpo.rategp.model.Review;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EventApi {

  /**
   * Find event details by event ID
   *
   * @param seriesId ID of the series
   * @param eventId ID of the event
   * @return Call<Event>
   */

  @GET("series/{seriesId}/{eventId}")
  Call<Event> getReviewsByEventId(
          @Path("seriesId") Long seriesId, @Path("eventId") Long eventId
  );


  /**
   * Post a new review for an event
   *
   * @param seriesId ID of the series
   * @param eventId ID of the event
   * @param review Create review object
   * @return Call<Void>
   */

  @POST("series/{seriesId}/{eventId}")
  Call<Void> postReviewForEvent(
          @Path("seriesId") Long seriesId, @Path("eventId") Long eventId, @Body Review review
  );


}