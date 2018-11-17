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
    fun testSetTimeSecond() {
       assertEquals(5000 , MoreControl().setTimeSecond("5s."))
    }
    @Test
    fun testSetTimeMin(){
        assertEquals(60000 , MoreControl().setTimeMin("1m."))
    }
    @Test
    fun setTimeOnS() {
        assertEquals(1000 , MoreControl().setTimeOn("1s"))
    }
    @Test
    fun setTimeOnS2() {
        assertEquals(1000 , MoreControl().setTimeOn("1s."))
    }
    @Test
    fun setTimeOnM() {
        assertEquals(60000 , MoreControl().setTimeOn("1m"))

    }
    @Test
    fun setTimeOnM2() {
        assertEquals(60000 , MoreControl().setTimeOn("1m."))

    }
    @Test
    fun setTimeOnH() {
        assertEquals(3600000 , MoreControl().setTimeOn("1h"))

    }
    @Test
    fun setTimeOnH2() {
        assertEquals(3600000 , MoreControl().setTimeOn("1h."))

    }

}
