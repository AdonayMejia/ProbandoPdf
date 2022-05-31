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

import com.github.barteksc.pdfviewer.PDFView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import alcaldia.soyapango.app.Model.EventoSocialResponse;
import alcaldia.soyapango.app.Model.RevistaResponse;
import alcaldia.soyapango.app.R;

public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.RevisAdapterVH> {

    private List<RevistaResponse> revistaResponseList;
    private Context context;
    private RevistaAdapter clickedItem;



    public void setData(List<RevistaResponse> revistaResponseList) {
        this.revistaResponseList = revistaResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RevisAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new RevisAdapterVH (LayoutInflater.from(context).inflate(R.layout.revista_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaAdapter.RevisAdapterVH holder, int position) {

        RevistaResponse revistaResponse = revistaResponseList.get(position);

        String nombre = revistaResponse.getName();
        String urlPdf = "https://apiclinica.000webhostapp.com/Sitio/dashboard/upload_file/archivo/Ejemplo.pdf";

        Picasso.get().load(urlPdf + revistaResponse.getName()).into((Target) holder.pdfView);


    }


    @Override
    public int getItemCount() {
        return revistaResponseList.size();
    }

    public class RevisAdapterVH  extends RecyclerView.ViewHolder {

 PDFView pdfView;

        public RevisAdapterVH (@NonNull View itemView) {
            super(itemView);
            pdfView = itemView.findViewById(R.id.pdfView);

        }
    }
}
