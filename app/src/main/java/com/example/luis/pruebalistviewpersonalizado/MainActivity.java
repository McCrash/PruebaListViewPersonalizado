package com.example.luis.pruebalistviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


//Comentario en MainActivity para ver commit
public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv_lista_contactos);
        ArrayList<Contacto> lista_contactos=new ArrayList();
        lista_contactos.add(new Contacto("Pepe", "445431126"));
        lista_contactos.add(new Contacto("Ana", "946657878"));
        ListAdapter adaptador=new Adaptador(lista_contactos, this);
        lv.setAdapter(adaptador);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o=adapterView.getItemAtPosition(i);//Esto es un objeto contacto porque es lo que le pasamos al adaptador
                Contacto c=(Contacto)o;
                Log.v("Clicado", o.getClass().toString());
            }
        });
    }
}
