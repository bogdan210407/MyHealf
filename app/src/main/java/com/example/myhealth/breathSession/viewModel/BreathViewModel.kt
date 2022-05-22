package com.example.myhealth.breathSession.viewModel

import android.os.CountDownTimer
import com.example.myhealth.breathSession.SessionParameters
import com.example.myhealth.breathSession.view.BreathFragment

class BreathViewModel {
    val parameters = SessionParameters(
        10,
        2,
        1,
        1
    )
    val currentParameters = parameters.copy()

    var listener: BreathFragment? = null
    var timer: CountDownTimer? = null

    fun startSession(){
        timer = object : CountDownTimer(
            parameters.sessionLength * 1000L,
            1000L
        ){
            override fun onTick(p0: Long) {
                updateSession()
                listener?.onChange(currentParameters)
            }

            override fun onFinish() {

            }
        }
    }
    fun updateSession(){
        currentParameters.sessionLength -= 1
        if (currentParameters.inhale > 0) {
            currentParameters.inhale -= 1
        } else if (currentParameters.sessionDelay1 > 0){
            currentParameters.sessionDelay1 -= 1
        } else if (currentParameters.sessionDelay1 > 0){
            currentParameters.exhale -= 1
        } else if (currentParameters.sessionDelay2 > 0){
            currentParameters.sessionDelay2 -= 1
        }
        if (currentParameters.sessionDelay2 == 0){
            currentParameters.inhale = parameters.inhale
            currentParameters.sessionDelay1 = parameters.sessionDelay1
            currentParameters.exhale = parameters.exhale
            currentParameters.sessionDelay2 = parameters.sessionDelay2

        }

    }
}