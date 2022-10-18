package com.PabloGonzalezPatarro.Ejercicio1Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.PabloGonzalezPatarro.Ejercicio1Fragment.databinding.FragmentDetailBinding
import com.PabloGonzalezPatarro.Ejercicio1Fragment.databinding.FragmentMainBinding
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {

    companion object
    {
        const val EXTRA_CONTACTO = "contacto"

        //Función estática que llamamos en el Main.
        fun create(contacto: Contacto): DetailFragment =
            DetailFragment().apply {
                arguments = bundleOf(EXTRA_CONTACTO to contacto)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)

        val contacto = arguments?.getParcelable<Contacto>(EXTRA_CONTACTO)

        if(contacto != null) {
            binding.imagenContacto.loadUrl(contacto.foto)
            binding.tvNombreDetail.text = contacto?.nombre

            //En el evento del botón de llamar enseñamos un toast
            binding.btnLlamar.setOnClickListener()
            {
                //USAMOS URI PARA ABRIR LA APP DE LLAMADAS.
            }

            //En el evento del botón del email enseñamos un toast
            binding.btnEmail.setOnClickListener()
            {
                //USAMOS URI PARA ABRIR LA APP DEL CORREO.

            }
        }


    }

}

