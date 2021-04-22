package com.example.listviewteste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    val form = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
    val currentDate = form.format(Date())
    var horas : MutableList<String> = arrayListOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewHora = findViewById<ListView>(R.id.listViewHora)
        val horaAdapter = HoraAdapter()
        listViewHora.adapter = horaAdapter

    }

    inner class HoraAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return horas.size
        }

        override fun getItem(position: Int): Any {
            return horas[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = layoutInflater.inflate(R.layout.layout_hours, parent, false)

            val textViewHora = view.findViewById<TextView>(R.id.textViewHora)

            textViewHora.text = horas[position]

            findViewById<Button>(R.id.button).setOnClickListener {
                horas.add(position, currentDate)
                notifyDataSetChanged()
            }


            return view
        }

    }
}