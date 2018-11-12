package android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Firebase

import android.app.Activity
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Views.CreateNewBulb
import android.bulbs.sukumandroid.controlbulbswithandroid.MainActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RealTimeDbViewModel : ViewModel(){
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val nameR : String = "bulb-parant"
    val realTimeDBFireBase : RealTimeDBFireBaseLiveData = RealTimeDBFireBaseLiveData(nameR, firebaseDatabase)
    fun updateStatusBulb(status: Int , child : String) {
       status?.let {
           firebaseDatabase.getReference(nameR).child(child).child("statusBulb").setValue(status)
       }
    }

    fun addNewBulb(bulb : BulbsModel , nameChild : String , viewAvtivity : AppCompatActivity) {
        bulb?.let {
            firebaseDatabase.getReference(nameR).child(nameChild).setValue(bulb).addOnSuccessListener {
                suc ->
                val intent = Intent(viewAvtivity , MainActivity::class.java)
                viewAvtivity.startActivity(intent)
            }
        }
    }
}