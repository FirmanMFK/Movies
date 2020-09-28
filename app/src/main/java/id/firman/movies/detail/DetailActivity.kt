package id.firman.movies.detail

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import id.firman.movies.App
import id.firman.movies.BuildConfig
import id.firman.movies.R
import id.firman.movies.model.MovieDetail
import id.firman.movies.model.YoutubeVideo
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_overview.*
import kotlinx.android.synthetic.main.movie_wrapper.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailView {
    @Inject
    lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        (applicationContext as App).createDetailComponent().inject(this)

        val id = intent.getStringExtra("id")
        setupToolbar()
        initLayout()
        presenter.setView(this, id!!)
        makeStatusBarTransparant()
    }

    private fun makeStatusBarTransparant() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.apply {
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    decorView.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                }
                statusBarColor = Color.TRANSPARENT
            }
        }
    }

    private fun setupToolbar(){
        setSupportActionBar(appbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar.setExpandedTitleMargin(50, 50, 250, 50)
    }

    override fun showMovieDetails(movies: MovieDetail?) {
        val rateAvg = movies?.voteAverage?.div(2)
        loading.visibility = View.GONE
        collapsingToolbar.title = movies?.title
        overview?.text = movies?.overview
        rate?.text = movies?.voteAverage.toString()
        vote_count?.text = movies?.voteCount.toString()
        release_date?.text = movies?.releaseDate
        runtime?.text = movies?.runtime.toString()
        if (rateAvg != null) {
            rating_bar.rating = rateAvg.toFloat()
        }
        Glide.with(this)
            .load(movies?.getPosterUrl())
            .into(poster)
        (genre_list.adapter as GenreAdapter).addGenre(movies?.genres)
    }

    override fun getVideos(videos: List<YoutubeVideo>?) {
        val key = videos?.get(0)?.key
        watch_trailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.YOUTUBE+key))
            startActivity(intent)
        }
    }

    private fun initLayout() {
        genre_list.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        genre_list.layoutManager = layoutManager
        genre_list.setHasFixedSize(true)
        genre_list.adapter = GenreAdapter()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
