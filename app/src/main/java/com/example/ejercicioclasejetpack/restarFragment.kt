package com.example.ejercicioclasejetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_restar.*
import kotlinx.android.synthetic.main.fragment_sumar.*


class restarFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restar, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var n1=restarFragmentArgs.fromBundle(it).n1
            var n2=restarFragmentArgs.fromBundle(it).n2
            var resultado=n1-n2
            tx_resultadoResta.text="El resultado de la resta es: "+resultado.toString()
        }
    }


}