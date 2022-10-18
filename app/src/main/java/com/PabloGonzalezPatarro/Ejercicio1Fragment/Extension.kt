package com.PabloGonzalezPatarro.Ejercicio1Fragment

//Fichero donde definimos las funciones de extensión para algunas de las clases.


import android.widget.ImageView
import com.bumptech.glide.Glide

//Creamos esta función para reutilizarla.
fun ImageView.loadUrl(url: String){
    Glide.with(this)
        .load(url)
        .into(this)
}