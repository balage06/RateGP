package hu.balpo.rategp.network.api;

import hu.balpo.rategp.model.ApiResponse;
import hu.balpo.rategp.model.User;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserApi {

  @POST("login")
  Call<ApiResponse> login();


  /**
   * Logs user into the system
   *
   * @param username The user name for login
   * @param password The password for login in clear text
   * @return Call<String>
   */

  @GET("user/login")
  Call<String> loginUser(
          @Query("username") String username, @Query("password") String password
  );


  /**
   * Logs out current logged in user session
   *
   * @return Call<Void>
   */

  @GET("user/logout")
  Call<Void> logoutUser();



  /**
   * Get user by user name
   *
   * @param username The name that needs to be fetched. Use user1 for testing.
   * @return Call<User>
   */

  @GET("user/{username}")
  Call<User> getUserByName(
          @Path("username") String username
  );


}