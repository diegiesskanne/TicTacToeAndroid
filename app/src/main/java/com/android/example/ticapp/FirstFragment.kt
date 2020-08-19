package com.android.example.ticapp

import android.app.Notification
import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
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
    var name1: EditText? = null
    var name2: EditText? = null
    private val winlists: List<List<Int>> = listOf(
        listOf(
            R.id.imageButton1,
            R.id.imageButton2,
            R.id.imageButton3
        ), listOf(R.id.imageButton4, R.id.imageButton5, R.id.imageButton6), listOf(
            R.id.imageButton7,
            R.id.imageButton8,
            R.id.imageButton9
        ), listOf(R.id.imageButton1, R.id.imageButton4, R.id.imageButton7), listOf(
            R.id.imageButton2,
            R.id.imageButton5,
            R.id.imageButton8
        ), listOf(R.id.imageButton3, R.id.imageButton6, R.id.imageButton9), listOf(
            R.id.imageButton1,
            R.id.imageButton5,
            R.id.imageButton9
        ), listOf(R.id.imageButton3, R.id.imageButton5, R.id.imageButton7)
    )
    private var currentplayer: Player = player1
    private var scor1: TextView? = null
    private var scor2: TextView? = null
    private var about: Button? = null

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
        name1 = view.findViewById<EditText>(R.id.name_player1)
        name2 = view.findViewById<EditText>(R.id.name_player2)
        about = view.findViewById<Button>(R.id.about_but)

        val displaym = context?.resources?.displayMetrics!!
        //Fragment.findNavController()
        val lo = about?.layoutParams as ConstraintLayout.LayoutParams
        val top = displaym.heightPixels / 2
        lo.setMargins(0, top, 5,0)
        about?.layoutParams = lo

        //println("GURGURGUR " + about?.marginTop + " " + about?.marginBottom + " " + about?.marginEnd + " " + about?.marginStart)
        about?.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, null)
        }
        val a = getView()


        name1?.layoutParams?.width = (displaym.widthPixels / 9) * 3
        name2?.layoutParams?.width = (displaym.widthPixels / 9) * 3

        val inputManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        inputManager.hideSoftInputFromWindow(
            view.windowToken, 0)

        if (a != null) {
            setListeners(a, displaym)
            restart(a)
        }else{
            println("FEEEEEEEEEEEHLER")
        }
        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

    }

    private fun reset(){
        scorep1 = 0
        scorep2 = 0
        scor1?.text = scorep1.toString()
        scor2?.text = scorep2.toString()

    }

    private fun restart(view: View){
        val reset = view.findViewById<Button>(R.id.restart_button)
        reset.setOnClickListener{newGame(view)}
    }

    private fun setListeners(view: View, met: DisplayMetrics) {

        //var a = widthh
        //var b = heightt
        val button1 = view.findViewById<ImageButton>(R.id.imageButton1)
        val button2 = view.findViewById<ImageButton>(R.id.imageButton2)
        val button3 = view.findViewById<ImageButton>(R.id.imageButton3)
        val button4 = view.findViewById<ImageButton>(R.id.imageButton4)
        val button5 = view.findViewById<ImageButton>(R.id.imageButton5)
        val button6 = view.findViewById<ImageButton>(R.id.imageButton6)
        val button7 = view.findViewById<ImageButton>(R.id.imageButton7)
        val button8 = view.findViewById<ImageButton>(R.id.imageButton8)
        val button9 = view.findViewById<ImageButton>(R.id.imageButton9)
        val clickableViews: List<View> = listOf(
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9
        )

        for (item in clickableViews) {
            item.layoutParams.height = met.widthPixels / 5
            item.layoutParams.width = met.widthPixels / 5
            item.setOnClickListener { fillWithSymbol(it) }
        }

    }
    private fun fillWithSymbol(view: View){

        val toasttext = "No valid input!"
        val toastduration = Toast.LENGTH_SHORT
        val nvitoast = Toast.makeText(context, toasttext, toastduration)
        nvitoast.setGravity(Gravity.BOTTOM, 0, 0)

        when(view.id) {
            R.id.imageButton1 -> {
                if (player1inputs.contains(R.id.imageButton1) || player2inputs.contains(R.id.imageButton1)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton1, R.id.imageButton1)

                    } else {
                        player2turn(imageButton1, R.id.imageButton1)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton2 -> {
                if (player1inputs.contains(R.id.imageButton2) || player2inputs.contains(R.id.imageButton2)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton2, R.id.imageButton2)
                    } else {
                        player2turn(imageButton2, R.id.imageButton2)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton3 -> {
                if (player1inputs.contains(R.id.imageButton3) || player2inputs.contains(R.id.imageButton3)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton3, R.id.imageButton3)
                    } else {
                        player2turn(imageButton3, R.id.imageButton3)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton4 -> {
                if (player1inputs.contains(R.id.imageButton4) || player2inputs.contains(R.id.imageButton4)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton4, R.id.imageButton4)
                    } else {
                        player2turn(imageButton4, R.id.imageButton4)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton5 -> {
                if (player1inputs.contains(R.id.imageButton5) || player2inputs.contains(R.id.imageButton5)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton5, R.id.imageButton5)
                    } else {
                        player2turn(imageButton5, R.id.imageButton5)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton6 -> {
                if (player1inputs.contains(R.id.imageButton6) || player2inputs.contains(R.id.imageButton6)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton6, R.id.imageButton6)
                    } else {
                        player2turn(imageButton6, R.id.imageButton6)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton7 -> {
                if (player1inputs.contains(R.id.imageButton7) || player2inputs.contains(R.id.imageButton7)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton7, R.id.imageButton7)
                    } else {
                        player2turn(imageButton7, R.id.imageButton7)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton8 -> {
                if (player1inputs.contains(R.id.imageButton8) || player2inputs.contains(R.id.imageButton8)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton8, R.id.imageButton8)
                    } else {
                        player2turn(imageButton8, R.id.imageButton8)
                    }
                }
                checkWin(view)
            }
            R.id.imageButton9 -> {
                if (player1inputs.contains(R.id.imageButton9) || player2inputs.contains(R.id.imageButton9)) {
                    nvitoast.show()
                } else {
                    if (currentplayer.symbol == player1.symbol) {
                        player1turn(imageButton9, R.id.imageButton9)
                    } else {
                        player2turn(imageButton9, R.id.imageButton9)
                    }
                }
                checkWin(view)
            }
        }
    }


    private fun checkWin(view: View): Int{


        for(winlist in winlists) {
            if (player1inputs.containsAll(winlist)){
                scorep1 += 1
                scor1?.text = scorep1.toString()
                newGame(view)
                return 1
            }
        }
        for(winlist in winlists) {
            if (player2inputs.containsAll(winlist)){
                scorep2 += 1
                scor2?.text = scorep2.toString()
                newGame(view)
                return 2
            }
        }
        if(player1inputs.size == 5 && player2inputs.size == 4){
            newGame(view)
            return 0
        }else{
            return -1
        }
    }



    private fun newGame(view: View){
        player1inputs.clear()
        player2inputs.clear()
        currentplayer = player1
        name1?.setTextColor(Color.BLUE)
        name2?.setTextColor(Color.BLACK)
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

    private fun player1turn(but: ImageButton, id: Int){
        but.setImageResource(R.drawable.cross)
        player1inputs.add(id)
        currentplayer = player2
        name2?.setTextColor(Color.RED)
        name1?.setTextColor(Color.BLACK)
    }

    private fun player2turn(but: ImageButton, id: Int){
        but.setImageResource(R.drawable.circle)
        player2inputs.add(id)
        currentplayer = player1
        name1?.setTextColor(Color.BLUE)
        name2?.setTextColor(Color.BLACK)
    }

}