package iss.workshop.adproject.DataService;

import iss.workshop.adproject.Model.BlogUser;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import java.util.List;

import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserDataService {

    @GET("/account/api/blogusers")
    Call<List<BlogUser>> findAllActiveUser();

    @Headers("Content-Type: application/json")
    @POST("/account/api/bloguser")
    Call<ResponseBody> createUser(@Body BlogUser user);
}
