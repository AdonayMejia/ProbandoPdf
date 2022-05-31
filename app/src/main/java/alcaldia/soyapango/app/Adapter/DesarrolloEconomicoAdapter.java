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

import com.squareup.picasso.Picasso;

import java.util.List;

import alcaldia.soyapango.app.Model.DesarrolloEconomicoResponse;

import alcaldia.soyapango.app.R;

public class DesarrolloEconomicoAdapter extends RecyclerView.Adapter<DesarrolloEconomicoAdapter.DesarrolloAdapterVH>{

    private List<DesarrolloEconomicoResponse> desarrolloEconomicoResponseList;
    private Context context;
    private ClickedItem clickedItem;

    public DesarrolloEconomicoAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void setData(List<DesarrolloEconomicoResponse> desarrolloEconomicoResponseList) {
        this.desarrolloEconomicoResponseList = desarrolloEconomicoResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DesarrolloAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new DesarrolloAdapterVH(LayoutInflater.from(context).inflate(R.layout.desarrollo_economico_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DesarrolloAdapterVH holder, int position) {

        DesarrolloEconomicoResponse desarrolloEconomicoResponse = desarrolloEconomicoResponseList.get(position);

        String nombre = desarrolloEconomicoResponse.getNombre();
        String lugar = desarrolloEconomicoResponse.getLugar();
        String urlImg = "https://apiclinica.000webhostapp.com/Sitio/dashboard/Logos/";
        String telefono = desarrolloEconomicoResponse.getTelefono();
        String facebook = desarrolloEconomicoResponse.getFacebook();
        String instagram = desarrolloEconomicoResponse.getInstagram();
        String whatsapp = desarrolloEconomicoResponse.getWhatsApp();

        Picasso.get().load(urlImg + desarrolloEconomicoResponse.getLogo()).into(holder.imageSocial);
        holder.nombre.setText(nombre);
        holder.lugar.setText(lugar);
        holder.telefono.setText(telefono);
        holder.facebook.setText(facebook);
        holder.instagram.setText(instagram);
        holder.whatsapp.setText(whatsapp);
        holder.itemSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedUser(desarrolloEconomicoResponse);
            }
        });

    }

    public interface ClickedItem {
        public void ClickedUser(DesarrolloEconomicoResponse desarrolloEconomicoResponse);
    }

    @Override
    public int getItemCount() {
        return desarrolloEconomicoResponseList.size();
    }

    public class DesarrolloAdapterVH  extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView telefono;
        TextView lugar;
        TextView facebook;
        TextView instagram;
        TextView whatsapp;
        ImageView imageSocial;
        CardView itemSelected;

        public DesarrolloAdapterVH (@NonNull View itemView) {
            super(itemView);
            itemSelected = itemView.findViewById(R.id.cardViewItem);
            nombre = itemView.findViewById(R.id.txtNombre);
            lugar = itemView.findViewById(R.id.txtLugar);
            imageSocial = itemView.findViewById(R.id.imageSocial);
            telefono = itemView.findViewById(R.id.numeroTel);
            facebook = itemView.findViewById(R.id.txtFacebook);
            instagram = itemView.findViewById(R.id.txtInstagram);
            whatsapp = itemView.findViewById(R.id.txtWhatsApp);

        }
    }


}
