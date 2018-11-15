package android.bulbs.sukumandroid.controlbulbswithandroid

import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.logic.MoreControl
import android.os.CountDownTimer
import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun testShowDataNow(){
        assertEquals(
                123,
                123
        )

    }
    @Test
    fun testTimeOfDateString() {
        val date_Time = Date(1542273708589)
        val changeTest = MoreControl().setTimeOpen(date_Time)
        assertEquals("0 s." , changeTest)
    }
    @Test
    fun testTimePlusTest() {
        val date_Time = Date(1542272212888)
        val testTimeValue = MoreControl().setTimeStart(date_Time)
        assertEquals("0 s." , testTimeValue)

    }
    @Test
    fun testTime() {
        val dateTime = MoreControl().getTimeToTimeOut(Date(1542272212888))
        assertEquals("1" , dateTime)
    }


}
