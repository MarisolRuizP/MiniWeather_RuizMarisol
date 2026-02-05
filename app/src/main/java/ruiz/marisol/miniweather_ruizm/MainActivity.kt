package ruiz.marisol.miniweather_ruizm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var ivWeather: ImageView
    private lateinit var tvTemp: TextView
    private lateinit var tvWeather: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvGreet = findViewById<TextView>(R.id.tvGreetings)
        tvGreet.text = "Hello there!"
        val tvCity = findViewById<TextView>(R.id.tvCity)
        tvCity.text = "Edimburgo"
        ivWeather = findViewById<ImageView>(R.id.ivWeather)
        ivWeather.setImageResource(R.drawable.ic_rainy)
        tvTemp = findViewById<TextView>(R.id.tvTemperature)
        tvTemp.text = "10°C"
        tvWeather = findViewById<TextView>(R.id.tvWeather)
        tvWeather.text = "Rainy"
        //Al hacer click en el clima se lanza la otra activity
        tvWeather.setOnClickListener {
            val intent = Intent(this, DetallesClima::class.java)
            startActivity(intent)
        }

        // Botón para cambiar el clima
        val btnCambiarClima = findViewById<Button>(R.id.btnCambiarClima)
        btnCambiarClima.setOnClickListener {
            opcionesClima()
        }
    }
    private fun opcionesClima() {
        val opciones = arrayOf("Sunny", "Cloudy", "Rainy", "Snowy", "Stormy", "Windy")

        AlertDialog.Builder(this)
            .setTitle("Selecciona el clima")
            .setItems(opciones) { _, which ->
                cambiarClima(opciones[which])
            }
            .show()
    }

    private fun cambiarClima(clima: String) {
        when (clima) {
            "Soleado" -> {
                ivWeather.setImageResource(R.drawable.ic_sunny)
                tvWeather.text = "Soleado"
                tvTemp.text = "25°C"
            }
            "Nublado" -> {
                ivWeather.setImageResource(R.drawable.ic_cloudy)
                tvWeather.text = "Nublado"
                tvTemp.text = "18°C"
            }
            "Lluvioso" -> {
                ivWeather.setImageResource(R.drawable.ic_rainy)
                tvWeather.text = "Lluvioso"
                tvTemp.text = "10°C"
            }
            "Nieve" -> {
                ivWeather.setImageResource(R.drawable.ic_snowy)
                tvWeather.text = "Nieve"
                tvTemp.text = "-2°C"
            }
            "Tormentas" -> {
                ivWeather.setImageResource(R.drawable.ic_stormy)
                tvWeather.text = "Tormentas"
                tvTemp.text = "15°C"
            }
            "Ventoso" -> {
                ivWeather.setImageResource(R.drawable.ic_windy)
                tvWeather.text = "Ventoso"
                tvTemp.text = "12°C"
            }
        }
    }
}