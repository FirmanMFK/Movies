package id.firman.movies.movie

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.firman.movies.R
import id.firman.movies.detail.DetailActivity
import id.firman.movies.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val context: Context?) : ListAdapter<Movie, MovieAdapter.ViewHolder>(
    MovieDiffCallback()
) {

    override fun submitList(list: List<Movie>?) {
        if (list != null) {
            notifyDataSetChanged()
        }
        super.submitList(list)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = (LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
        return ViewHolder(root)
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        init {
            itemView?.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("id", getItem(adapterPosition).id)
                    context?.let { it1 -> startActivity(it1, intent, null) }
                }
            }
        }

        fun bind(movie: Movie) = with(itemView) {
            title.text = movie.title
            Glide.with(context).load(movie.getPosterUrl()).into(poster)
        }
    }
}