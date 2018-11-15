package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.logic

import java.util.*

class MoreControl   {
    fun setTimeOpen(date: Date): String {
        var dateSelect : Double = (date.time - Date().time).toDouble()
        if(dateSelect > 0) {
            dateSelect /= 1000
            dateSelect = Math.floor(dateSelect)
            var wan = Math.floor(dateSelect / 86400)
            var l_wan = dateSelect % 86400
            var hour = Math.floor(l_wan / 3600)
            var l_hour = l_wan % 3600
            var minute = Math.floor(l_hour / 60)
            var second = l_hour % 60
            var time_total = ""
            if (wan == 0.toDouble() && hour == 0.toDouble() && minute == 0.toDouble() && second == 0.toDouble()) {
                time_total = "เหลือเวลา $wan วัน $hour นาที $minute วินาที $second"

            }
            time_total = "เหลือเวลา $wan วัน $hour นาที $minute วินาที $second"
            return time_total
        } else {
            return "0 s."
        }

        return "0 s"
    }
    fun getTimeToTimeOut(date : Date) =   Date(Date().time + Date().time - date.time).time
    fun setTimeStart(date : Long) : String {
        var dateSelect = Date(Date().time + Date().time - Date(date).time).time - Date(Date(date).time).time
        if(dateSelect > 0) {
            dateSelect /= 1000
            var dateDouble : Double  = dateSelect.toDouble()
            dateDouble = Math.floor(dateDouble)
            var wan: Double = Math.floor(dateDouble / 86400)
            var l_wan : Double = dateDouble % 86400
            var hour: Double = Math.floor(l_wan / 3600)
            var l_hour:Double = l_wan % 3600
            var minute:Double = Math.floor(l_hour / 60)
            var second :Double = l_hour % 60
            var time_total: String? = ""
            if (wan == 0.toDouble() && hour == 0.toDouble() && minute == 0.toDouble() && second == 0.toDouble()) {
                time_total = "$wan วัน $hour:$minute:$second"

            }
            time_total = "$wan วัน $hour:$minute:$second"
            return time_total


        } else {
            return "0 s."
        }

        return "0 s"
    }



}