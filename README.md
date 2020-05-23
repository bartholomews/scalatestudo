[![CircleCI](https://circleci.com/gh/bartholomews/scalatestudo/tree/master.svg?style=svg)](https://circleci.com/gh/bartholomews/scalatestudo/tree/master)
[![License: MIT](https://img.shields.io/badge/License-MIT-maroon.svg)](https://opensource.org/licenses/MIT)

# scalatestudo
Test library with utils for [fsclient](https://github.com/bartholomews/fsclient)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.bartholomews/scalatestudo_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.bartholomews/scalatestudo_2.13)

```
libraryDependencies += "io.bartholomews" %% "scalatestudo" % "<VERSION>"
```

### CI/CD Pipeline

This project is using [sbt-ci-release](https://github.com/olafurpg/sbt-ci-release) plugin:
 - Every push to master will trigger a snapshot release.  
 - In order to trigger a regular release you need to push a tag:
 
    ```bash
    ./scripts/release.sh v0.0.1
    ```
 
 - If for some reason you need to replace an older version (e.g. the release stage failed):
 
    ```bash
    TAG=v0.0.1
    git push --delete origin ${TAG} && git tag --delete ${TAG} \
    && ./scripts/release.sh ${TAG}
    ```