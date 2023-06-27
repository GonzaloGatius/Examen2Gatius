package com.example.examen2gatius

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import java.util.stream.Stream

class CategoriesAdapter(private val Category: List<String>): RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.textViewCategoryName)

        fun bind(category: String) {
            val uppercasecategory = category.uppercase()
            textView.text = uppercasecategory //antes tenia textViewCategoryName.text y me daba error, solucionado?
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflater.inflate(R.layout.itemlist, parent, false))
    }

    override fun getItemCount(): Int {
        return Category.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = Category[position]
        holder.bind(category)
    }
}


















//class CategoriesAdapter(val context: Context) : ListAdapter<Category, CategoriesAdapter.ViewHolder>(DiffCallBack) {
//
//    //lateinit var onItemClickListener: (Pokemon) -> Unit
//
//    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
//        private lateinit var textViewCategoryName: TextView
//
//        fun bind (Category: Locale.Category) {
//            textViewCategoryName = view.findViewById(R.id.textViewCategoryName)
//            textViewCategoryName.text = Category.toString()    //esto esta bien?
//
//            view.setOnClickListener {
//                onItemClickListener(Category)}
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.ViewHolder {
//        val view: View = LayoutInflater
//            .from(parent.context)
//            .inflate(R.layout.itemlist, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
//        val Category = getItem(position)
//        holder.bind(Category)
//    }
//
//    companion object DiffCallBack : DiffUtil.ItemCallback<Locale.Category>() {
//        override fun areItemsTheSame(oldItem: Locale.Category, newItem: Locale.Category): Boolean {
////            return  oldItem.id == newItem.id
//            return false
//        }
//
//        override fun areContentsTheSame(oldItem: Locale.Category, newItem: Locale.Category): Boolean {
//            return oldItem == newItem
//        }
//    }
//}












 /*
class CategoriesAdapter ( private val categories: List<String>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        private val category : ImageView = view.findViewById(R.id.textViewCategoryName)

        fun bind( category: String){
            //ACA EL PROFE BINDEA LA IMAGEN CON EL PICASSO, EN VEZ DE IMAGEN YO DEBERÍA TRAER EL TEXTO DEL CHISTE, NO? 00:56:40
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.itemlist, parent, false))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)

    }


}
*/
