package com.tsci.flightapp.presentation.viewholders

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tsci.flightapp.R
import com.tsci.flightapp.data.network.common.FlightStatus
import com.tsci.flightapp.databinding.ItemFlightsBinding
import com.tsci.flightapp.domain.models.FlightDomainModel
import com.tsci.flightapp.presentation.ui.details.DetailsActivity
import com.tsci.weatherapp.presentation.navigation.ScreensNavigator
import javax.inject.Inject

class FlightViewHolder(             // TODO: Hangi adapter içerisinde kullanıyorsan orada inner class şeklinde yaz, adapter ile bir bütün olduklarından ayrı yazılmazlar
    private val binding: ItemFlightsBinding
) : RecyclerView.ViewHolder(binding.root) {


    @Inject lateinit var screensNavigator: ScreensNavigator

    fun bind(item: FlightDomainModel?) {            // TODO: non-nullable yapabilirsin, boşa null kontrolü yapma. null ise değer adapter'ı hiç oluşturmazsın zaten fragment içerisinde
        if (item != null) {

            // TODO: xml'de component isimleri her zaman türünün kısaltması ile başlasın, genel bir isimlendirme kuralıdır bu. Örneğin tvLabel, tvResult, ivResult, clFlight vb.
            with(binding) {
                airportLine.labelText.text = binding.root.context.getString(R.string.airline)
                airportLine.resultText.text = item.airline.toString()

                departureLine.labelText.text = binding.root.context.getString(R.string.departure)
                departureLine.resultText.text = item.departure?.estimated.toString()        // TODO: Servisten "2022-06-11T00:40:00+00:00" şeklinde geliyor, bunu parse edip kullanıcıya göstermelisin. Kullanıcı böyle okuyamaz. 

                arrivalLine.labelText.text = binding.root.context.getString(R.string.arrival)
                arrivalLine.resultText.text = item.arrival?.estimated.toString()

                when(item.flightStatus){
                    FlightStatus.ACTIVE -> {
                        status.background.setTint(ContextCompat.getColor(status.context, R.color.active))       // TODO: ImageView olarak kullanıp setImageResource metodunu kullanabilirsin
                    }
                    FlightStatus.CANCELLED -> {
                        status.background.setTint(ContextCompat.getColor(status.context, R.color.cancelled))
                    }
                    FlightStatus.SCHEDULED -> {
                        status.background.setTint(ContextCompat.getColor(status.context, R.color.scheduled))
                    }
                }
                delayTimeText.text = (item.arrival?.delay ?: item.departure?.delay).toString()      // TODO: delay null ise yine delay vermişsin..
            }
        }
        binding.toDetailsBtn.setOnClickListener {           // TODO: component'in alanı çok dar olduğundan dolayı da tıklama yapılamıyor, padding şart
            DetailsActivity.open(it.context)                // TODO: click özelliklerini adapter içerisinde yapma, adapter'a parametre ile fragment'tan metod taşı. Örnek kullanımına bakalım olmadı beraber. Bu şekilde halledemeyeceğin işler olacak çünkü
        }
    }


}
