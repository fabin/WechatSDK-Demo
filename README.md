# WechatSDK-Demo
A simple project demonstrate the error:
Error:Execution failed for task ':app:shrinkDebugMultiDexComponents'.
> java.io.IOException: Can't read [....../build/intermediates/multi-dex/debug/allclasses.jar] (Can't process class [com/tencent/wxop/stat/al.class] (Unknown verification type [95] in stack map frame)

为了避免UNEXPECTED TOP-LEVEL EXCEPTION:
 >   com.android.dex.DexIndexOverflowException: method ID not in [0, 0xffff]: 65536
 >  at com.android.dx.merge.DexMerger$6.updateIndex(DexMerger.java:502)

按照https://medium.com/@mustafa01ali/dexs-64k-limit-is-not-a-problem-anymore-well-almost-2b1faac3508 中的最后的“Using the official solution”这一块的解决办法做：
1. build.gradle 中加：multiDexEnabled true
2. DemoApplication 继承android.support.multidex.MultiDexApplication
然后点击“Run”按钮就会报错：
> Error:Execution failed for task ':app:shrinkDebugMultiDexComponents'.
> java.io.IOException: Can't read [....../build/intermediates/multi-dex/debug/allclasses.jar] (Can't process class [com/tencent/wxop/stat/al.class] (Unknown verification type [95] in stack map frame

本Demo要证明：libammsdk.jar与解决DEX’s 64k limit的方法冲突，也就是微信的libammsdk.jar有问题。

临时解决方法：在分支[Different-WeChat-Lib](https://github.com/fabin/WechatSDK-Demo/tree/Different-WeChat-Lib)的[libammsdk.jar](https://github.com/fabin/WechatSDK-Demo/blob/Different-WeChat-Lib/app/libs/libammsdk.jar)是从其他Project中中Copy过来的旧版本的jar，用这个旧版本的没问题。
（从com.tencent.mm.sdk.constants.SDK_INT看版本号是一样的，其实不是同一个版本）
