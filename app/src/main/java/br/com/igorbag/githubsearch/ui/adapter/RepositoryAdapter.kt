package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var cardItemListener: (Repository) -> Unit = {}
    var btnShareListener: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //@TODO 8 -  Realizar o bind do viewHolder
        //Exemplo de Bind
        //  holder.preco.text = repositories[position].atributo
        holder.repoName.text = repositories[position].name

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}

        // Exemplo de click no btn Share
        //holder.favorito.setOnClickListener {
        //    btnShareLister(repositores[position])
        //}

        holder.btnShare.setOnClickListener {
            btnShareListener(repositories[position])
        }

        holder.cardRepository.setOnClickListener {
            cardItemListener(repositories[position])
        }
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios
        //Exemplo:
        //val atributo: TextView

        //init {
        //    view.apply {
        //        atributo = findViewById(R.id.item_view)
        //    }

        val repoName: TextView
        val btnShare: ImageView
        val cardRepository: CardView

        init {
            repoName = view.findViewById(R.id.tv_repository_name)
            btnShare = view.findViewById(R.id.iv_share)
            cardRepository = view.findViewById(R.id.cv_repository)
        }

    }
}


