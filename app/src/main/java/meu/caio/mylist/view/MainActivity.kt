package meu.caio.mylist.view

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import meu.caio.mylist.R
import meu.caio.mylist.adapter.ItemsAdapter
import meu.caio.mylist.databinding.ActivityMainBinding
import meu.caio.mylist.listeners.ItemListener
import com.example.mylist.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = ItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recyclerAllItems.layoutManager = LinearLayoutManager(applicationContext)

        binding.recyclerAllItems.adapter = adapter

        observers()

        val listener = object : ItemListener {
            override fun onClick(id: Int) {
                viewModel.deleteItem(id)
                viewModel.getAllItems()
            }

            override fun onLongClick(id: Int) {
                TODO("Not yet implemented")
            }

        }

        adapter.attachListener(listener)

        val privacyPolicy = binding.textPrivacyPolicy

        privacyPolicy.text = HtmlCompat.fromHtml(
            "<a href=\"https://devcaior.blogspot.com/2024/05/politica-de-privacidade-este-aplicativo.html\">Política de Privacidade</a>",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
        privacyPolicy.movementMethod = LinkMovementMethod.getInstance()


        binding.imageNewItem.setOnClickListener(this)
        binding.imageDeleteAll.setOnClickListener(this)
    }

    private fun observers() {
        viewModel.items.observe(this) {
            adapter.updateItems(it)
        }
    }

    override fun onResume() {
        viewModel.getAllItems()
        super.onResume()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.image_new_item -> {
                startActivity(Intent(this, AddNewItemActivity::class.java))
            }

            R.id.image_delete_all -> {
                AlertDialog.Builder(this)
                    .setTitle("Limpar a lista")
                    .setMessage("Tem certeza que deseja excluir todos os itens?")
                    .setPositiveButton("Sim") { _, _ ->
                        viewModel.deleteAllItems()
                        viewModel.getAllItems()
                    }
                    .setNegativeButton("Não", null)
                    .show()
            }
        }
    }
}