package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models


data class BulbsModel(var nameBulb: String = "" , var statusBulb : Int = 0 , var pinMode: String = "" , var key : String = "" , var createAt : Long = 0 , val setClose : Boolean = false , val setOpen : Boolean = false , val timeStart : Long = 0 , val timeClose: Long = 0)


