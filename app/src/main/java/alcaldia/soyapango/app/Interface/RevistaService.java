package alcaldia.soyapango.app.Interface;

import java.util.List;


import alcaldia.soyapango.app.Model.RevistaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RevistaService {

    @GET("api3")
    Call<List<RevistaResponse>> getAllEvents();

}


