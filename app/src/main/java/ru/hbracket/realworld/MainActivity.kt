package ru.hbracket.realworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Conduit"

        val ctx = ComponentContext(this)
        val c = Text.create(ctx).text("jopa").build()


        setContentView(LithoView.create(ctx, c))
    }
}
