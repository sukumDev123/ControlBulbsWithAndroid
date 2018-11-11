package android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Views

import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_new_bulb.*

class CreateNewBulb : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_bulb)
        val fireBaseDB : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef = fireBaseDB.getReference("bulb-123")
  
        buttonSave.setOnClickListener {
            val nameB : EditText = findViewById(R.id.nameBulb)
            val pinMode : EditText = findViewById(R.id.pinMode)
            val bulbModel : BulbsModel = BulbsModel("${nameB.text}" , 0 , "${pinMode.text}")
            myRef.setValue(bulbModel)

        }
    }
}
