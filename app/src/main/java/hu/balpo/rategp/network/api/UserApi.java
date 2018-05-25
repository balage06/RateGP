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

}