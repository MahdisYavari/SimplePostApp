package com.example.interviewtestapp.tools.network

//@Singleton
//class AppInterceptor : Interceptor {
//
//    companion object {
////        lateinit var settingService: SettingService
//    }
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        val requestBuilder: Request.Builder = request.newBuilder()
////        addUrl(request, requestBuilder)
//        return chain.proceed(requestBuilder.build())
//    }
//
//    private fun addUrl(request: Request, requestBuilder: Request.Builder) {
////        val server = settingService.serverObserver.value
//        var newUrl: HttpUrl? = null
//        try {
//            newUrl = server?.port?.toInt()?.let {
//                request
//                    .url()
//                    .newBuilder()
//                    .scheme("http")
//                    .host(server.ip)
//                    .port(it)
//                    .build()
//            }
//        } catch (e: Exception) {
//            Log.d("tagNewUrl", "exception = " + e.message.toString())
//        }
//
//        if (newUrl != null) {
//            requestBuilder.url(newUrl)
//        }
//    }
//}