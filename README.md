Servos
------

[![Build Status](https://magnum.travis-ci.com/twotoasters/servos.svg?token=w2dnq6rpzQyKVx2ZAHkY&branch=master)](https://magnum.travis-ci.com/twotoasters/servos)

A repo for small utilities that we often use in Android development. They are conveniently broken up into small modules for à la carte use.

### Modules

#### util

- A collection of small static utility classes

#### util-butterknife

- A collection of small utilities such as VisibilitySetter that are dependent upon ButterKnife 

#### util-otto

- Classes such as BusProvider and MainPostingBus that are dependent upon Otto

#### util-otto-retrofit

- Classes like one that helps management of the view's API request state that are dependent upon both Otto and Retrofit

#### util-picasso

- Classes such as bitmap transforms that are dependent upon Picasso

#### gradle-scripts

- Gradle scripts that can be directly applied in your build.gradle for checkstyle, signing, and uploading to Bintray

Download
--------

```groovy
compile 'com.twotoasters.servos:util:0.1.0'
compile 'com.twotoasters.servos:util-butterknife:0.1.0'
compile 'com.twotoasters.servos:util-otto:0.1.0'
compile 'com.twotoasters.servos:util-otto-retrofit:0.1.0'
compile 'com.twotoasters.servos:util-picasso:0.1.0'
```

License
-------

    Copyright 2015 Two Toasters

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
