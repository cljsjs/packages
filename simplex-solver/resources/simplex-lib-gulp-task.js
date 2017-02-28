// Javascript lib
gulp.task('js-lib', function() {
  var appConfig = _.pick(config, 'env');
  return combineWatch([
    gulp.src(['simplex-solver.inc.js']),
    browserify({
      debug: false,
      insertGlobals: true,
      insertGlobalVars: {
        config: function () {
          return JSON.stringify(appConfig);
        }
      }
    }),
    gulp.dest('dist/lib'),
    uglify(),
    gulp.dest('dist/lib/min')
  ]);
});
