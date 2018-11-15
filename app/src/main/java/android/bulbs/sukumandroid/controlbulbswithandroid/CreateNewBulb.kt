package android.bulbs.sukumandroid.controlbulbswithandroid

import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.firebase.RealTimeDbViewModel
import android.bulbs.sukumandroid.controlbulbswithandroid.bulbs.modules.models.BulbsModel
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_create_new_bulb.*


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
        buttonSave.setOnClickListener {
            val nameB : EditText? = getView()?.findViewById(R.id.nameChild)
            val pinMode : EditText? = getView()?.findViewById(R.id.pinMode)
            var newChild : EditText? = getView()?.findViewById(R.id.nameChild)
            val bulbModel = BulbsModel(nameB?.text.toString() , 0 , pinMode?.text.toString() , nameChild?.text.toString())
            viewModelFireBase.addNewBulb(bulbModel , newChild?.text.toString()).apply {
                this.addOnSuccessListener {
                    Toast.makeText(context ,"The Bulb is created success.", Toast.LENGTH_LONG ).show()
                }
            }
        }

    }
}