package com.example.luis.pruebalistviewpersonalizado;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luis on 21/11/2017.
 */

public class Adaptador implements ListAdapter{
ArrayList<Contacto> lista_contactos;
    Context contexto;

    public Adaptador(ArrayList<Contacto> lista_contactos, Context contexto) {
        this.lista_contactos = lista_contactos;
        this.contexto = contexto;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return lista_contactos.size();
    }

    @Override
    public Object getItem(int i) {
        return lista_contactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(contexto);
        View vista=inflater.inflate(R.layout.contacto, viewGroup, false);
        TextView tv_nombre=(TextView)vista.findViewById(R.id.tv_nombre);
        TextView tv_telefono=(TextView)vista.findViewById(R.id.tv_telefono);
        tv_nombre.setText(lista_contactos.get(i).getNombre());
        tv_telefono.setText(lista_contactos.get(i).getTelefono());
        return vista;
    }

    @Override
    public int getItemViewType(int i) {
        return lista_contactos.size();
    }

    @Override

    public int getViewTypeCount() {
        return lista_contactos.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }
}
