package alcaldia.soyapango.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import alcaldia.soyapango.app.Model.EventoSocialResponse;
import alcaldia.soyapango.app.R;

import com.squareup.picasso.Picasso;

import java.util.List;


public class EventoSocialAdapter extends RecyclerView.Adapter<EventoSocialAdapter.EventoAdapterVH > {

    private List<EventoSocialResponse> eventoSocialResponseList;
    private Context context;
    private ClickedItem clickedItem;

    public EventoSocialAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void setData(List<EventoSocialResponse> eventoSocialResponseList) {
        this.eventoSocialResponseList = eventoSocialResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventoAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new EventoAdapterVH (LayoutInflater.from(context).inflate(R.layout.eventosocial_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapterVH  holder, int position) {

        EventoSocialResponse eventoSocialResponse = eventoSocialResponseList.get(position);

        String nombre = eventoSocialResponse.getNombre();
        String lugar = eventoSocialResponse.getLugar();
        String urlImg = "https://apiclinica.000webhostapp.com/Sitio/dashboard/Imagenes/";
        String fecha = eventoSocialResponse.getFecha();

        Picasso.get().load(urlImg + eventoSocialResponse.getFoto()).into(holder.imageMore);
        holder.nombre.setText(nombre);
        holder.lugar.setText(lugar);
        holder.fecha.setText(fecha);
        holder.itemSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedUser(eventoSocialResponse);
            }
        });

    }

    public interface ClickedItem {
        public void ClickedUser(EventoSocialResponse eventoSocialResponse);
    }

    @Override
    public int getItemCount() {
        return eventoSocialResponseList.size();
    }

    public class EventoAdapterVH  extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView lugar;
        TextView fecha;
        ImageView imageMore;
        CardView itemSelected;

        public EventoAdapterVH (@NonNull View itemView) {
            super(itemView);
            itemSelected = itemView.findViewById(R.id.cardViewItemSocialEvent);
            nombre = itemView.findViewById(R.id.txtNombre);
            lugar = itemView.findViewById(R.id.txtLugar);
            imageMore = itemView.findViewById(R.id.imageMore);
            fecha = itemView.findViewById(R.id.date);


        }
    }
}
