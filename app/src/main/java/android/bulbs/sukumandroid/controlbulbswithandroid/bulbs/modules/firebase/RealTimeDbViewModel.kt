package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase

import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.MainActivity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.database.FirebaseDatabase

class RealTimeDbViewModel : ViewModel(){
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val nameR : String = "bulb-parant"
    val realTimeDBFireBase : RealTimeDBFireBaseLiveData = RealTimeDBFireBaseLiveData(nameR, firebaseDatabase)
    fun updateStatusBulb(status: Int? , child : String) {
       status?.let {
           firebaseDatabase.getReference(nameR).child(child).child("statusBulb").setValue(status)

       }
    }

    fun addNewBulb(bulb : BulbsModel? , nameChild : String ) : Task<Void>{

        return firebaseDatabase.getReference(nameR).child(nameChild).setValue(bulb)

    }
}