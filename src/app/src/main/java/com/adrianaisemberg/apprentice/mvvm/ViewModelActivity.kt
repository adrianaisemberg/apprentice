package com.adrianaisemberg.apprentice.mvvm

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.adrianaisemberg.apprentice.BR
import javax.inject.Inject

/**
 * base class for all activities with data-bindings
 *
 * @param TViewModel the type of the view-model
 * @param TViewBinding the type of the data-binding
 * @property layoutId the layout id of this activity
 */
abstract class ViewModelActivity<
        TViewModel : ActivityViewModel,
        TViewBinding : ViewDataBinding>(
    @LayoutRes val layoutId: Int,
) : AppCompatActivity() {

    /**
     * the view-model to be injected
     */
    @Inject
    lateinit var viewModel: TViewModel

    /**
     * the data-binding object which provides direct access to the named views contained in the activity
     */
    protected lateinit var binding: TViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<TViewBinding>(
            this,
            layoutId
        ).apply {
            lifecycleOwner = this@ViewModelActivity
            setVariable(BR.viewModel, viewModel)
        }
    }
}
