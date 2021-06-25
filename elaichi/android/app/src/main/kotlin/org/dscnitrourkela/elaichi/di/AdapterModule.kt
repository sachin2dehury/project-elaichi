package org.dscnitrourkela.elaichi.di

//
//@Module
//@InstallIn(ActivityRetainedComponent::class)
//object AdapterModule {
//
//    @ActivityRetainedScoped
//    @Provides
//    fun provideMailBoxAdapter(@ApplicationContext context: Context, colors: IntArray) =
//        MailBoxAdapter(context, colors)
//
//    @ActivityRetainedScoped
//    @Provides
//    fun provideMailItemsAdapter(
//        colors: IntArray,
//        attachmentAdapter: AttachmentAdapter
//    ) = MailItemsAdapter(
//        colors,
////        attachmentAdapter
//    )
//
//    @ActivityRetainedScoped
//    @Provides
//    fun providesAttachmentAdapter() = AttachmentAdapter()
//
//    @ActivityRetainedScoped
//    @Provides
//    fun provideWebChromeClient() = WebChromeClient()
//
//    @ActivityRetainedScoped
//    @Provides
//    fun provideColorList(@ApplicationContext context: Context) =
//        context.resources.getIntArray(R.array.colors)
//}