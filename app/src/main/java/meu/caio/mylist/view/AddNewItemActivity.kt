package meu.caio.mylist.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import meu.caio.mylist.R
import meu.caio.mylist.databinding.ActivityAddNewItemBinding
import meu.caio.mylist.model.ItemModel
import com.example.mylist.viewmodel.AddNewItemViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class AddNewItemActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAddNewItemBinding
    private lateinit var viewModel: AddNewItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AddNewItemViewModel::class.java]

        binding.saveButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.save_button) {
            val name = binding.editName.text.toString()
            val quantity = binding.editQuantity.text.toString()

            if (name.isNotEmpty() && quantity.isNotEmpty()) {
                val model = ItemModel().apply {
                    this.name = name
                    this.quantity = quantity.toInt()
                    this.id = 0
                }

                viewModel.insertItem(model)
                finish()
            } else {
                Snackbar.make(binding.newItemActivity, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(getColor(R.color.red))
                    .show()
            }
        }
    }
}