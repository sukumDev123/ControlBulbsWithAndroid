package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.logic

import java.util.*

class MoreControl {

    fun getTimeToTimeOut(date: Date) = Date(Date().time + Date().time - date.time).time

    fun setTimeStart(date: Long): String {
        if (date > 0) {
            var dateSelect = Date().time - Date(Date(date).time).time
            if (dateSelect > 0) {
                dateSelect /= 1000
                var dateDouble: Double = dateSelect.toDouble()
                dateDouble = Math.floor(dateDouble)
                val wan: Double = Math.floor(dateDouble / 86400)
                val l_wan: Double = dateDouble % 86400
                val hour: Double = Math.floor(l_wan / 3600)
                val l_hour: Double = l_wan % 3600
                val minute: Double = Math.floor(l_hour / 60)
                val second: Double = l_hour % 60
                if (wan == 0.toDouble() && hour == 0.toDouble() && minute == 0.toDouble() && second == 0.toDouble()) {
                    return "${wan.toInt()} วัน ${hour.toInt()}:${minute.toInt()}:${second.toInt()}"
                }
                return "${wan.toInt()} วัน ${hour.toInt()}:${minute.toInt()}:${second.toInt()}"


            } else {
                return "0 s."
            }

        }
        return "0 s"
    }
    fun checkTypeTime(time: String): Boolean
            = Regex("[0-9]+[s,m,h][.]*").matches(time)

    fun setTimeSecond(time : String) : Long
            = (Regex("[s,m,h]+[.]*").split(time)[0].toInt() * 1000).toLong()

    fun setTimeMin(time: String) : Long
            = (Regex("[s,m,h]+[.]*").split(time)[0].toInt() * 60000).toLong()

    fun setTimeHour(time: String) : Long
            = (Regex("[s,m,h]+[.]*").split(time)[0].toInt() * 3600000).toLong()

    fun setTimeOn(time: String) : Long {
        if(checkTypeTime(time)) {
            val typeTime : String = Regex("[0-9]+").split(time)[1]
            return when (typeTime) {
                "h", "h." -> setTimeHour(time)
                "m", "m." -> setTimeMin(time)
                "s", "s." -> setTimeSecond(time)
                else -> 0
            }
        }
        return 0
    }

}