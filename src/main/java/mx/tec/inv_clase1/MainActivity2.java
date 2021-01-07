package mx.tec.inv_clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtener referencias de GUI
        nombre = findViewById(R.id.textView1);
        apellido = findViewById(R.id.textView2);

        // Obtener info de intent
        Intent intentote = getIntent();

        String nombreStr = intentote.getStringExtra("nombre");
        String apellidoStr = intentote.getStringExtra("apellido");


        nombre.setText(nombreStr);
        apellido.setText(apellidoStr);


    }



    public void regresarAActivity1(View v){
        // mandar info de regreso a la actividad que me abrió
        // crear intent

        Intent retorno = new Intent();

        retorno.putExtra("resultaldo", 1);
        retorno.putExtra("saludo", "hola!");

        // como lo "enviamos" ?
        setResult(Activity.RESULT_OK, retorno);

        finish();
    }
}