# Exercism.io

For the new version of exercism, 3.0.9, you must reconfigure the working directory if you want it to
match the old location.

For reference:

```shell
$ exercism troubleshoot
```

```shell
$ exercism configure
```

```
You have configured the Exercism command-line client:

Config dir:                       /Path/to/.config/exercism
Token:         (-t, --token)      62********************************35
Workspace:     (-w, --workspace)  /Path/to/Exercism
API Base URL:  (-a, --api)        https://api.exercism.io/v1
```

```shell
$ exercism configure -w /Path/to/previous/working/directory/
```

Then:

```shell
$ exercism download --exercise=EXERCISE --track=LANGUAGE
```

### Formatting

For Java exercises: https://github.com/google/google-java-format
This only uses two spaces for indentation.

```shell
$ java -jar /path/to/google-java-format-1.6-all-deps.jar <options> [files...]
```

`-i` modifies the file to the formatting standard.

```shell    
$ java -jar /path/to/google-java-format-1.6-all-deps.jar -i [files...]
```

For Ruby exercises: https://github.com/rubocop-hq/rubocop
```shell
$ rubocop [files...]*
```