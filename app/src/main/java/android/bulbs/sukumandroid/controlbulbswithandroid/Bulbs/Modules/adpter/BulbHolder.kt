package android.bulbs.sukumandroid.controlbulbswithandroid.Bulbs.Modules.adpter

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_bulbs_list.*


class BulbHolder( override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
    fun setNameBulb(bulbName : String) {
        textViewTitle?.text = bulbName
    }
    fun setStatusBulb(statusB : Int) {
        statusShow?.text = statusB.toString()
    }
    fun setSwitch(statusB: Int) {
        val statusS: Boolean = statusB != 0
        swichBulb?.isChecked = statusS
    }
    fun setOnSwitchListener(listener: View.OnClickListener) {
        swichBulb?.setOnClickListener(listener)
    }

}