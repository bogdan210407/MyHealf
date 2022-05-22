package com.example.myhealth.breathSession.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myhealth.R
import com.example.myhealth.breathSession.SessionParameters
import com.example.myhealth.breathSession.viewModel.BreathViewModel

class BreathFragment: Fragment()
{
    private val viewModel: BreathViewModel = BreathViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_breath_session,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inhaleValue = view.findViewById<TextView>(R.id.second1)
        val exhaleValue = view.findViewById<TextView>(R.id.second3)
        val sessionLengthValue = view.findViewById<TextView>(R.id.second2)
        val sessionDelayValue = view.findViewById<TextView>(R.id.second4)

        inhaleValue.text = viewModel.parameters.inhale.toString()
        exhaleValue.text = viewModel.parameters.exhale.toString()
        sessionLengthValue.text = viewModel.parameters.sessionLength.toString()
        sessionDelayValue.text = viewModel.parameters.sessionDelay1.toString()

        viewModel.startSession()
        val startButton = view.findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            println("Hello!")
        }
    }
    fun onChange(newValues: SessionParameters){
        val inhaleValue = view?.findViewById<TextView>(R.id.second1)
        val exhaleValue = view?.findViewById<TextView>(R.id.second3)
        val sessionLengthValue = view?.findViewById<TextView>(R.id.second2)
        val sessionDelayValue = view?.findViewById<TextView>(R.id.second4)

        inhaleValue?.text = newValues.inhale.toString()
        exhaleValue?.text = newValues.exhale.toString()
        sessionLengthValue?.text = newValues.sessionLength.toString()
        sessionDelayValue?.text = newValues.sessionDelay1.toString()
    }
}