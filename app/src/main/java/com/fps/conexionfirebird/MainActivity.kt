package com.fps.conexionfirebird

//import org.firebirdsql.javax.resource.spi.ConnectionManager
//import org.firebirdsql.jca.FBLocalTransaction
//import org.firebirdsql.jca.FBManagedConnection
//import org.firebirdsql.jdbc.AbstractConnection
//import org.w3c.dom.Text


import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import java.sql.Connection
import java.sql.DriverManager.getConnection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement


class MainActivity : AppCompatActivity() {
  //  private Connection = null
    val url:String = "jdbc:firebirdsql://192.168.102.99:3050/D:/data/FPS_LAPAZ.FDB"
    val user:String ="SYSDBA"
    val pass:String ="masterkey"
      lateinit var button2:Button
      lateinit var button1:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
         StrictMode.setThreadPolicy(policy)

        setContentView(R.layout.activity_main)
        button2 = findViewById(R.id.button2)
        button1 = findViewById(R.id.button1)

        button2.setOnClickListener {
            val conn1 = conexionDB(url, user, pass)
          if (conn1!=null){
              Toast.makeText(applicationContext, "coneccion satisfactoria", Toast.LENGTH_LONG).show()
          }
            else
          {
              Toast.makeText(applicationContext, "coneccion fallida", Toast.LENGTH_LONG).show()
          }

        }
        button1.setOnClickListener {
            val con1=Conexion(url, user, pass)
            if (con1!=null){
                Toast.makeText(applicationContext, "coneccion satisfactoria", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(applicationContext, "coneccion fallida", Toast.LENGTH_LONG).show()
            }
        }






        //  button1ejecutar()


    }
    fun conexionDB(url: String, user: String, pass: String): Connection? {
       var conexion: Connection? = null
        try {

            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance()
           // Toast.makeText(applicationContext,"cargado driver", Toast.LENGTH_SHORT).show()

         conexion = getConnection(url, user, pass)
            Toast.makeText(applicationContext, "Conectado!!", Toast.LENGTH_LONG).show()
            val stm: Statement = conexion.createStatement()
            val res: ResultSet = stm.executeQuery("SELECT * FROM VISITA")

        } catch (e: Exception) {
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
        }
        catch (se: SQLException) {
            Toast.makeText(applicationContext, se.message, Toast.LENGTH_LONG).show()
        }
        catch (e: ClassNotFoundException) {
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
        }

        return conexion
    }



    fun button1ejecutar()
    {
        finish()

    }
}