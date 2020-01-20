package ru.hbracket.realworld.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.view_article_card.view.*
import ru.hbracket.realworld.R
import ru.hbracket.realworld.models.Article

class ArticleCardView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        addView(View.inflate(context, R.layout.view_article_card, this))
    }

    fun bind(article: Article) {
        // TODO: glide
        view_article_author_name.text = article.author.username
        view_article_creation_date.text = article.createdAt
        view_article_title.text = article.title
        view_article_teaser.text = article.description
    }

}