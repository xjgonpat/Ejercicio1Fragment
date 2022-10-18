package com.PabloGonzalezPatarro.Ejercicio1Fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.PabloGonzalezPatarro.Ejercicio1Fragment.databinding.ContactoItemBinding

class ContactosAdapter(
    private val contactos:List<Contacto>,
    val contactoClickListener: (Contacto)->Unit):
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Creamos un binding para pasarselo al viewHolder como parámetro.
        val binding = ContactoItemBinding.inflate(
            LayoutInflater
            .from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos[position]
        holder.bind(contacto)

        //Utilizamos la función lambda recibida como parámetro.
        holder.itemView.setOnClickListener{
            contactoClickListener(contacto)
        }
    }

    override fun getItemCount(): Int = contactos.size

    class ViewHolder(val binding : ContactoItemBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(contact:Contacto)
        {
            //Usamos una función de extensión para cargar la imagen.
            binding.imagen.loadUrl(contact.foto)
            binding.tvNombre.text=contact.nombre
            binding.tvTelef.text=contact.telefono
            binding.tvEmail.text=contact.correo

        }
    }
}