package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase

import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class RealTimeDbViewModel : ViewModel(){
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val nameR : String = "bulb-parant"
    val realTimeDBFireBase : RealTimeDBFireBaseLiveData = RealTimeDBFireBaseLiveData(nameR, firebaseDatabase)
    fun updateStatusBulb(status: Int? , child : String ) {
       status?.let {
           val firebaseProcess = firebaseDatabase.getReference(nameR).child(child)
           firebaseProcess.child("statusBulb").setValue(status).addOnSuccessListener {
               if(status == 1) {
                   firebaseProcess.child("createAt").setValue(Date().time)
               } else {
                   firebaseProcess.child("createAt").setValue(0)

               }
           }

       }
    }

    fun addNewBulb(bulb : BulbsModel? , nameChild : String ) : Task<Void>{

        return firebaseDatabase.getReference(nameR).child(nameChild).setValue(bulb)

    }
}