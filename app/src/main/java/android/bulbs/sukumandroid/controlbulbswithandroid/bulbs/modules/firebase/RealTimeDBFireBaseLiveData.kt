package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase

import androidx.lifecycle.LiveData
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RealTimeDBFireBaseLiveData(nameReference: String , fireBaseDb : FirebaseDatabase ) : LiveData<List<BulbsModel>>() {
    private val dbRef = fireBaseDb.getReference(nameReference)
    override fun onActive() {
        dbRef.addValueEventListener(valueEventListener)
    }

    override fun onInactive() {
        dbRef.removeEventListener(valueEventListener)
    }
    private val valueEventListener = object : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            Log.e("OnCanelled Firebase", p0.message)
        }

        override fun onDataChange(dataSnapshot: DataSnapshot) {
            if (dataSnapshot.exists()) {
                Log.i("Hello", "${dataSnapshot}")
                value = dataSnapshot.children.map{
                    snap -> snap.getValue(BulbsModel::class.java)!!
                }
                Log.i("!!!!", "${value}")
//
            }


        }
    }

}