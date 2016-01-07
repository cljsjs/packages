GIT_REPO=git@github.com:google/incremental-dom.git
TAG=0.3

clean:
	rm -rf work

work:
	mkdir work

work/incremental-dom: work
	cd work; git clone $(GIT_REPO);
	cd work/incremental-dom; git checkout tags/$(TAG)

work/incremental-dom/node_modules: work/incremental-dom
	cd work/incremental-dom; npm install

work/incremental-dom/patched-gulpfile.js: work/incremental-dom
	patch work/incremental-dom/gulpfile.js gulpfile.js.patch -o work/incremental-dom/patched-gulpfile.js

work/incremental-dom/dist/incremental-dom-closure-provides.js: work/incremental-dom/node_modules work/incremental-dom/patched-gulpfile.js
	cd work/incremental-dom; ./node_modules/.bin/gulp --gulpfile=patched-gulpfile.js js-closure-provides
