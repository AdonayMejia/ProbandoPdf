package alcaldia.soyapango.app.Interface;

import java.util.List;

import alcaldia.soyapango.app.Model.DesarrolloEconomicoResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DesarrolloEconomicoService {
    @GET("api2")
    Call<List<DesarrolloEconomicoResponse>> getAllEvents();
}
