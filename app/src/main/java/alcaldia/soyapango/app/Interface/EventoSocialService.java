package alcaldia.soyapango.app.Interface;

import alcaldia.soyapango.app.Model.EventoSocialResponse;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

public interface EventoSocialService {

    @GET("api")
    Call<List<EventoSocialResponse>> getAllEvents();

}
