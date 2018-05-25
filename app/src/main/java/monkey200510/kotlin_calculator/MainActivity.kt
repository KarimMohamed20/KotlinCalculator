package monkey200510.kotlin_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var isNewOp = true
    fun buNum(view:View){
        if(isNewOp){
            show_Math.text=""
        }
        isNewOp=false
        var text_show:String = show_Math.text.toString()
        val buSelect = view as Button

        when(buSelect.id){
            AC.id->{
                text_show=""
            }
            bu_1.id->{
                text_show+="1"
            }
            bu_2.id->{
                text_show+="2"
            }
            bu_3.id->{
                text_show+="3"
            }
            bu_4.id->{
                text_show+="4"
            }
            bu_5.id->{
                text_show+="5"
            }
            bu_6.id->{
                text_show+="6"
            }
            bu_7.id->{
                text_show+="7"
            }
            bu_8.id->{
                text_show+="8"
            }
            bu_9.id->{
                text_show+="9"
            }
            bu_0.id->{
                text_show+="0"
            }
            bu_negative.id->{
                text_show = "-" + text_show
            }
            bu_dot.id->{
                text_show+="."
            }
        }
        show_Math.text = text_show
    }
   var oldNumber = ""
    var op = "+"
    fun buOpNum(view: View){
        isNewOp=true
        oldNumber = show_Math.text.toString()
        val buSelect = view as Button
        when(buSelect.id){
            bu_Divide.id->{
              op = "/"
            }
            bu_plus.id->{
                op = "+"
            }
            bu_X.id->{
                op = "*"
            }
            bu_sub.id->{
                op = "-"
            }
            bu_noOne.id->{
                op = "%"
            }
        }


    }
    fun buNumEqual(view: View){
        val newNumber = show_Math.text.toString()
        var finalNumber:Double?=null
        when(op){
            "/"->{
               finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+"->{
               finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "*"->{
               finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-"->{
               finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "%"->{
                finalNumber = oldNumber.toDouble() % newNumber.toDouble()
            }
        }
        show_Math.text = finalNumber.toString()
        isNewOp=true
    }
    fun isClear(view: View){
        isNewOp=true
        show_Math.text="0"
    }
}
