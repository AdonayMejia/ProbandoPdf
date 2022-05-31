package alcaldia.soyapango.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import alcaldia.soyapango.app.Model.EventoSocialResponse;

public class EventoSocialDetailsActivity extends AppCompatActivity {

    TextView descripcion;
    TextView titulo;
    ImageView imagen, imgBack;
    EventoSocialResponse eventoSocialResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_social_details);

        descripcion  = findViewById(R.id.DescripcionTextView);
        imagen  = findViewById(R.id.posterImgeView);
        imgBack = findViewById(R.id.img_regresar);
        titulo = findViewById(R.id.EventoTitledesc);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irFragmento();
            }
        });
        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            eventoSocialResponse = (EventoSocialResponse) intent.getSerializableExtra("data");

            String usernamedata = eventoSocialResponse.getDescripcion();
            String titleEvent = eventoSocialResponse.getNombre();
            //String img = userResponse.getLast_name();

            String urlImg = "https://apiclinica.000webhostapp.com/Sitio/dashboard/Imagenes/";


            Picasso.get().load(urlImg + eventoSocialResponse.getFoto()).into(imagen);


            descripcion.setText(usernamedata);
            titulo.setText(titleEvent);




        }
    }

    private void irFragmento() {

}}