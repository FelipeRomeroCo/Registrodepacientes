package cl.aiep.android.notfoundteam.adaptador

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cl.aiep.android.notfoundteam.R
import cl.aiep.android.notfoundteam.Registros
import cl.aiep.android.notfoundteam.clases.Ingresos
import cl.aiep.android.notfoundteam.databinding.ActivityDashboardBinding
import cl.aiep.android.notfoundteam.databinding.ActivityRegistrosBinding

class Adaptador(
    val listaIngresos: List<Ingresos>,
    val binding: ActivityRegistrosBinding,
    val listarIngreso: Registros

    ) :
    RecyclerView.Adapter<Adaptador.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombres: TextView
        val tvApellidos: TextView
        val tvExamen1: TextView
        val tvExamen2: TextView
        val tvExamen3: TextView


        init {
            // Define click listener for the ViewHolder's View.
            tvNombres = view.findViewById(R.id.tvNombres)
            tvApellidos = view.findViewById(R.id.tvApellidos)
            tvExamen1 = view.findViewById(R.id.tvExamen1)
            tvExamen2 = view.findViewById(R.id.tvExamen2)
            tvExamen3 = view.findViewById(R.id.tvExamen3)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_elemento_lista, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //Nombre
        holder.tvNombres.text = listaIngresos.get(position).nombres
        holder.tvApellidos.text = listaIngresos.get(position).apellidos
    //    holder.tvExamen1.text = listaIngresos.get(position).examen1
    //    holder.tvExamen2.text = listaIngresos.get(position).examen2
    //    holder.tvExamen3.text = listaIngresos.get(position).examen3
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return listaIngresos.size
    }

}