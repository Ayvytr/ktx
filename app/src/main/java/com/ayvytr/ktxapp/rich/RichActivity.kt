package com.ayvytr.ktxapp.rich

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.ui.getContext
import com.ayvytr.ktx.ui.onClick
import com.ayvytr.ktx.ui.spanner.Range
import com.ayvytr.ktx.ui.spanner.Spanner.Companion.from
import com.ayvytr.ktxapp.R
import com.ayvytr.logger.L

class RichActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rich)
        val textView = findViewById<View>(R.id.textView) as TextView
        val text = "This is a simple #foo @bar text \n SimpleText"
        val url = "https://github.com/jaychang0917/SimpleText"
        val foo = User("1001", "foo")
        val bar = User("1002", "bar")
        L.e(textView)
        val simpleText = from(text)
            .allStartWith("#", "@")
            .tags(foo, bar)
            .textColorRes(
                R.color.link,
                R.color.red
            ) //                                    .pressedBackgroundRes(R.color.pressedBg, 2)
            .onClick(textView) { text: CharSequence, range: Range ->
                Toast.makeText(
                    this@RichActivity, text,
                    Toast.LENGTH_SHORT
                ).show()
            }
            .first("simple").textColorRes(R.color.colorAccent)
            .first("SimpleText").bold().textColorRes(R.color.link)
//            .url(url)
//            .onLongClick(textView, object: OnTextLongClickListener {
//                override fun onLongClicked(
//                    text: CharSequence,
//                    range: Range, tag: Any?
//                ) {
//                    L.e(tag)
//                    Toast.makeText(
//                        this@RichActivity,
//                        "[long click] to share " + tag.toString(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            })
        textView.text = simpleText
        findViewById<View>(R.id.textView).setOnClickListener {
            Toast.makeText(
                this@RichActivity,
                "textview",
                Toast.LENGTH_SHORT
            ).show()
        }
        val tv2 = findViewById<TextView>(R.id.tv2)
        val st2 = from("测试文本2，测试颜色和点击链接")
            .all("测试", "点击", "，", "颜色", "测试颜色")
            .textColor(Color.BLUE)
            .onClick(tv2) { text, _ ->
                L.e(text)
                Toast.makeText(
                    this@RichActivity, text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        tv2.text = st2
        val tv3 = findViewById<TextView>(R.id.tv3)
        val spanner3 = from(
            "我们每天都在思考今天的作业做完了吗?书看完了吗?有没有那样一种感觉，有时候猛然发现，书读得" +
                    "越多心越来越冷。因为见惯了书中的风云突变，听惯了动辄上百万军队的滔天战鼓，因为习惯了去看那" +
                    "些牵绊拉扯住我们的丝线。我们渐渐地变得对生活中的美好事物失去了发现美的眼睛，所以连阿姨那样" +
                    "平常而美好的笑容很多时候都是视而不见。"
        )
            .all("我们")
            .textColor(Color.BLUE)
            .backgroundColorRes(R.color.colorAccent, R.color.colorPrimary)
            .onClick(tv3) { text: CharSequence, range: Range ->
                Log.e("tag", "$text ")
                //toast text不显示，加.toString()才显示
                Toast.makeText(
                    this@RichActivity, text,
                    Toast.LENGTH_SHORT
                ).show()
            }
            .all("因为")
            .bold()
            .italic()
            .all()
            .underline()
            .size(20)
        //                         .boldItalic();
        tv3.text = spanner3
        val tv4 = findViewById<TextView>(R.id.tv4)
        val spanner4 = from("测试点击颜色，不同颜色测试xxxxxxxx xxxxxxxxxxxxxxxxxxx")
            .all("点击颜色")
            .textColor(Color.BLUE, Color.RED)
            .onClick(tv4) { text: CharSequence, range: Range ->
                Toast.makeText(this@RichActivity, text, Toast.LENGTH_SHORT).show()
            }
            .all("不同颜色测试xxxxxxxx xxxxxxxxxxxxxxxxxxx")
            .textColor(Color.YELLOW, Color.GREEN)
            .backgroundColor(Color.GREEN, Color.YELLOW)
            .onClick(tv4) { text: CharSequence, range: Range ->
                Toast.makeText(this@RichActivity, text, Toast.LENGTH_SHORT).show()
            }
        tv4.text = spanner4
        tv4.onClick {
            Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show()
        }
    }
}