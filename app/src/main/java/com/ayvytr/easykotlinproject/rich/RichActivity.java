package com.ayvytr.easykotlinproject.rich;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ayvytr.easykotlinproject.R;
import com.ayvytr.ktx.ui.spanner.OnTextClickListener;
import com.ayvytr.ktx.ui.spanner.OnTextLongClickListener;
import com.ayvytr.ktx.ui.spanner.Range;
import com.ayvytr.ktx.ui.spanner.Spanner;
import com.ayvytr.logger.L;

import androidx.appcompat.app.AppCompatActivity;


public class RichActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich);

        TextView textView = (TextView) findViewById(R.id.textView);

        String text = "This is a simple #foo @bar text \n SimpleText";
        String url = "https://github.com/jaychang0917/SimpleText";

        User foo = new User("1001", "foo");
        User bar = new User("1002", "bar");

        L.e(textView);

        Spanner simpleText = Spanner.from(text)
                                    .allStartWith("#", "@")
                                    .tags(foo, bar)
                                    .textColorRes(R.color.link, R.color.pressedText)
                                    .pressedBackgroundRes(R.color.pressedBg, 2)
                                    .onClick(textView, new OnTextClickListener() {
                                        @Override
                                        public void onClicked(CharSequence text, Range range,
                                                              Object tag) {
                                            L.e(tag);
                                            Toast.makeText(RichActivity.this, tag.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    })

                                    .first("simple").textColorRes(R.color.colorAccent)

                                    .first("SimpleText").bold().textColorRes(R.color.link)
                                    .url(url)
                                    .onLongClick(textView, new OnTextLongClickListener() {
                                        @Override
                                        public void onLongClicked(CharSequence text,
                                                                  Range range, Object tag) {
                                            L.e(tag);
                                            Toast.makeText(RichActivity.this,
                                                    "[long click] to share " + tag.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    });

        textView.setText(simpleText);

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RichActivity.this, "textview", Toast.LENGTH_SHORT).show();
            }
        });

        TextView tv2 = findViewById(R.id.tv2);
        Spanner st2 = Spanner.from("测试文本2，测试颜色和点击链接")
                             .all("测试", "点击", "，", "颜色", "测试颜色")
                             .textColor(Color.BLUE)
                             .onClick(tv2, new OnTextClickListener() {
                                 @Override
                                 public void onClicked(CharSequence text, Range range,
                                                       Object tag) {
                                     L.e(text);
                                     Toast.makeText(RichActivity.this, text,
                                             Toast.LENGTH_SHORT).show();
                                 }
                             });
        tv2.setText(st2);

        TextView tv3 = findViewById(R.id.tv3);
        Spanner spanner3 = Spanner.from("我们每天都在思考今天的作业做完了吗?书看完了吗?有没有那样一种感觉，有时候猛然发现，书读得" +
                "越多心越来越冷。因为见惯了书中的风云突变，听惯了动辄上百万军队的滔天战鼓，因为习惯了去看那" +
                "些牵绊拉扯住我们的丝线。我们渐渐地变得对生活中的美好事物失去了发现美的眼睛，所以连阿姨那样" +
                "平常而美好的笑容很多时候都是视而不见。")
                                  .all("我们")
                                  .textColor(Color.BLUE)
                                  .backgroundColorRes(R.color.colorAccent, R.color.colorPrimary)
                                  .onClick(tv3, new OnTextClickListener() {
                                      @Override
                                      public void onClicked(CharSequence text, Range range,
                                                            Object tag) {
                                          Log.e("tag", text.toString() + " " + tag);
                                          //toast text不显示，加.toString()才显示
                                          Toast.makeText(RichActivity.this, text.toString(),
                                                  Toast.LENGTH_SHORT).show();
                                      }
                                  })
                                  .all("因为")
                                  .bold()
                                  .italic()
                                  .all()
                                  .underline()
                                  .size(20);
//                         .boldItalic();
        tv3.setText(spanner3);
    }

}
