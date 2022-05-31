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
import androidx.recyclerview.widget.RecyclerView;

import alcaldia.soyapango.app.Adapter.EventoSocialAdapter;
import alcaldia.soyapango.app.Api.ApiEventoSocial;
import alcaldia.soyapango.app.Model.EventoSocialResponse;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventoSocialFragment extends Fragment implements EventoSocialAdapter.ClickedItem {

    Toolbar toolbar;
    RecyclerView recyclerView;

    EventoSocialAdapter eventoSocialAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.evento_social_fragment,container,false);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        toolbar = rootView.findViewById(R.id.toolbar);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        eventoSocialAdapter = new EventoSocialAdapter(this::ClickedUser);

        getAllEvents();

        return rootView;
    }

    private void getAllEvents() {

        Call<List<EventoSocialResponse>> eventslist = ApiEventoSocial.getEventService().getAllEvents();

        eventslist.enqueue(new Callback<List<EventoSocialResponse>>() {
            @Override
            public void onResponse(Call<List<EventoSocialResponse>> call, Response<List<EventoSocialResponse>> response) {

                if (response.isSuccessful()) {
                    List<EventoSocialResponse> eventoSocialRespons = response.body();
                    eventoSocialAdapter.setData(eventoSocialRespons);
                    recyclerView.setAdapter(eventoSocialAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<EventoSocialResponse>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public void ClickedUser(EventoSocialResponse eventoSocialResponse) {
        Intent intent = new Intent(getActivity(),EventoSocialDetailsActivity.class).putExtra("data", eventoSocialResponse);
        startActivity(intent);
    }
}
