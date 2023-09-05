package com.skysoft.chatapp

import fi.iki.elonen.NanoHTTPD

class MyWebServer: NanoHTTPD("0.0.0.0", 8080) {
    override fun serve(session: IHTTPSession?): Response {
        // Обработка HTTP-запросов здесь
        val responseText = "Привет, мир!"
        val resp = newFixedLengthResponse(responseText)
        return resp
    }
}