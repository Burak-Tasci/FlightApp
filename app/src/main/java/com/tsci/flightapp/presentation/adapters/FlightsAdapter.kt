package com.tsci.flightapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsci.flightapp.databinding.ItemFlightsBinding
import com.tsci.flightapp.domain.models.FlightDomainModel
import com.tsci.flightapp.presentation.viewholders.FlightViewHolder

class FlightsAdapter(           // TODO: adapter'ın kullandığın fragment ile aynı pakette olsun, viewHolder'ı da inner class olarak ekle buraya
    private val database: List<FlightDomainModel?>          // TODO: click özelliğinde yapılacak işlem için de parametre olarak metod geçir buraya, viewHolder'ı da buraya aldığında listener içerisinde bu metodu çağırırsın. Metod da parametre olarak int alsın, position'ı yollarsın. activity tarafında hangi item'a tıklandığı belli olur. Ve detay sayfasına da artık hangi item olduğu bilindiğinden dolayı o item'ı geçirmiş olursun
) : RecyclerView.Adapter<FlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        return FlightViewHolder(
            ItemFlightsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(database[position])
    }

    override fun getItemCount(): Int = database.size

}
