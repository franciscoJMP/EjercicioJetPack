package com.example.ejercicioclasejetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dividir.*
import kotlinx.android.synthetic.main.fragment_sumar.*

class dividirFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dividir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var n1=dividirFragmentArgs.fromBundle(it).n1
            var n2=dividirFragmentArgs.fromBundle(it).n2
            if(n2!=0){
                var resultado=n1/n2
                tx_resultadoDivision.text="El resultado de la suma es: "+resultado.toString()
            } else{
                tx_resultadoDivision.text="No se puede dividir entre 0"
            }


        }
    }



}