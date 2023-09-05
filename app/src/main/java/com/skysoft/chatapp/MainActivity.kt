package com.skysoft.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.chatapp.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    val data = mutableListOf<Message>()
    val adapter = MessagesRVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener{
            val msg = Message()
            msg.message = binding.messageField.text.toString()
            msg.senderId = "1"
            data.add(msg)
            binding.messageField.setText("")
            adapter.notifyDataSetChanged()
        }

//        val server = MyWebServer()
//        try {
//            server.start()
//            Log.d("MyWebServer", "Сервер запущен на порту " + server.listeningPort)
//        } catch (e: IOException) {
//            Log.e("MyWebServer", "Ошибка запуска сервера: " + e.message)
//        }

        val recyclerView: RecyclerView = findViewById(R.id.rvMessages)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        data.add(Message("Вася", "Привет всем"))
        data.add(Message("Петя", "Да, Привет"))

        adapter.arrayMessage = data
        recyclerView.adapter = adapter
    }

}