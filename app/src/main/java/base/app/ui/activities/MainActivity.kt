package base.app.ui.activities

import android.os.Bundle
import base.app.R
import base.presentation.viewmodels.items.ItemsVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity :
        BaseItemActivity() {
     private val itemsVM: ItemsVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

