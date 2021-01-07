package mx.tec.inv_clase1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textito;
    EditText entrada;
    Button botoncito;
    Button botoncito2;

    private static final int ACTIVITY2_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // link con la interfaz grafica
        setContentView(R.layout.activity_main);
        // Como obtener referencia con la GUI
        textito = findViewById(R.id.textito);
        entrada = findViewById(R.id.entrada);
        botoncito = findViewById(R.id.button2);
        botoncito2 = findViewById(R.id.botoncito2);
        textito.setText("Hola mundo otra vez!");

        Log.i("ONCREATE", "LOG DE INFO"); // log de info
        Log.d("ONCREATE", "LOG DE DEBUG"); // de debug
        Log.w("ONCREATE", "LOG DE WARNING"); // de debug
        Log.e("ONCREATE", "LOG DE ERROR"); // de debug
        Log.wtf("ONCREATE", "WHAT A TERRIBLE FAILURE!");



    botoncito2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, entrada.getText(), Toast.LENGTH_SHORT).show();
        }
    });

    // detectar clicks
    // 2 maneras -
    // - método que reciba View y regrese void (público), hacer vínculo en XML de interaz
    // - clase anónima


}

    public void interaccion1(View v){
        // toast - mensajito temporal en parte inferior de celular
        Toast.makeText(this, "BOTON PRESIONADO", Toast.LENGTH_SHORT).show();

        // para abrir nueva actividad hay que solicitarlo
        // hay que llenar forma para hacer solicitud
        // forma == intent
        // explicito con tipo o implicito con accion
        Intent intentito = new Intent(this, MainActivity2.class);

        intentito.putExtra("nombre", "Juan");
        intentito.putExtra("apellido", entrada.getText().toString());

        // startActivity - no espera resultado
        //startActivity(intentito);

        // startActivityForResult - espera algo de vuelta
        startActivityForResult(intentito, ACTIVITY2_CODE);

    }

    // ¿donde recibirlo?
    // este método escucha el retorno de TODAS las actividades que abramos desde esta actividad
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY2_CODE && resultCode == Activity.RESULT_OK && data != null){

            //-100 un valor por default
            int resultado = data.getIntExtra("resultado", -100);
            String saludo = data.getStringExtra("saludo");

            Toast.makeText(this, "saludos: " + saludo + " " + resultado, Toast.LENGTH_SHORT).show();

        }

    }
}