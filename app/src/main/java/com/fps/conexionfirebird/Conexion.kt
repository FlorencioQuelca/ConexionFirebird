package com.fps.conexionfirebird

import android.widget.Toast
import java.sql.Connection
//import org.firebirdsql.javax.resource.cci.Connection
import java.sql.DriverManager
import java.sql.DriverManager.getConnection
import java.sql.SQLException
import kotlin.coroutines.coroutineContext

//import java.sql.Connection;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
class Conexion {

    val conn: Connection? = null


   constructor(url:String,user:String,pass:String) {


        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance()
            println("DRIVER REGISTRADA ")

        }catch (e:ClassNotFoundException ){
            println("error "+e.message)
          // Toast.makeText(,"Error"+e.message, Toast.LENGTH_SHORT).show()
        }
      try {

         var con12= getConnection(url,user,pass)
           if (con12!=null)
                 {   println("Conexxion exitosa ")}

      }catch (e:SQLException){
          println("Error "+e.message)
      }
    }


}