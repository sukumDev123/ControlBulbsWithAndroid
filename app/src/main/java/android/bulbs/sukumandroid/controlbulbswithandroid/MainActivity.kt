package android.bulbs.sukumandroid.controlbulbswithandroid

<<<<<<< HEAD
=======
import android.annotation.SuppressLint
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.Views.CreateNewBulb
import android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.adpter.BulbListAdpter
>>>>>>> The card was selected success.
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import androidx.fragment.app.Fragment
=======
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
>>>>>>> The card was selected success.
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bulbs_list.*
import kotlinx.android.synthetic.main.activity_bulbs_list.view.*
import kotlinx.android.synthetic.main.activity_create_new_bulb.view.*

import kotlinx.android.synthetic.main.activity_main.*
<<<<<<< HEAD
import kotlinx.android.synthetic.main.fragment_list_of_bulb.*
=======
import java.text.FieldPosition
>>>>>>> The card was selected success.


class MainActivity : AppCompatActivity() {

    val mangerFrag = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
        createShowFrag(ListOfBulb())

=======
        showLoading()
        adpter = BulbListAdpter()
        bulbRecyclerView?.layoutManager = GridLayoutManager(this , 2)
        bulbRecyclerView?.adapter = adpter
        getObserFromFireBase()
        adpter?.setListener(updateStatusBulb)
>>>>>>> The card was selected success.


    }

<<<<<<< HEAD

=======
    private val updateStatusBulb =
        object : BulbListAdpter.Listener {
            override fun onBulbClick(bulb: BulbsModel, view: View) {
                val statusB = if(bulb.statusBulb == 0) 1 else 0
                viewModel?.updateStatusBulb(statusB, bulb.key)
            }
        }
>>>>>>> The card was selected success.



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
<<<<<<< HEAD
=======
    private fun getObserFromFireBase() {
        viewModel = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        viewModel.realTimeDBFireBase.observe(this , Observer<List<BulbsModel>> {
            bulbs ->
            updateBulb(bulbs )
            showContent()
        })
    }
    private fun updateBulb(bulbs : List<BulbsModel>?) {
        bulbs?.let {
            adpter.setBulbList(bulbs)
            adpter.notifyDataSetChanged()
        }
>>>>>>> The card was selected success.

    private fun createShowFrag(block: Fragment ) {
        val transaction = mangerFrag?.beginTransaction()
        transaction?.replace(R.id.frameLayout_bulb  , block)?.addToBackStack(null)?.commit()

    }


}
