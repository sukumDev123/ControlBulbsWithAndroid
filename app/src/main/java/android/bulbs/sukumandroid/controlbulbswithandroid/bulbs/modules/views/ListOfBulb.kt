package android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.views


import android.bulbs.sukumandroid.controlbulbswithandroid.R
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter.BulbListAdpter
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_bulb.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ListOfBulb : Fragment() {
    private lateinit var viewModel: RealTimeDbViewModel
    private lateinit var adpter: BulbListAdpter
    private var bulbData: List<BulbsModel>? = listOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list_of_bulb, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        activity?.let {
            it.title = "Home Page"
        }
        adpter = BulbListAdpter()
        bulbRecyclerView?.layoutManager = GridLayoutManager(context, 2)
        bulbRecyclerView?.adapter = adpter
        getObserFromFireBase()
        adpter.setListener(updateStatusBulb)

    }

    override fun onStart() {
        super.onStart()
        updateBulbTime()

    }

    private val updateStatusBulb =
            object : BulbListAdpter.Listener {
                override fun onBulbClick(bulb: BulbsModel, view: View) {
                    val statusB = if (bulb.statusBulb == 0) 1 else 0
                    viewModel.updateStatusBulb(statusB, bulb.key)
                }
            }

    private fun getObserFromFireBase() {
        viewModel = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        viewModel.realTimeDBFireBase.observe(this, Observer<List<BulbsModel>> { bulbs ->
            bulbData = bulbs

            updateBulb(bulbs)
            showContent()
        })
    }

    private fun updateBulb(bulbs: List<BulbsModel>?) {
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

    private fun updateBulbTime() {
        val mHandler = Handler()
        val mTimer = Timer()
        mTimer.schedule(object : TimerTask() {
            override fun run() {
                bulbData?.let {
//                    adpter.setBulbList(it)
                    mHandler.post{
                        updateBulb(it)

                    }
                }
            }
        }, 0, 1000)
    }

}
