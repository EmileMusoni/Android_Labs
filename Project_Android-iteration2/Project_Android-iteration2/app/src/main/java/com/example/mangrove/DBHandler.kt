package com.example.mangrove
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mangrove.compose.ProductModel

class DBHandler

    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        val query = ("CREATE TABLE " + TABLE_NAME + " ("

                + NAME_COL + " TEXT,"
                + PHONE_NUMBER_COL + " TEXT , "
                + LOCATION_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + CONFPASSWORD_COL + " TEXT)")

        db.execSQL(query)
       // ProductName

        //Kilograms per Sack

       // NumberOfSack

        val queryb = ("CREATE TABLE " + TABLE_PRODUCT + " ("

                + PHONES_NUMBER_COL + " TEXT,"
                + PRODUCT_NAME_COL + " TEXT , "
                + KG_COL + " TEXT,"
                + NUMBER_OF_SACK_COL + " TEXT,"
               )

        db.execSQL(queryb)

 }


fun addNewFarmer(
    FarmerName: String?,
    FarmerPhone: String?,
    FarmerLocation: String?,
    FarmerEmail: String?,
    FarmerPassword: String?,
    ConfirmPassword: String?
     )
    {

        val db = this.writableDatabase

        val values = ContentValues()
        values.put(NAME_COL, FarmerName)
        values.put(PHONE_NUMBER_COL, FarmerPhone)
        values.put(LOCATION_COL, FarmerLocation)
        values.put(EMAIL_COL, FarmerEmail)
        values.put(PASSWORD_COL, FarmerPassword)
        values.put(CONFPASSWORD_COL, ConfirmPassword)

        db.insert(TABLE_NAME, null, values)

    db.close()
   }

    fun addNewpRODYCT(
        productPhone: String?,
        productName: String?,
        productKg: String?,
        programSacks: String?,

    )
    {


        val dbb = this.writableDatabase

        val values = ContentValues()
        values.put(PHONES_NUMBER_COL, productPhone)
        values.put(PRODUCT_NAME_COL, productName)
        values.put(KG_COL, productKg)
        values.put(NUMBER_OF_SACK_COL, programSacks)


        dbb.insert(TABLE_PRODUCT, null, values)

        dbb.close()
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
    onCreate(db)
}


    fun checkUser(email: String, password: String): Boolean {

        val columns = arrayOf(PHONE_NUMBER_COL)
        val db = this.readableDatabase
        // selection criteria
        val selection = "$EMAIL_COL = ? AND $PASSWORD_COL = ?"

        val selectionArgs = arrayOf(email, password)

        val cursor = db.query(TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        if (cursorCount > 0)
            return true
        return false
    }

companion object {

        private const val DB_NAME = "mangrovedb"
        // below int is our database version
        private const val DB_VERSION = 1

        private const val TABLE_NAME = "farmers"

        private const val NAME_COL = "name"
        // below variable id for our course duration column.
        private const val PHONE_NUMBER_COL = "phonenumber"
        // below variable for our course description column.
        private const val LOCATION_COL = "location"
                  // below variable is for our course tracks column.
        private const val EMAIL_COL = "emails"
        private const val PASSWORD_COL = "passwords"
        private const val CONFPASSWORD_COL = "confirmpassword"

        //Variables for table product
        private const val TABLE_PRODUCT = "products"
        private const val PHONES_NUMBER_COL="productPhone"
        private const val PRODUCT_NAME_COL="productName"
        private const val KG_COL="productKg"
        private const val NUMBER_OF_SACK_COL="programSacks"

        }


   fun readFarmers(): ArrayList<FarmerModel>? {
   val db = this.readableDatabase


      val cursorFarmers: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME ", null)
      val framerModelArrayList: ArrayList<FarmerModel> = ArrayList()
       if (cursorFarmers.moveToFirst()) {
            do {
                framerModelArrayList.add(
            FarmerModel(
                cursorFarmers.getString(0),
                cursorFarmers.getString(1),
                cursorFarmers.getString(2),
                cursorFarmers.getString(3),
                cursorFarmers.getString(4),
                cursorFarmers.getString(5)
            ))
     } while (cursorFarmers.moveToNext())
            }
        cursorFarmers.close()
        return framerModelArrayList
      }

    }
/*
fun readProducts(): ArrayList<ProductModel>? {
    val db = this.readableDatabase


    val cursorProducts: Cursor = db.rawQuery(sql:"SELECT * FROM $TABLE_PRODUCT ", null)
    val productModelArrayList: ArrayList<ProductModel> = ArrayList()
    if (cursorProducts.moveToFirst()) {
        do {
            productModelArrayList.add(
                ProductModel(
                    cursorProducts.getString(0),
                    cursorProducts.getString(1),
                    cursorProducts.getString(2),
                    cursorProducts.getString(3)

                ))
        } while (cursorProducts.moveToNext())
    }
    cursorProducts.close()
    return productModelArrayList
}

}
*/
