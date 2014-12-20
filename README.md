## Servos

[![Build Status](https://magnum.travis-ci.com/twotoasters/servos.svg?token=w2dnq6rpzQyKVx2ZAHkY&branch=master)](https://magnum.travis-ci.com/twotoasters/servos)

A repo for small utilities that we often use in Android Development. They are conveniently broken up into small modules for à la carte use. Modules can be brought in by adding `compile com.twotoasters.servos:<module-name>:0.0.+` to your Gradle build config file.

### Modules

#### util

- A collection of small static utility classes

#### util-otto

- Classes such as BusProvider and MainPostingBus that are dependent upon Otto

#### util-picasso

- Classes such as bitmap transforms that are dependent upon Picasso

#### util-otto-retrofit

- Classes like one that helps management of the view's API request state that are dependent upon both Otto and Retrofit