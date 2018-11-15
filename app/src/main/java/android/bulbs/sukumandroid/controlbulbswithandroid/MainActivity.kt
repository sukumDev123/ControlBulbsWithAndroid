package android.bulbs.sukumandroid.controlbulbswithandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_of_bulb.*


class MainActivity : AppCompatActivity() {

    val mangerFrag = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        showLoading()
        progressBar?.visibility = View.GONE



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

                else -> false
            }


        }

    }

    private fun createShowFrag(block: Fragment ) {
        val transaction = mangerFrag?.beginTransaction()
        transaction?.replace(R.id.frameLayout_bulb  , block)?.addToBackStack(null)?.commit()

    }
    private fun showLoading() {
        bulbRecyclerView?.visibility = View.GONE
        progressBar?.visibility = View.VISIBLE
    }

    private fun showContent() {
        bulbRecyclerView?.visibility = View.VISIBLE
        progressBar?.visibility = View.GONE
    }

}
