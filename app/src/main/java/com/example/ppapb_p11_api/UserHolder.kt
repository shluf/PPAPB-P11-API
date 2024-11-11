package com.example.ppapb_p11_api

class UserHolder(private val binding: ItemMovieCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, onItemClick: (Movie) -> Unit) {
        binding.apply {
            tvTitle.text = movie.title
            tvDuration.text = movie.duration
            tvRating.text = movie.rating

            // Menggunakan Glide untuk load gambar
            Glide.with(itemView.context)
                .load(movie.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder_movie)
                .into(ivPoster)

            // Set onClick listener
            root.setOnClickListener {
                onItemClick(movie)
            }
        }
    }
}