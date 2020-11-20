package com.example.ejercicioclasejetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sumar.*


class sumarFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sumar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var n1=sumarFragmentArgs.fromBundle(it).n1
            var n2=sumarFragmentArgs.fromBundle(it).n2
            var resultado=n1+n2
            tx_resultadoSuma.text="El resultado de la suma es: "+resultado.toString()
        }
    }


}