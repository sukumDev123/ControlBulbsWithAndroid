package android.bulbs.sukumandroid.controlbulbswithandroid

import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.views.CreateNewBulb
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter.BulbListAdpter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : RealTimeDbViewModel
    private lateinit var adpter: BulbListAdpter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLoading()
        adpter = BulbListAdpter()
        bulbRecyclerView?.layoutManager = GridLayoutManager(this , 2)
        bulbRecyclerView?.adapter = adpter
        getObserFromFireBase()
        adpter?.setListener(updateStatusBulb)


    }

    private val updateStatusBulb =
        object : BulbListAdpter.Listener {
            override fun onBulbClick(bulb: BulbsModel, view: View) {
                val statusB = if(bulb.statusBulb == 0) 1 else 0
                viewModel?.updateStatusBulb(statusB, bulb.key)
            }
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
                    val intent = Intent(this , MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_recent2 -> {
                    val intent2 = Intent(this , CreateNewBulb::class.java)
                    startActivity(intent2)
                    true
                }

                else -> false
            }


        }

    }
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
