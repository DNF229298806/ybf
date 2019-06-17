package com.example.ybframe.testclass;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ybframe.R;

/**
 * @author 20888
 * @date 2019/5/31 17:11
 */
public class AAAA extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    private Handler mHandler = new Handler();

    String html = "<html><head><title>TextView使用HTML</title></head><body><p><strong>强调</strong></p><p><em>斜体</em></p>"
            + "<p><a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a>学习HTML!</p><p><font color=\"#aabb00\">颜色1"
            + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
            + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
            + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
            + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
            + "</p><p><font color=\"#00bbaa\">颜色2</p><h1>标题1</h1><h3>标题2</h3><h6>标题3</h6><p>大于>小于<</p><p>"
            + "下面是网络图片</p><img src=\"http://avatar.csdn.net/0/3/8/2_zhang957411207.jpg\"/></body></html>";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        html = "<html><head><title>TextView使用HTML</title></head><body><p><strong>强调</strong></p><p><em>斜体</em></p>"
                + "<p><a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a>学习HTML!</p><p><font color=\"#aabb00\">颜色1"
                + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
                + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
                + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
                + "</p><p><font color=\"#00bbaa\">颜色2</p><p><font color=\"#aabb00\">颜色1"
                + "</p><p><font color=\"#00bbaa\">颜色2</p><h1>标题1</h1><h3>标题2</h3><h6>标题3</h6><p>大于>小于<</p><p>"
                + "下面是网络图片</p><img src=\"http://avatar.csdn.net/0/3/8/2_zhang957411207.jpg\"/></body></html>";

        String ht2 = "<p>巴伦西亚阵容：内托/瓦斯、加拉伊、迪亚卡比、加亚/索莱尔(80′费兰·托雷斯)、帕雷霍、孔多比亚、格德斯(72′切雷舍夫)/罗德里戈、加梅罗(85′米纳)</p ><p>皇马阵容：纳瓦斯/奥德里奥索拉、瓦拉内、拉莫斯、马塞洛/莫德里奇、卡塞米罗、克罗斯(64′贝尔)、巴斯克斯(78′马里亚诺)、本泽马、阿森西奥(64′伊斯科)</p ><p>巴伦西亚阵容：内托/瓦斯、加拉伊、迪亚卡比、加亚/索莱尔(80′费兰·托雷斯)、帕雷霍、孔多比亚、格德斯(72′切雷舍夫)/罗德里戈、加梅罗(85′米纳)</p ><p>皇马阵容：纳瓦斯/奥德里奥索拉、瓦拉内、拉莫斯、马塞洛/莫德里奇、卡塞米罗、克罗斯(64′贝尔)、巴斯克斯(78′马里亚诺)、本泽马、阿森西奥(64′伊斯科)</p ><p>巴伦西亚阵容：内托/瓦斯、加拉伊、迪亚卡比、加亚/索莱尔(80′费兰·托雷斯)、帕雷霍、孔多比亚、格德斯(72′切雷舍夫)/罗德里戈、加梅罗(85′米纳)</p ><p>皇马阵容：纳瓦斯/奥德里奥索拉、瓦拉内、拉莫斯、马塞洛/莫德里奇、卡塞米罗、克罗斯(64′贝尔)、巴斯克斯(78′马里亚诺)、本泽马、阿森西奥(64′伊斯科)</p ><p>巴伦西亚阵容：内托/瓦斯、加拉伊、迪亚卡比、加亚/索莱尔(80′费兰·托雷斯)、帕雷霍、孔多比亚、格德斯(72′切雷舍夫)/罗德里戈、加梅罗(85′米纳)</p ><p>皇马阵容：纳瓦斯/奥德里奥索拉、瓦拉内、拉莫斯、马塞洛/莫德里奇、卡塞米罗、克罗斯(64′贝尔)、巴斯克斯(78′马里亚诺)、本泽马、阿森西奥(64′伊斯科)</p ><p><img src=\"http://dev.file.itplus.net.cn/upload/zhongrenlian/image/201904/04/6dfb4d23-fd8f-4bb1-a64c-54d4b30f4de4.jpg\" alt=\"测试1\" style=\"max-width:100%;\"></p ><p><br></p >";
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());// 设置可滚动
        tv.setMovementMethod(LinkMovementMethod.getInstance());//设置超链接可以打开网页
        //tv.setText(Html.fromHtml(ht2, new URLImageGetter(AAAA.this,tv), null));
        tv.setText(Html.fromHtml(ht2, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                LevelListDrawable d = new LevelListDrawable();
                Drawable empty = ContextCompat.getDrawable(AAAA.this,R.drawable.adapter_loading_error);
                d.addLevel(0, 0, empty);
                d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());

                new LoadImage(tv).execute(source, d);

                return d;
            }
        }, null));
    }

    public void findView() {
        tv = findViewById(R.id.tv_html);
        iv = findViewById(R.id.iv_glide);
    }


}
