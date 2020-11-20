package com.example.ejercicioclasejetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_calculadora.*


class calculadoraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculadora, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_calcularNumeros.setOnClickListener {


            if(radioButton.isChecked){
               val directions=calculadoraFragmentDirections.actionCalculadoraFragmentToSumarFragment(
                   n1=tx_n1.text.toString().toInt(),n2 = tx_n2.text.toString().toInt()
               )
                Navigation.findNavController(it).navigate(directions)


            }
            if(radioButton2.isChecked){
                val directions=calculadoraFragmentDirections.actionCalculadoraFragmentToRestarFragment(
                    n1=tx_n1.text.toString().toInt(),n2 = tx_n2.text.toString().toInt()
                )
                Navigation.findNavController(it).navigate(directions)

            }
            if(radioButton3.isChecked){
                val directions=calculadoraFragmentDirections.actionCalculadoraFragmentToDividirFragment(
                    n1=tx_n1.text.toString().toInt(),n2 = tx_n2.text.toString().toInt()
                )
                Navigation.findNavController(it).navigate(directions)

            }

        }

    }


}