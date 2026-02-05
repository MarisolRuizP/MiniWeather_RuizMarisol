package ruiz.marisol.miniweather_ruizm

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetallesClima : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalles_clima)
        val tvDetalle = findViewById<TextView>(R.id.tvDetalles)
        tvDetalle.text = "Detalles del clima"
    }
}