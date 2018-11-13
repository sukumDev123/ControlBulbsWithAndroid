package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.liveData

import androidx.lifecycle.LiveData
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel


class BulbLiveData(val tbName : String , val statusBulbs: Boolean ) : LiveData<List<BulbsModel>>() {

}