package android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.LiveData

import androidx.lifecycle.LiveData
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel


class BulbLiveData(val tbName : String , val statusBulbs: Boolean ) : LiveData<List<BulbsModel>>() {

}