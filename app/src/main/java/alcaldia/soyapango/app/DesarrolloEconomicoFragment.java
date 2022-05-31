package alcaldia.soyapango.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import alcaldia.soyapango.app.Adapter.DesarrolloEconomicoAdapter;
import alcaldia.soyapango.app.Api.ApiDesarrolloEconomico;
import alcaldia.soyapango.app.Api.ApiEventoSocial;
import alcaldia.soyapango.app.Model.DesarrolloEconomicoResponse;
import alcaldia.soyapango.app.Model.EventoSocialResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DesarrolloEconomicoFragment extends Fragment implements DesarrolloEconomicoAdapter.ClickedItem {

    Toolbar toolbar;
    RecyclerView recyclerView;
    DesarrolloEconomicoAdapter desarrolloEconomicoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.desarrollo_economico_fragment,container,false);

        recyclerView = rootView.findViewById(R.id.recyclerviewEconomico);
        toolbar = rootView.findViewById(R.id.toolbarEconomico);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        desarrolloEconomicoAdapter = new DesarrolloEconomicoAdapter(this::ClickedUser);

        getAllEvents();

        return rootView;
    }

    private void getAllEvents() {

        Call<List<DesarrolloEconomicoResponse>> eventslist = ApiDesarrolloEconomico.getDesarrolloService().getAllEvents();

        eventslist.enqueue(new Callback<List<DesarrolloEconomicoResponse>>() {
            @Override
            public void onResponse(Call<List<DesarrolloEconomicoResponse>> call, Response<List<DesarrolloEconomicoResponse>> response) {

                if (response.isSuccessful()) {
                    List<DesarrolloEconomicoResponse> desarrolloEconomicoRespons = response.body();
                    desarrolloEconomicoAdapter.setData(desarrolloEconomicoRespons);
                    recyclerView.setAdapter(desarrolloEconomicoAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<DesarrolloEconomicoResponse>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public void ClickedUser(DesarrolloEconomicoResponse desarrolloEconomicoResponse) {
        Intent intent = new Intent(getActivity(),DesarrolloEconomicoDetailsActivity.class).putExtra("data", desarrolloEconomicoResponse);
        startActivity(intent);
    }
}
