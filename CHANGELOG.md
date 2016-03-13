# Changelog

## 2016.03.13

- Made it each packages responsibility to generate the jar file
    - That is `package` task should run `pom` and `jar` tasks
    - This allows packages themselves to decide how many artifacts they create, e.g. React package can publish four artifacts to Clojars
