package com.example.expensetrackerapp


import android.content.Context
import java.io.*

object InternalStorageHelper {
     const val LOGIN_FILE = "login.txt"

    fun saveLoginCredentials(context: Context, name: String, password: String) {
        val file = File(context.filesDir, LOGIN_FILE)
        val fileContents = "$name|$password"
        FileOutputStream(file).use { stream ->
            stream.write(fileContents.toByteArray())
        }
    }

    fun getLoginCredentials(context: Context): Pair<String?, String?> {
        val file = File(context.filesDir, LOGIN_FILE)
        if (!file.exists()) {
            return Pair(null, null)
        }
        FileInputStream(file).use { stream ->
            val reader = BufferedReader(InputStreamReader(stream))
            val line = reader.readLine()
            if (line != null) {
                val parts = line.split("|")
                if (parts.size == 2) {
                    return Pair(parts[0], parts[1])
                }
            }
        }
        return Pair(null, null)
    }

     const val USERS_FILE = "users.txt"

    fun saveUser(context: Context, name: String, password: String) {
        val file = File(context.filesDir, USERS_FILE)
        val fileContents = "$name|$password"
        FileOutputStream(file, true).use { stream ->
            stream.write(fileContents.toByteArray())
            stream.write(System.lineSeparator().toByteArray())
        }
    }

    fun getUser(context: Context, name: String): Pair<String?, String?>? {
        val file = File(context.filesDir, USERS_FILE)
        if (!file.exists()) {
            return null
        }
        FileInputStream(file).use { stream ->
            val reader = BufferedReader(InputStreamReader(stream))
            var line = reader.readLine()
            while (line != null) {
                val parts = line.split("|")
                if (parts.size == 4 && parts[2] == name) {
                    return Pair(parts[0], parts[3])
                }
                line = reader.readLine()
            }
        }
        return null
    }
}