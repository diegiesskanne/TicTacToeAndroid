package com.android.example.ticapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.playground.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class FirstFragment : Fragment() {

    var scorep1: Int = 0
    var scorep2: Int = 0
    var namef: String = ""
    var names: String = ""
    var player1: Player = Player(namef, R.drawable.cross)
    var player2: Player = Player(names, R.drawable.circle)
    var player1inputs: MutableList<Int> = mutableListOf()
    var player2inputs: MutableList<Int> = mutableListOf()
    private val winlists: List<List<Int>> = listOf(listOf(R.id.imageButton1, R.id.imageButton2, R.id.imageButton3), listOf(R.id.imageButton4, R.id.imageButton5, R.id.imageButton6), listOf(R.id.imageButton7, R.id.imageButton8, R.id.imageButton9), listOf(R.id.imageButton1, R.id.imageButton4, R.id.imageButton7), listOf(R.id.imageButton2, R.id.imageButton5, R.id.imageButton8), listOf(R.id.imageButton3, R.id.imageButton6, R.id.imageButton9), listOf(R.id.imageButton1, R.id.imageButton5, R.id.imageButton9), listOf(R.id.imageButton3, R.id.imageButton5, R.id.imageButton7))
    private var currentplayer: Player = player1
    private var scor1: TextView? = null
    private var scor2: TextView? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scor1 = view.findViewById(R.id.score_player1)
        scor2 = view.findViewById(R.id.score_player2)
        val a = getView()
        if (a != null) {
            setListeners(a)
            restart(a)
        }else{
            println("FEEEEEEEEEEEHLER")
        }
        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

    }

    private fun restart(view: View){
        val reset = view.findViewById<Button>(R.id.restart_button)
        reset.setOnClickListener{newgame(view)}
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
            R.id.imageButton1 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton1.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton1)
                    currentplayer = player2
                }else{
                    imageButton1.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton1)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton2 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton2.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton2)
                    currentplayer = player2
                }else{
                    imageButton2.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton2)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton3 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton3.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton3)
                    currentplayer = player2
                }else{
                    imageButton3.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton3)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton4 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton4.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton4)
                    currentplayer = player2
                }else{
                    imageButton4.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton4)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton5 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton5.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton5)
                    currentplayer = player2
                }else{
                    imageButton5.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton5)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton6 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton6.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton6)
                    currentplayer = player2
                }else{
                    imageButton6.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton6)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton7 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton7.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton7)
                    currentplayer = player2
                }else{
                    imageButton7.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton7)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton8 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton8.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton8)
                    currentplayer = player2
                }else{
                    imageButton8.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton8)
                    currentplayer = player1
                }
                check_win(view)
            }
            R.id.imageButton9 -> {

                if(currentplayer.symbol == player1.symbol){
                    imageButton9.setImageResource(R.drawable.cross)
                    player1inputs.add(R.id.imageButton9)
                    currentplayer = player2
                }else{
                    imageButton9.setImageResource(R.drawable.circle)
                    player2inputs.add(R.id.imageButton9)
                    currentplayer = player1
                }
                check_win(view)
            }
        }
    }


    fun check_win(view: View): Int{


        for(winlist in winlists) {
            if (player1inputs.containsAll(winlist)){
                scorep1 += 1
                scor1?.text = scorep1.toString()
                println("BBBBBBBBBBBBBBBBBBBBBBBBBBb")
                newgame(view)
                return 1
            }
        }
        for(winlist in winlists) {
            if (player2inputs.containsAll(winlist)){
                scorep2 += 1
                println("AAAAAAAAAAAAAAAAAAAAAAA")
                scor2?.text = scorep2.toString()
                newgame(view)
                return 2
            }
        }
        if(player1inputs.size == 5 && player2inputs.size == 4){
            newgame(view)
            return 0
        }else{
            return -1
        }
    }


    fun newgame(view: View){
        player1inputs.clear()
        player2inputs.clear()
        currentplayer = player1
        imageButton1.setImageResource(R.drawable.ic_launcher_background)
        imageButton2.setImageResource(R.drawable.ic_launcher_background)
        imageButton3.setImageResource(R.drawable.ic_launcher_background)
        imageButton4.setImageResource(R.drawable.ic_launcher_background)
        imageButton5.setImageResource(R.drawable.ic_launcher_background)
        imageButton6.setImageResource(R.drawable.ic_launcher_background)
        imageButton7.setImageResource(R.drawable.ic_launcher_background)
        imageButton8.setImageResource(R.drawable.ic_launcher_background)
        imageButton9.setImageResource(R.drawable.ic_launcher_background)
        //setListeners(view)
    }

}