package com.example.ejercicioclasejetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_web_view.*


class menuFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                System.exit(0)

            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_navegador.setOnClickListener {
            val directions=menuFragmentDirections.actionMenuFragmentToWebViewFragment()
            Navigation.findNavController(it).navigate(directions)
        }
        bt_camara.setOnClickListener {
            val directions=menuFragmentDirections.actionMenuFragmentToCamaraFragment()
            Navigation.findNavController(it).navigate(directions)
        }
        bt_calcular.setOnClickListener{
            val directions=menuFragmentDirections.actionMenuFragmentToCalculadoraFragment()
            Navigation.findNavController(it).navigate(directions)
        }

    }





}