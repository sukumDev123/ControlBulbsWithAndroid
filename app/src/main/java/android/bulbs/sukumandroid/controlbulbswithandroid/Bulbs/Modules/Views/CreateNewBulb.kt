package android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Views

import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_create_new_bulb.*

class CreateNewBulb : AppCompatActivity() {
    private lateinit var viewModelFireBase : RealTimeDbViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_bulb)
        viewModelFireBase = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        buttonSave.setOnClickListener {
            val nameB : EditText = findViewById(R.id.nameBulb)
            val pinMode : EditText = findViewById(R.id.pinMode)
            var newChild : EditText = findViewById(R.id.nameChild)
            val bulbModel = BulbsModel(nameB.text.toString() , 0 , pinMode.text.toString() , nameChild.text.toString())
            viewModelFireBase.addNewBulb(bulbModel , newChild.text.toString(), this)
        }

    }
}
