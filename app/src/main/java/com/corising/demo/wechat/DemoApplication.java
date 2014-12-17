package com.corising.demo.wechat;

import android.support.multidex.MultiDexApplication;

/**
 * Application that extends MultiDexApplication to avoid DEX’s 64k limit.
 * <p/>
 * See section <i>Using the official solution</i> in <a href="https://medium.com/@mustafa01ali/dexs-64k-limit-is-not-a-problem-anymore-well-almost-2b1faac3508">https://medium.com/@mustafa01ali/dexs-64k-limit-is-not-a-problem-anymore-well-almost-2b1faac3508</a>
 * Created by fabin on 12/17/14.
 */
public class DemoApplication extends MultiDexApplication {
}
