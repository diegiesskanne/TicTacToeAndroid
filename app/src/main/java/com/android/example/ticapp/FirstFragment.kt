package com.android.example.ticapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val a = getView()
        if (a != null) {
            setListeners(a)
        }else{
            println("FEEEEEEEEEEEHLER")
        }
        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

    }

    private fun setListeners(view: View) {

        val button1 = view.findViewById<ImageButton>(R.id.imageButton1)
        val button2 = view.findViewById<ImageButton>(R.id.imageButton2)
        val button3 = view.findViewById<ImageButton>(R.id.imageButton3)
        val button4 = view.findViewById<ImageButton>(R.id.imageButton4)
        val button5 = view.findViewById<ImageButton>(R.id.imageButton5)
        val button6 = view.findViewById<ImageButton>(R.id.imageButton6)
        val button7 = view.findViewById<ImageButton>(R.id.imageButton7)
        val button8 = view.findViewById<ImageButton>(R.id.imageButton8)
        val button9 = view.findViewById<ImageButton>(R.id.imageButton9)
        val clickableViews: List<View> = listOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for (item in clickableViews) {
            item.setOnClickListener { fillwithsymbol(it) }
        }

    }
    private fun fillwithsymbol(view: View){

        when(view.id) {
            R.id.imageButton1 -> view.imageButton1.setImageResource(R.drawable.cross)
            R.id.imageButton2 -> view.imageButton2.setImageResource(R.drawable.cross)
            R.id.imageButton3 -> view.imageButton3.setImageResource(R.drawable.cross)
            R.id.imageButton4 -> view.imageButton4.setImageResource(R.drawable.cross)
            R.id.imageButton5 -> view.imageButton5.setImageResource(R.drawable.cross)
            R.id.imageButton6 -> view.imageButton6.setImageResource(R.drawable.cross)
            R.id.imageButton7 -> view.imageButton7.setImageResource(R.drawable.cross)
            R.id.imageButton8 -> view.imageButton8.setImageResource(R.drawable.cross)
            R.id.imageButton9 -> view.imageButton9.setImageResource(R.drawable.cross)
        }
    }
}