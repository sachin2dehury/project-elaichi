package org.dscnitrourkela.elaichi.ui.fragments

//
//@AndroidEntryPoint
//class AuthFragment : Fragment(R.layout.fragment_auth) {
//
//    private var _binding: FragmentAuthBinding? = null
//    private val binding: FragmentAuthBinding get() = _binding!!
//
//    private val viewModel: AuthViewModel by viewModels()
//
//    private var credential: String? = null
//
//    @SuppressLint("SourceLockedOrientationActivity")
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        _binding = FragmentAuthBinding.bind(view)
//
//        viewModel.resetLogin()
//
//        binding.buttonLogin.setOnClickListener {
//            getCredential()
//            credential?.let { it1 -> viewModel.login(it1) }
//            binding.root.hideKeyBoard()
//        }
//
//        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
//
//        subscribeToObservers()
//
//        binding.buttonPrivacyPolicy.setOnClickListener {
//            findNavController().navigate(NavGraphDirections.actionToWebViewFragment(getString(R.string.privacy_policy)))
//        }
//    }
//
//    private fun redirectFragment() {
//        val navOptions = NavOptions.Builder()
//            .setPopUpTo(R.id.authFragment, true)
//            .build()
//        findNavController().navigate(
//            NavGraphDirections.actionToMailBoxFragment(),
//            navOptions
//        )
//    }
//
//    private fun getCredential() {
//        val roll = binding.editTextUserRoll.text.toString().lowercase(Locale.ROOT)
//        val password = binding.editTextUserPassword.text.toString()
//        credential = Credentials.basic(roll, password)
//    }
//
//    private fun subscribeToObservers() {
//        viewModel.loginStatus.observe(viewLifecycleOwner, { result ->
//            result?.let {
//                when (result.status) {
//                    Status.SUCCESS -> {
//                        view?.showSnackbar("Successfully logged in")
//                        viewModel.saveLogIn()
//                        redirectFragment()
//                    }
//                    Status.ERROR -> {
//                        view?.showSnackbar(it.message ?: "An unknown error occurred")
//                    }
//                    Status.LOADING -> {
//                        view?.showSnackbar("Loading...")
//                    }
//                }
//            }
//        })
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
//}