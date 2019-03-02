#!/bin/bash

name=$1
old_version=$2
new_version=$3

(
cd "$name" || exit

sed -i "s/$old_version/$new_version/" build.boot

package_json=$(curl -sS "https://unpkg.com/$name@$new_version/package.json")
scm=$(echo "$package_json" | jq -r '.repository.url')
regex='https://github.com/([^/]*)/([^/]*)'
[[ $scm =~ $regex ]] && organisation=${BASH_REMATCH[1]}

changelog=$(curl -sS "https://raw.githubusercontent.com/$organisation/$name/master/CHANGELOG.md" | sed "/^## $new_version/,/^## .*/!d;//d")

# Wrap changelog in codeblock to disable github references to authors or issues/prs
message="Update $name to $new_version\n\n## $old_version => $new_version\n\`\`\`$changelog\n\`\`\`"

# FIXME: Need way to automatically accept changed checksums
boot package

git add build.boot boot-cljsjs-checksums.edn

git checkout -b "$name-$new_version"
git commit -m "$(echo -e "$message")"
git push origin HEAD
# TODO: Open pull request
)
