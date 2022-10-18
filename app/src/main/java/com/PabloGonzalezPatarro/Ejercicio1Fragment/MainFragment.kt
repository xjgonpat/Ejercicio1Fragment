package com.PabloGonzalezPatarro.Ejercicio1Fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.PabloGonzalezPatarro.Ejercicio1Fragment.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val listaContactos = listOf<Contacto>(
        Contacto("https://loremflickr.com/320/240?lock=1","Juan","Juan@ejemplo.com","999000111"),
        Contacto("https://loremflickr.com/320/240?lock=2", "Pepe","Pe_pe@ejemplo.com","686993321"),
        Contacto("https://loremflickr.com/320/240?lock=3","Diego","diego@ejemplo.com","666000555")
    )

    override fun  onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        //Creamos el binding
        val binding = FragmentMainBinding.bind(view).apply{
            recycler.adapter = ContactosAdapter(listaContactos) { contacto->
                navigateTo(contacto)
            }
        }
        //Para mantener el título de la app en la actionBar.
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

    }

    private fun navigateTo(contacto: Contacto)
    {
        //Sin animaciones.
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, DetailFragment.create(contacto))
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()


    }

}