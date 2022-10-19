package cl.aiep.android.notfoundteam.bd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import cl.aiep.android.notfoundteam.Constantes.KEY_ID
import cl.aiep.android.notfoundteam.Constantes.KEY_APELLIDOS
import cl.aiep.android.notfoundteam.Constantes.KEY_EXAMEN1
import cl.aiep.android.notfoundteam.Constantes.KEY_EXAMEN2
import cl.aiep.android.notfoundteam.Constantes.KEY_EXAMEN3
import cl.aiep.android.notfoundteam.Constantes.KEY_NOMBRES
import cl.aiep.android.notfoundteam.Constantes.KEY_RUT
import cl.aiep.android.notfoundteam.Constantes.KEY_FECHANACIMIENTO
import cl.aiep.android.notfoundteam.Constantes.KEY_SEXO
import cl.aiep.android.notfoundteam.Constantes.TABLA_INGRESOS
import cl.aiep.android.notfoundteam.clases.Ingresos

class BaseDeDatos(
    context: Context,
    nombreBaseDatos: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(
    context, nombreBaseDatos, factory, version
) {

    //Se va a ejecutar esta funcion cuando se cree la base de datos
    override fun onCreate(db: SQLiteDatabase?) {
        //Se crea la tabla
        val createTable =
            "CREATE TABLE $TABLA_INGRESOS($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT,$KEY_NOMBRES TEXT,$KEY_APELLIDOS TEXT, $KEY_RUT TEXT, $KEY_FECHANACIMIENTO TEXT, $KEY_SEXO TEXT, $KEY_EXAMEN1 TEXT, $KEY_EXAMEN2 TEXT, $KEY_EXAMEN3 TEXT)"
        db?.execSQL(createTable)
    }

    //Se va a crear esta funcion cuando actualice el numero de la version de la base de datos
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    //Metodo para insertar la informacion
    fun agregarIngresos(datoRecibido: Ingresos): Long {
        //Declaramos la base de datos en modo de escritura
        val db = this.writableDatabase
        //Declaro un contentedor de datos que voy a guardar en la Base de datos
        val contentValues = ContentValues()
        //Al contenedor le asigno el dato con su respectiva key
        contentValues.put(KEY_RUT, datoRecibido.rut)
        contentValues.put(KEY_NOMBRES, datoRecibido.nombres)
        contentValues.put(KEY_APELLIDOS, datoRecibido.apellidos)
        contentValues.put(KEY_FECHANACIMIENTO, datoRecibido.fechaDeNacimiento)
        contentValues.put(KEY_SEXO, datoRecibido.sexo)
        contentValues.put(KEY_EXAMEN1, datoRecibido.examen1)
        contentValues.put(KEY_EXAMEN2, datoRecibido.examen2)
        contentValues.put(KEY_EXAMEN3, datoRecibido.examen3)
        // Insertar los datos
        val success = db.insert(TABLA_INGRESOS, null, contentValues)
        //2nd argument is String containing nullColumnHack
        db.close() // Cerrando la base de datos
        return success
    }

    //Metodo para Listar la informacion
    fun listarIngresos(): ArrayList<Ingresos>{
        //Generando una lista vacia sin data
        val listaData = ArrayList<Ingresos>()
        //Declaramos la base de datos en modo de lectura
        val db = this.readableDatabase
        //Declaro la sentencia SQL que voy a ejecutar
        var sqlQuery = "Select * from $TABLA_INGRESOS"
        //Declaro un cursor para recorrer la data que me traiga la query
        var cursor = db.rawQuery(sqlQuery, null)
        //Voy a recorrer este cursor valor pòr valor
        while (cursor.moveToNext()){
            //Se crea un objeto lugar y se crea como objeto para agregarlo a la lista
            val ingreso = Ingresos(
                cursor.getInt(0).toString(),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8)
            )
            //Se agrega la data a la lista
            listaData.add(ingreso)
        }

        //Lo que va a retornar esta funcion
        return listaData
    }

}