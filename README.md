# ViewPagerTranformer
A collection of view pager transformers (animation when swipe between pages).

This forked from https://github.com/geftimov/android-viewpager-transformers but extended and add some useful methods, and convert all to kotlin language.

## Download
```java
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

```java
dependencies {
    implementation 'com.github.VuHongKy:ViewPagerTranformer:v1.0'
}
```

## Use:
```java
// Reference (or instantiate) a ViewPager instance and apply a transformer
pager = (ViewPager) findViewById(R.id.container);
pager.setAdapter(mAdapter);
pager.setPageTransformer(true, new RotateUpTransformer());
```

# List of transformers
- [AccordionTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/AccordionTransformer.kt)
- [BackgroundToForegroundTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/BackgroundToForegroundTransformer.kt)
- [BaseTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/BaseTransformer.kt)
- [CubeInTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/CubeInTransformer.kt)
- [CubeOutTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/CubeOutTransformer.kt)
- [DefaultTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/DefaultTransformer.kt)
- [DepthPageTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/DepthPageTransformer.kt)
- [DrawFromBackTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/DrawFromBackTransformer.kt)
- [FlipHorizontalTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/FlipHorizontalTransformer.kt)
- [FlipVerticalTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/FlipVerticalTransformer.kt)
- [ForegroundToBackgroundTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/ForegroundToBackgroundTransformer.kt)
- [ParallaxPageTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/ParallaxPageTransformer.kt)
- [RotateDownTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/RotateDownTransformer.kt)
- [RotateUpTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/RotateUpTransformer.kt)
- [StackTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/StackTransformer.kt)
- [TabletTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/TabletTransformer.kt)
- [ZoomInTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/ZoomInTransformer.kt)
- [ZoomOutSlideTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/ZoomOutSlideTransformer.kt)
- [ZoomOutTransformer](https://github.com/VuHongKy/ViewPagerTranformer/blob/master/pagertransformerlibrary/src/main/java/vn/beautylife/pagertransformerlibrary/ZoomOutTransformer.kt)

# Special thanks to
[daimajia](https://github.com/daimajia/AndroidImageSlider)

[ToxicBakery](https://github.com/ToxicBakery/ViewPagerTransforms)

[geftimov](https://github.com/geftimov/android-viewpager-transformers)

# License
```
MIT License

Copyright (c) 2018 VuHongKy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
