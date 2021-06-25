package org.dscnitrourkela.elaichi.ui.fragments

//
//@AndroidEntryPoint
//class SplashFragment : Fragment(R.layout.fragment_splash) {
//
//    private val viewModel: SplashViewModel by viewModels()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        subscribeToObservers()
//    }
//
//    private fun subscribeToObservers() {
//        viewModel.isLoggedIn.observe(viewLifecycleOwner, {
//            it?.let {
//                val navOptions = NavOptions.Builder()
//                    .setPopUpTo(R.id.splashFragment, true)
//                    .build()
//                when (it) {
//                    true -> findNavController().navigate(
//                        NavGraphDirections.actionToMailBoxFragment(),
//                        navOptions
//                    )
//                    false -> findNavController().navigate(
//                        NavGraphDirections.actionToAuthFragment(),
//                        navOptions
//                    )
//                }
//            }
//        })
//    }
//}