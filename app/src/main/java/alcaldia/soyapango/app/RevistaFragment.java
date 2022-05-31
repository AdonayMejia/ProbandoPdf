package alcaldia.soyapango.app;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

import alcaldia.soyapango.app.Adapter.RevistaAdapter;
import alcaldia.soyapango.app.Api.ApiEventoSocial;
import alcaldia.soyapango.app.Api.ApiRevista;
import alcaldia.soyapango.app.Model.EventoSocialResponse;
import alcaldia.soyapango.app.Model.RevistaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RevistaFragment extends Fragment {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RevistaAdapter revistaAdapter;
    PDFView pdfView;
    String urlPdf = "https://apiclinica.000webhostapp.com/Sitio/dashboard/upload_file/archivo/Ejemplo.pdf";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.revista_fragment,container,false);

        pdfView = rootView.findViewById(R.id.pdfView);

        new getPdf(pdfView).execute(urlPdf);

        return rootView;
    }



}
