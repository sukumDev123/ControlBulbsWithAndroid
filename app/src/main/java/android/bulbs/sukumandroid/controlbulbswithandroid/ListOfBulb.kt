package android.bulbs.sukumandroid.controlbulbswithandroid


import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.adpter.BulbListAdpter
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_bulb.*




/**
 * A simple [Fragment] subclass.
 *
 */
class ListOfBulb : Fragment() {
    private lateinit var viewModel : RealTimeDbViewModel
    private lateinit var adpter: BulbListAdpter




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_bulb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adpter = BulbListAdpter()
        bulbRecyclerView?.layoutManager = GridLayoutManager(context , 2)
        bulbRecyclerView?.adapter = adpter
        getObserFromFireBase()
        adpter.setListener(updateStatusBulb)

    }
    private val updateStatusBulb =
            object : BulbListAdpter.Listener {
                override fun onBulbClick(bulb: BulbsModel, view: View) {
                    val statusB = if(bulb.statusBulb == 0) 1 else 0
                    viewModel.updateStatusBulb(statusB, bulb.key)
                }
            }

    private fun getObserFromFireBase() {
        viewModel = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        viewModel.realTimeDBFireBase.observe(this , Observer<List<BulbsModel>> {
            bulbs ->
            updateBulb(bulbs)
//            showContent()
        })
    }
    private fun updateBulb(bulbs : List<BulbsModel>?) {
        bulbs?.let {
            adpter.setBulbList(bulbs)
            adpter.notifyDataSetChanged()
        }

    }
//    private fun showLoading() {
//        bulbRecyclerView?.visibility = View.GONE
//        progressBar?.visibility = View.VISIBLE
//    }
//
//    private fun showContent() {
//        bulbRecyclerView?.visibility = View.VISIBLE
//        progressBar?.visibility = View.GONE
//    }


}
