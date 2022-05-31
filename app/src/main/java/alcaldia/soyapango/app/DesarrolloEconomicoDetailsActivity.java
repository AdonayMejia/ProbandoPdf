package alcaldia.soyapango.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import alcaldia.soyapango.app.Model.DesarrolloEconomicoResponse;
import alcaldia.soyapango.app.Model.EventoSocialResponse;

public class DesarrolloEconomicoDetailsActivity extends AppCompatActivity {
    TextView descripcion;
    TextView titulo;
    ImageView imagen;
    DesarrolloEconomicoResponse desarrolloEconomicoResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrollo_economico_details);

        descripcion  = findViewById(R.id.DescripcionEconomico);
        imagen  = findViewById(R.id.EconomicoImgeView);
        titulo = findViewById(R.id.EconomicoTitledesc);

        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            desarrolloEconomicoResponse = (DesarrolloEconomicoResponse) intent.getSerializableExtra("data");

            String usernamedata = desarrolloEconomicoResponse.getDescripcion();
            String titleEvent = desarrolloEconomicoResponse.getNombre();
            //String img = userResponse.getLast_name();

            String urlImg = "https://apiclinica.000webhostapp.com/Sitio/dashboard/Imagenes/";


            Picasso.get().load(urlImg + desarrolloEconomicoResponse.getFoto()).into(imagen);


            descripcion.setText(usernamedata);
            titulo.setText(titleEvent);




        }
    }
}