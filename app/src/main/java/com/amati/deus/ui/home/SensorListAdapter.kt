package com.amati.deus.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.amati.deus.R
import com.amati.deus.models.DeviceSensor

class SensorListAdapter : RecyclerView.Adapter<SensorListAdapter.SensorViewHolder>() {

    var sensorData = listOf<DeviceSensor>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

//    interface OnSensorSwitchChecked{
//        fun void onSensorSwitchChecked()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        return SensorViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        val currentSensor = sensorData[position]
        holder.bind(currentSensor)

    }

    override fun getItemCount(): Int {
        return sensorData.size
    }

    class SensorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sensorNameTextView: TextView = itemView.findViewById(R.id.sensorNameTextView)
        private val sensorIconImageView: ImageView = itemView.findViewById(R.id.deviceSensorImage)
        private val sensorSwitch: SwitchCompat = itemView.findViewById(R.id.sensorSwitch)

        fun bind(deviceSensor: DeviceSensor) {
            sensorNameTextView.text = deviceSensor.sensorName
            sensorIconImageView.setImageResource(
                when (deviceSensor.sensorName) {
                    else -> R.drawable.ic_action_sensor_placeholder
                }
            )
        }

        companion object {
            fun create(parent: ViewGroup): SensorViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyler_device_sensor_item, parent, false)
                return SensorViewHolder(view)
            }
        }
    }
}