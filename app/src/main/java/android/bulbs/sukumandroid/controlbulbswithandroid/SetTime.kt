package android.bulbs.sukumandroid.controlbulbswithandroid


import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.logic.MoreControl
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.views.MainActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_set_time.*
import java.io.Serializable
import java.util.*


class SetTime : Fragment() {
    private lateinit var viewModel: RealTimeDbViewModel
    companion object {
        private const val ARG_NAME ="Name Bulb"
        private const val ARG_STATUS = "Status Bulb"
        private  const val ARG_KEY = "Key bulb"
        fun newInstance(bulb: BulbsModel): SetTime {
            val args = Bundle()
            args.putString(ARG_NAME , bulb.nameBulb)
            args.putInt(ARG_STATUS , bulb.statusBulb)
            args.putString(ARG_KEY , bulb.key)

            val fragment = SetTime()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_set_time, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
        val name : String? = arguments?.getString(ARG_NAME)
        val statusB : Int? = arguments?.getInt(ARG_STATUS)
        val key : String? = arguments?.getString(ARG_KEY)
        nameBulbToTimeC.text = name
        showTimeInput(statusB)
        setTimeOnFunc(key)
        setTimeOffFunc(key)

    }
    private fun setTimeOnFunc(key: String?) {
        setTimeOn?.setOnClickListener {
            editTextTimeOn?.let {
                val editText = editTextTimeOn.text.toString()
                val timeLong : Long = Date().time + MoreControl().setTimeOn(editText)
                key?.let {
                    viewModel.setTimeToBulb(key,"setOpen" , true , "timeStart" , timeLong).addOnSuccessListener {
                        Toast.makeText(context , "Success." , Toast.LENGTH_SHORT)
                    }
                }

            }
        }
    }
    private fun setTimeOffFunc(key: String?) {
        setTimeOff?.setOnClickListener {
            editTextTimeOff?.let {
                val editText =  editTextTimeOff.text.toString()
                val timeLong : Long = Date().time + MoreControl().setTimeOn(editText)
                key?.let {
                    viewModel.setTimeToBulb(key,"setClose" , true , "timeClose" , timeLong).addOnSuccessListener {
                        Toast.makeText(context , "Success." , Toast.LENGTH_SHORT)

                    }
                }
            }
        }
    }
    private fun showTimeInput(status : Int?) {
        status?.let {
            when (status) {
                0 -> {
                    linearF1.visibility = View.VISIBLE
                    linearF2.visibility = View.GONE
                }
                1 -> {
                    linearF1.visibility = View.GONE
                    linearF2.visibility = View.VISIBLE
                }
            }
        }

    }



}
