package android.bulbs.sukumandroid.controlbulbswithandroid

import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CreateNewBulb.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CreateNewBulb.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CreateNewBulb : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModelFireBase : RealTimeDbViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_new_bulb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFireBase = ViewModelProviders.of(this).get(RealTimeDbViewModel::class.java)
//        buttonSave.setOnClickListener {
//            val nameB : TextInputEditText = findViewById(R.id.nameBulb)
//            val pinMode : TextInputEditText = findViewById(R.id.pinMode)
//            var newChild : TextInputEditText = findViewById(R.id.nameChild)
//            val bulbModel = BulbsModel(nameB.text.toString() , 0 , pinMode.text.toString() , nameChild.text.toString())
//            viewModelFireBase.addNewBulb(bulbModel , newChild.text.toString(), this)
//        }

    }
}