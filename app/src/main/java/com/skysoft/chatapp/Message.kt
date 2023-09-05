package com.skysoft.chatapp

import java.util.Date

class Message(var senderId: String = "",
              var message: String = "",
              val messageTime: Long = Date().time) {


}