package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.views

import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val mangerFrag = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createShowFrag(ListOfBulb())



    }

    override fun onStart() {
        super.onStart()
        navBottom()
    }
    private fun navBottom() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.item_recent -> {
                    createShowFrag(ListOfBulb())
                    true
                }
                R.id.item_recent2 -> {
                    createShowFrag(CreateNewBulb())
                    true
                }
                R.id.item_recent3 -> {
                    createShowFrag(MoreOption())
                    true
                }

                else -> false
            }


        }

    }

    private fun createShowFrag(block: Fragment ) {
        val transaction = mangerFrag?.beginTransaction()
        transaction?.replace(R.id.frameLayout_bulb, block)?.addToBackStack(null)?.commit()

    }


}
